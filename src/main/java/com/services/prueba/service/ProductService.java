package com.services.prueba.service;

import com.services.prueba.model.Product;
import com.services.prueba.model.ProductRequest;
import com.services.prueba.model.ProductResponse;
import com.services.prueba.model.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final String PRODUCTS_API_URL = "https://api.escuelajs.co/api/v1/products/";

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProducts() {
        Product[] productsArray = restTemplate.getForObject(PRODUCTS_API_URL, Product[].class);
        return Arrays.asList(productsArray);
    }

    public ServiceResponse createProduct(ProductRequest productRequest) {

        HttpEntity<ProductRequest> requestEntity = new HttpEntity<>(productRequest);

        ResponseEntity<ProductResponse> responseEntity = restTemplate.exchange(
                PRODUCTS_API_URL,
                HttpMethod.POST,
                requestEntity,
                ProductResponse.class
        );

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setPid(responseEntity.getBody().getId());

        return serviceResponse;
    }
}