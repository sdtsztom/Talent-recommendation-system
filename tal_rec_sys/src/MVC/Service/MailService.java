package MVC.Service;

public interface MailService {

    void sentMail(String to,String sub,String con) throws Exception;

}
