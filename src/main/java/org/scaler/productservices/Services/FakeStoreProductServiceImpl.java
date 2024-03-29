package org.scaler.productservices.Services;

import org.scaler.productservices.DTO.ProductDTO;
import org.scaler.productservices.Modals.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Override
    public Product getProductById(Long userId) {
        return null;
    }

    @Override
    public Product getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(ProductDTO product) {
        return null;
    }

    @Override
    public Product updateProduct(Long userId, ProductDTO product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long userId, ProductDTO product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long UserId) {
        return null;
    }
}
