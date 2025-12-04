package com.Lazeez.backend.Service;

import com.Lazeez.backend.DTO.Request.SellerRequest;
import com.Lazeez.backend.DTO.Response.SellerResponse;
import com.Lazeez.backend.Exception.SellerAlreadyExist;
import com.Lazeez.backend.Exception.SellerDoNotExist;
import com.Lazeez.backend.Model.Seller;
import com.Lazeez.backend.Repository.SellerRepository;
import com.Lazeez.backend.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest) {

        List<Seller> optionalSeller=sellerRepository.findByPan(sellerRequest.getPan());

        if(optionalSeller.size()>0){
            throw new SellerAlreadyExist("Seller with same pan aleady exist");
        }

        Seller seller= sellerRepository.save(SellerTransformer.sellerRequestToSeller(sellerRequest));

        return SellerTransformer.sellerToSellerResponse(seller);


    }

    public SellerResponse getSeller(int id) {

        Optional<Seller> optionalSeller=sellerRepository.findById(id);

        if(optionalSeller.isEmpty()){
            throw new SellerDoNotExist("Seller with this id not exist");
        }

        Seller seller=optionalSeller.get();

        return SellerTransformer.sellerToSellerResponse(seller);
    }

    public List<SellerResponse> getAllSeller() {

        List<Seller> optionalSellers=sellerRepository.findAll();

        if(optionalSellers.isEmpty()){
            throw new SellerDoNotExist("seller list is empty");
        }

        List<SellerResponse> sellerResponses=new ArrayList<>();

        for(Seller seller : optionalSellers){
            sellerResponses.add(SellerTransformer.sellerToSellerResponse(seller));
        }

        return sellerResponses;

    }

    public SellerResponse deleteSeller(int id) {

        Optional<Seller> optionalSeller=sellerRepository.findById(id);

        if(optionalSeller.isEmpty()){
            throw new SellerDoNotExist("no seller with id "+id+" exist");
        }
        SellerResponse sellerResponse=SellerTransformer.sellerToSellerResponse(optionalSeller.get());

        sellerRepository.deleteById(id);

        return sellerResponse;
    }
}
