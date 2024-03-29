package org.scaler.productservices.Controllers;

import org.scaler.productservices.DTO.ProductDTO;
import org.scaler.productservices.Modals.Product;
import org.scaler.productservices.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
public class ProductController {

    ProductService service;

    @GetMapping("/{userId}")
    public Product getProductById(@PathVariable("userId") Long userId){
        service.getProductById(userId);
        return null;
    }

    @GetMapping
    public Product getAllProducts(){
        service.getAllProducts();
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO product){
        return service.createProduct(product);
    }

    @PutMapping("{userId}") //completeProduct
    public Product replaceProduct(@PathVariable("userId") Long userId, @RequestBody ProductDTO product){
        return service.replaceProduct(userId,product);
    }

    @PatchMapping("{userId}")  //Partial update
    public Product updateProduct(@PathVariable("userId") Long userId, @RequestBody ProductDTO product){
        return service.updateProduct(userId,product);
    }

    @DeleteMapping("{userId}")
    public Product deleteProduct(@PathVariable("userId") Long userId){
        return service.deleteProduct(userId);
    }
}
