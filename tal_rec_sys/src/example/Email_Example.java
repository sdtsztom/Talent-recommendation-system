package example;

import util.Email;
//多次运行会被识别成垃圾邮件无法发送
public class Email_Example {
    public static void main(String []args) {

        Email email = new Email();
        email.setAddr_to("1044203335@qq.com");//收件人
        email.setSubject("积分赛开跑啦");//标题
        email.setContent("积分活动开跑啦,只需存款100,无须流水直接提活动9/3～12/17止 , 积分可直接换现金.");//内容
        try{
            email.SendEmail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
