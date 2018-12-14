package email_template;

import util.Email;

public abstract class emailTemplateBase {
    String addrto;
    String subject;
    String content;

    public emailTemplateBase(String addrto){
        this.addrto=addrto;
    }

    abstract void setSubject();
    abstract void genContent();

    public void send(){
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
