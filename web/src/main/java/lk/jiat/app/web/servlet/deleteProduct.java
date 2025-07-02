package lk.jiat.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.service.ProductService;

import java.io.IOException;

@WebServlet("/admin/delete_product")
public class deleteProduct extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pid");

        System.out.println("product id: " + pid);

        try {
            productService.deleteProduct(Long.parseLong(pid));
            response.sendRedirect(request.getContextPath() + "/admin");
        }catch (EJBException e) {
            System.out.println(e.getMessage());
        }

    }
}
