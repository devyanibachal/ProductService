package org.scaler.productservices.Services;

import org.scaler.productservices.DTO.ProductDTO;
import org.scaler.productservices.Modals.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

public interface ProductService {

    public Product getProductById(Long userId);
    public Product getAllProducts();
    public Product createProduct( ProductDTO product);

    public Product updateProduct( Long userId, ProductDTO product);

    public Product replaceProduct( Long userId, ProductDTO product);

    public Product deleteProduct( Long UserId);
}
