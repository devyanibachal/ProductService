package org.scaler.productservices.Controllers;

import org.scaler.productservices.DTO.FakeStoreProductDTO;
import org.scaler.productservices.ExceptionHandler.ProductControllerSpecificExceptionHandler;
import org.scaler.productservices.Modals.Product;
import org.scaler.productservices.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Product> getProductById(@PathVariable("userId") Long userId){
        Product product = productService.getProductById(userId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody FakeStoreProductDTO product){
        return productService.createProduct(product);
        //throw new RuntimeException("Devyani");
    }

    @PutMapping("{userId}") //completeProduct
    public Product replaceProduct(@PathVariable("userId") Long userId, @RequestBody FakeStoreProductDTO product){
        return productService.replaceProduct(userId,product);
    }

    @PatchMapping("{userId}")  //Partial update
    public Product updateProduct(@PathVariable("userId") Long userId, @RequestBody FakeStoreProductDTO product){
        return productService.updateProduct(userId,product);
    }

    @DeleteMapping("{userId}")
    public Product deleteProduct(@PathVariable("userId") Long userId) throws ProductControllerSpecificExceptionHandler {
       // throw new ProductControllerSpecificExceptionHandler("Yayy");
        return productService.deleteProduct(userId);
    }

    @ExceptionHandler(ProductControllerSpecificExceptionHandler.class)
    public ResponseEntity<ProductControllerSpecificExceptionHandler> errorHandle(){
        ProductControllerSpecificExceptionHandler obj = new ProductControllerSpecificExceptionHandler("Exception");
        return new ResponseEntity<ProductControllerSpecificExceptionHandler>(obj, HttpStatus.OK);
    }
}
