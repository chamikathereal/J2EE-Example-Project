package lk.jiat.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.exception.LoginFailedException;
import lk.jiat.app.core.model.Product;
import lk.jiat.app.core.service.ProductService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/test")
public class Test extends HttpServlet {

    @EJB
    ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Optional<Product> productByName = productService.getProductByName("abc");
            if (productByName.isPresent()) {
                Product product = productByName.get();
            }
        }catch (Exception e){
            throw e;
        }

    }
}
