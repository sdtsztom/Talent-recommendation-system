package MVC.Service;

import MVC.DAO.RecommendDAO;
import MVC.DAO.StuffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PropertyUtil;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService{


    @Autowired
    RecommendDAO recommendDAO;

    @Autowired
    StuffDAO stuffDAO;

    @Override
    public void sentMail(String to,String sub,String con) throws Exception{
        //从mail.properties中读取账号密码邮件内容
        PropertyUtil.loadProps("mail.properties");
        Properties prop = new Properties();
        prop.setProperty("mail.host", PropertyUtil.getProperty("port"));
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(prop);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect(PropertyUtil.getProperty("port"), PropertyUtil.getProperty("username"), PropertyUtil.getProperty("password"));

        MimeMessage message = new MimeMessage(session);
        //发件人
        message.setFrom(new InternetAddress(PropertyUtil.getProperty("username")));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));//"837070594@qq.com"));
        //主题
        message.setSubject(PropertyUtil.getProperty(sub));
        //内容
        message.setContent(PropertyUtil.getProperty(con), "text/html;charset=UTF-8");
        //发送
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
