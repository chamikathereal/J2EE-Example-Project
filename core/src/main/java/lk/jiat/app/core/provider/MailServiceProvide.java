package lk.jiat.app.core.provider;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import lk.jiat.app.core.mail.Mailable;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MailServiceProvide {
    private Properties properties = new Properties();
    private Authenticator authenticator;
    private static MailServiceProvide instance;
    private ThreadPoolExecutor executor;
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

    private MailServiceProvide(){
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "false");
    }

    public static MailServiceProvide getInstance(){
        if (instance == null){
            instance = new MailServiceProvide();
        }
        return instance;
    }

    public void start(){
        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fbb92aa416ab07", "26371a707f9156");
            }
        };

        executor = new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,blockingQueue,
                new ThreadPoolExecutor.AbortPolicy());
        executor.prestartAllCoreThreads();

        System.out.println("MailServiceProvide: Running...");
    }

    public void sendMail(Mailable mailable){
        blockingQueue.offer(mailable);
    }

    public Properties getProperties() {
        return properties;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void shutdown(){
        if (executor != null){
            executor.shutdown();
        }
    }
}
