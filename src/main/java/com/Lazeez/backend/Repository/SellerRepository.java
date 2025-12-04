package com.Lazeez.backend.Repository;

import com.Lazeez.backend.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    List<Seller> findByPan(String pan);
}
