package lk.jiat.app.web.servlet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.jiat.app.core.util.Encryption;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email + " " + password);

        //String encryptedPassword = Encryption.encrypt(password);

        AuthenticationParameters parameters = AuthenticationParameters.withParams()
                        .credential(new UsernamePasswordCredential(email, Encryption.encrypt(password)));

        System.out.println("parameters :" + parameters);
        AuthenticationStatus status = securityContext.authenticate(request, response, parameters);
        System.out.println("status:" + status);

        if (status == AuthenticationStatus.SUCCESS) {
            System.out.println("Authentication successful");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            System.out.println("Correct Credentials Context Path: " + request.getContextPath());
        } else {
            System.out.println("Authentication failed");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            System.out.println("Incorrect Credentials Context Path: " + request.getContextPath());
        }

    }
}
