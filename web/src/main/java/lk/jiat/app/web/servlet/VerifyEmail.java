package lk.jiat.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.Status;
import lk.jiat.app.core.model.User;
import lk.jiat.app.core.service.UserService;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/verify")
public class VerifyEmail extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String vc = request.getParameter("vc");

        byte[] bytes = Base64.getDecoder().decode(id);
        String email = new String(bytes);

        User user = userService.getUserByEmail(email);
        if (user != null && user.getVerificationCode().equals(vc)) {
            user.setStatus(Status.ACTIVE);
            userService.updateUser(user);

        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");


    }
}
