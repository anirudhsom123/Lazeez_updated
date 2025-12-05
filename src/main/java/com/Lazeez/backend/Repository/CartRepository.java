package com.Lazeez.backend.Repository;

import com.Lazeez.backend.Model.Cart;
import com.Lazeez.backend.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {


    Optional<Cart> findByCustomer(Customer customer);
}
