package org.scaler.productservices.Services;

import org.scaler.productservices.DTO.FakeStoreProductDTO;
import org.scaler.productservices.Modals.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long userId);
    public List<Product> getAllProducts();
    public Product createProduct( FakeStoreProductDTO product);

    public Product updateProduct( Long userId, FakeStoreProductDTO product);

    public Product replaceProduct( Long userId, FakeStoreProductDTO product);

    public Product deleteProduct( Long UserId);
}
