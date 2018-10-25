package com.yantianpeng.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**

* @Description:   Java生成验证码

* @Author:        yantianpeng

* @CreateDate:     2018/10/25 下午8:59


*/
public class VerificationCodeImg {
    private static int width = 90 ;//定义图片的width；
    private static int heigth = 20;//定义图片的heigth；
    private static int codeCount = 4; //验证码的个数；
    private static int xx= 15;
    private static int fontHeigth = 18;//字体的高度
    private static int codeY = 18;//Y轴偏移量
    private static char [] codeSequece={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};//生成的验证码


    public static Map<String ,Object> generateCodeAndPic(){
        //定义图像Buffer
        BufferedImage bufferedImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Random random = new Random();//创建一个随机数生成器；
        graphics.setColor(Color.WHITE);//颜色设置为白色
        graphics.fillRect(0,0,width,heigth);
        //创建字体，字体的大小应该根据图片的高度确定。
        Font fixedsys = new Font("Fixedsys", Font.BOLD, fontHeigth);
        //设置字体
        graphics.setFont(fixedsys);
        //画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width-1,heigth-1);
        //随机产生40条干扰线，使图像中的认证吗不容易被其他的程序探测到
        graphics.setColor(Color.BLACK);
        for (int i = 0; i <40 ; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(heigth);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            graphics.drawLine(x,y,x +x1,y+y1);
        }
        //buffer用于保存随机产生的验证码，以便用户登录后验证
        StringBuffer buffer = new StringBuffer();
        int red = 0 ,  gree = 0,blue = 0;
        //随机产生codeCount个数字验证码
        for (int i = 0; i <codeCount ; i++) {
            //得到随机验证码
            String code = String.valueOf(codeSequece[random.nextInt(36)]);
            //产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都是不同的
            red =random.nextInt(255);
            gree = random.nextInt(255);
            blue =random.nextInt(255);
            //将随机产生的颜色将验证码绘制到图像中。
            graphics.setColor(new Color(red,gree,blue));
            graphics.drawString(code,(i+1)*xx,codeY);
            //随机产生的数组合到一起
            buffer.append(code);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        //存放验证码
        map.put("code",buffer);
        map.put("codePic",bufferedImage);
        return  map;
    }

    public static void main(String[] args) throws Exception{
        //创建文件输出流。
        OutputStream outputStream = new FileOutputStream("\\Users\\yantianpeng\\Desktop\\"+System.currentTimeMillis()+".jpg");
        Map<String,Object> map = VerificationCodeImg.generateCodeAndPic();
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", outputStream);
        System.out.println("验证码："+map.get("code"));
    }
}
