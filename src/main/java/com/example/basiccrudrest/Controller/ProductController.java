package com.example.basiccrudrest.Controller;

import com.example.basiccrudrest.Entity.Product;
import com.example.basiccrudrest.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //POST
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts (@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    //GET
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.findProductByName(name);
    }
    //PUT //product almali
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id){
        return service.updateProduct(id);
    }
    //DELETE
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
