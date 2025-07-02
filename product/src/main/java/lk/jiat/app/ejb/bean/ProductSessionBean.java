package lk.jiat.app.ejb.bean;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lk.jiat.app.core.exception.InvalidParameterException;
import lk.jiat.app.core.model.Product;
import lk.jiat.app.core.service.ProductService;


import java.util.List;
import java.util.Optional;

@Stateless
public class ProductSessionBean implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Product> getProductById(Long id) {
        //return em.find(Product.class, id);
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        try {
            TypedQuery<Product> query = em.createNamedQuery("Product.findByName", Product.class)
                    .setParameter("name", name);

            return Optional.ofNullable(query.getSingleResult());

        } catch (NoResultException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<Product> getProductSByCategory(String category) {
        return em.createNamedQuery("Product.findByCategory", Product.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public List<Product> getAllProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public void addProduct(Product product) {

        em.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);
    }

    //@RolesAllowed({"SUPER_ADMIN","ADMIN"})
//    @Override
//    public void deleteProduct(Long id) {
//        if (id == null || id < 0) {
//            throw new InvalidParameterException("Product id is null or negative");
//        }
//        em.remove(getProductById(id));
//        Optional<Product> optional = Optional.ofNullable(em.find(Product.class, id));
//        optional.ifPresent(em::remove);
//    }

    @Override
    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        } else {
            System.out.println("Product not found with ID: " + id);
            // Optionally, throw an exception or just log
        }
    }
}
