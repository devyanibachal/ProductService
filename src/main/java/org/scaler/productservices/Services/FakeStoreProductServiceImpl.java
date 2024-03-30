package org.scaler.productservices.Services;

import org.scaler.productservices.DTO.FakeStoreProductDTO;
import org.scaler.productservices.Modals.Category;
import org.scaler.productservices.Modals.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + userId , FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) return null;
        return setProductObject(fakeStoreProductDTO);
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products" , FakeStoreProductDTO[].class);
        if(fakeStoreProductDTO == null) return null;
        List<Product> result = new ArrayList<>();
        for( FakeStoreProductDTO obj : fakeStoreProductDTO)
            result.add(setProductObject(obj));
        return result ;
    }

    @Override
    public Product createProduct(FakeStoreProductDTO product) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO = restTemplate.postForEntity("https://fakestoreapi.com/products" , product, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) return null;
        return setProductObject(fakeStoreProductDTO.getBody());
    }

    @Override
    public Product updateProduct(Long userId, FakeStoreProductDTO product) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.patchForObject("https://fakestoreapi.com/products/"+userId, product, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) return null;
        return setProductObject(fakeStoreProductDTO);
    }

    @Override
    public Product replaceProduct(Long userId, FakeStoreProductDTO product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.
                execute("https://fakestoreapi.com/products", HttpMethod.PUT, requestCallback, responseExtractor);
        if(fakeStoreProductDTO == null) return null;
        return setProductObject(fakeStoreProductDTO);
    }

    @Override
    public Product deleteProduct(Long userId) {
//        restTemplate.delete("https://fakestoreapi.com/products/" + userId);
//        return null;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(userId, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.
                execute("https://fakestoreapi.com/products", HttpMethod.DELETE, requestCallback, responseExtractor);
        if(fakeStoreProductDTO == null) return null;
        return setProductObject(fakeStoreProductDTO);
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
