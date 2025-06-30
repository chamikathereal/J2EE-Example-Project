package lk.jiat.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.User;
import lk.jiat.app.ejb.remote.UserService;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

//    @EJB
//    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");

        User user = new User(name, email, contact, password);

        System.out.println(name + " " + email + " " + contact + " " + password);
//        System.out.println(user.toString());
//        userService.addUser(user);

    }
}
