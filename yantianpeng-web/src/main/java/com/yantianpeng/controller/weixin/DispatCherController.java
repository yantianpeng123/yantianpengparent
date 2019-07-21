package com.yantianpeng.controller.weixin;

import com.yantianpeng.common.CheckUtil;
import com.yantianpeng.common.TextMessage;
import com.yantianpeng.common.XmlUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@RestController
public class DispatCherController {

    /**
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp	时间戳
     * nonce	随机数
     * echostr	随机字符串
     * @return
     */
    @RequestMapping("/dispCherGet")
    public String dispCherGet(String signature,String timestamp,String nonce,String echostr){


        System.out.println("微信加密签名："+signature);
        System.out.println("时间戳："+timestamp);
        System.out.println("随机数："+nonce);
        System.out.println("随机字符串："+echostr);
        boolean b = CheckUtil.checkSignature(signature, timestamp, nonce);
        System.out.println(b);
        if(!b) return null;
        return echostr;

    }


    @PostMapping("/dispCherGet")
    public void dispatCherGet(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> stringStringMap = XmlUtils.parseXml(request);
        String msgType = stringStringMap.get("MsgType");
        // 3.如果是文本类型，返回结果给微信服务端
        PrintWriter writer = response.getWriter();
        switch (msgType){
            case "text":
                String toUserName = stringStringMap.get("ToUserName");
                String fromUserName = stringStringMap.get("FromUserName");
                String content = stringStringMap.get("Content");
                String msg= null;
                if("你好".equals(content)){
                    msg=setText("你好",toUserName,fromUserName);
                }else if("李敏".equals(content)||"李慧勤".equals(content)){
                       msg=setText("你好，二狗",toUserName,fromUserName);
                }else if("闫天蓬".equals(content)||"闫天鹏".equals(content)){
                    msg=setText("你好，大帅哥",toUserName,fromUserName);
                }
                else{
                    msg=setText("在忙等会回复你",toUserName,fromUserName);
                }
               writer.print(msg);
                break;
             default:
                break;

        }
        writer.close();


    }


    public String setText(String content, String fromUserName, String toUserName) {
        TextMessage textMessage = new TextMessage();
        textMessage.setContent(content);
        textMessage.setMsgType("text");
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setFromUserName(fromUserName);
        textMessage.setToUserName(toUserName);
        // 将实体类转换成xml格式
        String msg = XmlUtils.messageToXml(textMessage);
        return msg;
    }
}
