package util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Email{

    private static final String account = "m13372407504@163.com";
    private static final String pwd = "qazsxdrfvgbhu123";
    private static final String addr_from = "m13372407504@163.com";
    private static String addr_to;
    private static String subject;
    private static String content;

    public Email() { }

    public void SendEmail() throws Exception{
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();

        //设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");

        //设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");

        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.163.com");

        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);

        //设置调试信息在控制台打印出来
        session.setDebug(true);

        //3、创建邮件的实例对象
        Message msg = getMimeMessage(session);

        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();

        //设置发件人的账户名和密码
        transport.connect(account, pwd);

        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg,msg.getAllRecipients());

        //5、关闭邮件连接
        transport.close();
    }
    /**
     * 获得创建一封邮件的实例对象
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */

    private MimeMessage getMimeMessage(Session session) throws Exception{

        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);

        //设置发件人地址
        msg.setFrom(new InternetAddress(addr_from));

        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */

        msg.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(addr_from));
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(addr_to));
        msg.setSubject(subject,"UTF-8");
        msg.setContent(content, "text/html;charset=UTF-8");

        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());

        return msg;
    }

    public void setAddr_to(String NewAddress){
        addr_to = NewAddress;
    }

    public void setSubject(String NewSubject){
        subject = NewSubject;
    }

    public void setContent(String NewContent){
        content = NewContent;
    }
}
