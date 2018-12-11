package com.yantianpeng.G7Code;

import com.yantianpeng.Utils.StringUtils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**

* @Description:   G7参数处理工具类

* @Author:        yantianpeng

* @CreateDate:     2018/11/27 下午3:42


*/
public class ParamUtil {

//########################### 测试类begin##############################################################
    public static void main(String[] args) {
       Map<String,Object> map = new HashMap<>();
       String app_key = "apitest";
       String app_secret = "ab179020b82d2fdcd4cea176796f7156";
       String  method = "ips2.api.currentStatus";
       String    timestamp = "2012-09-19 19:12:05";
       String data = "{\"carnum\":\"京A09999\"}";
       map.put("app_key",app_key);
       map.put("method",method);
       map.put("timestamp",timestamp);
       map.put("data",data);

        String sign = sign(map, app_secret);
        System.out.println(sign);
    }
//###########################测试类 end##############################################################

//##############################签名算法begin######################################################
    /**
     *签名算法
     * @param params
     * @param secret
     * @return
     */
    public static String sign(Map<String,Object> params,String secret){
        String result =null;
        if(params==null || StringUtils.IsEmptyOrNull(secret)) return result;
        //将参数按可以排序
        //首先将每一个参数名称按字母顺序做升序排序，然后根据排序好的参数依次把每个参数名与参数值合并拼成一个字符串。
        //比如现在三个参数及值，foo=1,bar=2,baz=3进行拼装，则：
        //a)	排序所有参数，排序后的结果为 bar=2,baz=3,foo=1。
        //b)	按顺序进行拼装，拼装后结果为 bar2baz3foo1
        Set<String> keys = params.keySet();
        String [] ps =new String[keys.size()];
        int  i = 0;
        for(String key: keys){
            Object value = params.get(key);
            if(value!=null){
                ps[i++] = key+value.toString();
            }
        }
        if(i==0) return result;
        String [] strings = new String[i];
        System.arraycopy(ps,0,strings,0,i);
        Arrays.sort(strings);
       // System.out.println(strings.toString());
        //secret 同时拼接在字符串的头部和尾部
        StringBuilder stringBuilder = new StringBuilder(secret);
        for (int j = 0; j <strings.length ; j++) {
            stringBuilder.append(strings[j]);
        }
        stringBuilder.append(secret);
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            result  = byte2hex(messageDigest.digest(stringBuilder.toString().getBytes("UTF-8")));
        }catch (Exception ex){
            throw  new RuntimeException("sign error!");
        }
        return result;
    }
//##############################签名算法end######################################################


//##############################byte2hex  beging######################################################

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
//##############################byte2hex  end######################################################

// ##############################参数组装begin######################################################
    /**
     * 参数组装
     * @param params
     * @param method
     * @param appkey
     * @param appsecret
     * @return
     */
    public static Map<String,Object> dealParams(Map<String,Object> params,String method,String appkey,String appsecret){
        params.put("app_key",appkey);
        params.put("method",method);
        params.put("timestamp",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String sign = sign(params,appsecret);
        params.put("sign",sign);
        return  params;
    }
    // ##############################参数组装end######################################################

}
