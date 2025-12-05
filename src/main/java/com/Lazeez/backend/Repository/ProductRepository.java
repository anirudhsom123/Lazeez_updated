package com.Lazeez.backend.Repository;

import com.Lazeez.backend.Model.Cart;
import com.Lazeez.backend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByCart(Cart cart);
}
