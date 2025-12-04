package com.Lazeez.backend.Service;

import com.Lazeez.backend.DTO.Request.ProductRequest;
import com.Lazeez.backend.DTO.Response.ProductResponse;
import com.Lazeez.backend.Exception.ProductDoNotExist;
import com.Lazeez.backend.Exception.SellerDoNotExist;
import com.Lazeez.backend.Model.Product;
import com.Lazeez.backend.Model.Seller;
import com.Lazeez.backend.Repository.ProductRepository;
import com.Lazeez.backend.Repository.SellerRepository;
import com.Lazeez.backend.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductResponse addProduct(int id, ProductRequest productRequest) {

        Optional<Seller> optionalSeller=sellerRepository.findById(id);

        if(optionalSeller.isEmpty()){
            throw  new SellerDoNotExist("no seller with id"+id+"exist");
        }


        // DTO -> entity
        Product product= ProductTransformer.productRequestToProduct(productRequest);

        // set the relationship
        Seller seller = optionalSeller.get();
        seller.getProducts().add(product);
        product.setSeller(seller);


        Seller savedSeller=sellerRepository.save(seller);


        // product response
        int size = savedSeller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size-1);

        return ProductTransformer.productToProductResponse(savedProduct);

    }

    public ProductResponse updateProduct(int id, int price) {

        Optional<Product> optionalProduct=productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductDoNotExist("no product with id "+id+" exist");
        }

        Product product=optionalProduct.get();

        product.setPrice(price);

        productRepository.save(product);
        return ProductTransformer.productToProductResponse(product);
    }

    public ProductResponse deleteProduct(int id) {

        Optional<Product> optionalProduct=productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductDoNotExist("no product to delete");
        }
        Product product=optionalProduct.get();
        ProductResponse productResponse=ProductTransformer.productToProductResponse(product);
        productRepository.deleteById(id);

        return productResponse;
    }

    public List<ProductResponse> getAllProduct() {

        List<Product> products=productRepository.findAll();

        List<ProductResponse> productResponses=new ArrayList<>();

        for(Product product : products){

            productResponses.add(ProductTransformer.productToProductResponse(product));
        }

        return productResponses;
    }
}
