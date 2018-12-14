package email_template;

import util.Email;

public abstract class emailTemplateBase {
    String addrto;
    String subject;
    String content;

    emailTemplateBase(String addrto,String subject){
        this.addrto=addrto;
        this.subject=subject;
    }

    abstract void genContent();

    void send(){
        genContent();
        Email email=new Email();
        email.setAddr_to(addrto);
        email.setSubject(subject);
        email.setContent(content);
        try{
            email.SendEmail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
