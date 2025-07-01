package lk.jiat.app.core.mail;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;

public class VerificationMail extends Mailable{
    private String to;
    private String verificationCode;

    public VerificationMail(String to, String verificationCode) {
        this.to = to;
        this.verificationCode = verificationCode;
    }

    @Override
    public void build(Message message) throws Exception {
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Verification Mail");

        //
        message.setText("Hello Dev, your verification code is " + verificationCode);
        //message.setContent(verificationCode, "text/html; charset=utf-8");
    }
}
