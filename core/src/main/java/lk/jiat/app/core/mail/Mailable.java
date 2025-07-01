package lk.jiat.app.core.mail;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lk.jiat.app.core.provider.MailServiceProvide;

public abstract class Mailable implements Runnable {
    private MailServiceProvide mailServiceProvide;

    public Mailable(){
        mailServiceProvide = MailServiceProvide.getInstance();
    }

    @Override
    public void run() {
        try {
            Session session = Session.getInstance(mailServiceProvide.getProperties(),
                    mailServiceProvide.getAuthenticator());

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("app@j2ee.example.com"));
            build(message);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public abstract void build(Message message) throws Exception;
}
