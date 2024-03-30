package org.scaler.productservices.Services;

import org.scaler.productservices.DTO.FakeStoreProductDTO;
import org.scaler.productservices.Modals.Category;
import org.scaler.productservices.Modals.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    RestTemplate restTemplate;

    FakeStoreProductServiceImpl ( RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long userId) {
        FakeStoreProductDTO response = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + userId , FakeStoreProductDTO.class);
        return setProductObject(response);
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products" , FakeStoreProductDTO[].class);
        assert response != null;
        List<Product> result = new ArrayList<>();
        for( FakeStoreProductDTO obj : response)
            result.add(setProductObject(obj));
        return result ;
    }

    @Override
    public Product createProduct(FakeStoreProductDTO product) {
        return null;
    }

    @Override
    public Product updateProduct(Long userId, FakeStoreProductDTO product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long userId, FakeStoreProductDTO product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.
                execute("https://fakestoreapi.com/products", HttpMethod.POST, requestCallback, responseExtractor);
        assert fakeStoreProductDTO != null;
        return setProductObject(fakeStoreProductDTO);
    }

    @Override
    public Product deleteProduct(Long UserId) {
        return null;
    }

    private Product setProductObject(FakeStoreProductDTO object) {
        Product product = new Product();
        product.setId(object.getId());
        product.setDescription(object.getDescription());
        product.setImage(object.getImage());
        product.setPrice(object.getPrice());
        product.setTitle(object.getTitle());
        product.setCategory(new Category(0, object.getCategory()));
        return product;
    }
}
