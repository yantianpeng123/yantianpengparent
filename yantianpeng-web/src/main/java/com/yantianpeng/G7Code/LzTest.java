package com.yantianpeng.G7Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LzTest {

    public static void main(String[] args) {
        test01();
    }
public static  String app_key="qykd_adminTest";
public static String app_secret ="2e5d74cf8403b7f61966fab2f7b0abdd";
public static String routerUrl ="http://demo.api.g7s.chinawayltd.com/interface/index.php";
    public static void test01(){
        String adress ="上海市青浦区崧泽大道7508号";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        StringBuilder dataSb = new StringBuilder();
        String getTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dataSb.append("{\"data\":\"");
        dataSb.append("[");
        dataSb.append("{");
        dataSb.append("\\\"address\\\":\\\"" + adress + "\\\",");
        dataSb.append("\\\"type\\\":\\\"51110\\\",");
        dataSb.append("\\\"uuid\\\":\\\"" +uuid +"\\\"");
        dataSb.append("}");
        dataSb.append("]");
        dataSb.append("\"}");

        String urlParam = getURLParam(dataSb.toString(), getTime);
        sendTest(urlParam,routerUrl);
    }


    public static String getURLParam(String dataStr,String nowTime){
        String method="map.api.areaMatch";
        String s="";
        String URLParam = "timestamp=" + nowTime + "&data=" + dataStr
                + "&method=" + method + "&app_key=" + app_key + "&sign="
                + getSign(dataStr, nowTime);
        try{
            s= encodeUrl(URLParam);
        }catch (Exception ex){

        }
        return  s;
    }

    public static String getSign(String dataStr,String nowTime){
        String signMD5 = "";
        String sign = app_secret + "app_key" + app_key + "data" + dataStr
                + "methodmap.api.areaMatchtimestamp" + nowTime + app_secret;
        signMD5 = encodeByMD5(sign);
        return signMD5;
    }


    public static String encodeByMD5(String originString){
        String result ="";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            result  = byte2hex(messageDigest.digest(originString.getBytes("UTF-8")));
        }catch (Exception ex){
            throw  new RuntimeException("sign error!");
        }
        return result;
    }


    public static String encodeUrl(String string)throws Exception{
        StringBuilder sb = new StringBuilder();
        int start = 0;
        char [] c = string.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            if(c[i]=='='||c[i]=='&'||c[i]=='{'||c[i]=='}'||c[i]==':'||c[i]=='('||c[i]==')'||
            c[i]=='/'||c[i]=='\\'||c[i]==','){
                String ss =  string.substring(start,(i-start));
                String kk = URLDecoder.decode(ss,"utf-8");
                if(ss==kk){
                    sb.append(ss);
                }else{
                    sb.append(kk.toUpperCase());
                }
                sb.append(c[i]);
                start = i+1;
            }
        }
        if(start<string.length()){
            sb.append(URLDecoder.decode(string.substring(start),"utf-8"));
        }

        return sb.toString().replace("+","%20");
    }

    private static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    public static String sendTest(String urlParams,String url){
        {
            // ParamUtil.sign(params,new AllAdressUtil().getProperties("G7_interfaceurl"));
            OutputStreamWriter out = null;
            BufferedReader in = null;
            StringBuilder result = new StringBuilder();
            try{
                URL realUrl = new URL(url);
                HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                // POST方法
                conn.setRequestMethod("POST");
                // 设置通用的请求属性
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("user-agent", "deneb-core");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.connect();
                out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                //String dealParams = dealParams(params,url);
                // String decode = URLDecoder.decode(dealParams, "utf-8");
                out.write(urlParams);
                // flush输出流的缓冲
                out.flush();
                // 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }finally{
                try{
                    if(out!=null){
                        out.close();
                    }
                    if(in!=null){
                        in.close();
                    }
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            return  result.toString();
        }
    }
}
