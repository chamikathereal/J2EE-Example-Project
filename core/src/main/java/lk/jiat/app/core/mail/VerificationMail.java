package lk.jiat.app.core.mail;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;

public class VerificationMail extends Mailable{

    private String to;
    private String verification;

    public VerificationMail(String to, String verification) {
        this.to = to;
        this.verification = verification;
    }

    @Override
    public void build(Message message) throws Exception {
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        //
        message.setText("Hello Dev, your verification code is " + verification);
        //message.setSubject(verification, "text/html"; );
    }
}
