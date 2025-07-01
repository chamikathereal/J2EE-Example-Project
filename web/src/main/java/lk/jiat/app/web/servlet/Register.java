package lk.jiat.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.mail.VerificationMail;
import lk.jiat.app.core.model.User;
import lk.jiat.app.core.provider.MailServiceProvider;
import lk.jiat.app.core.service.UserService;
import lk.jiat.app.core.util.Encryption;


import java.io.IOException;
import java.util.UUID;

@WebServlet("/register")
public class Register extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");

        String encryptedPassword = Encryption.encrypt(password);

        User user = new User(name, email, contact, encryptedPassword);

        String verificationCode = UUID.randomUUID().toString();
        VerificationMail mail = new VerificationMail(email, verificationCode);
        MailServiceProvider.getInstance().sendMail(mail);

        System.out.println(name + " " + email + " " + contact + " " + encryptedPassword);
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
}
