package com.example.basiccrudrest.Service;

import com.example.basiccrudrest.Entity.Product;
import com.example.basiccrudrest.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    //Post
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //Get
    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int productId){
        return repository.findById(productId).orElse(null);
    }

    public Product findProductByName(String name){
        return repository.findByName(name);
    }

    //Delete
    public String deleteProduct(int id){
    repository.deleteById(id);
        return "" + id + "deleted ";
    }

    //put
    public String updateProduct(int id){
        Product existP=repository.findById(id).orElse(null);
        String oldName=null;
        if (existP!=null){
            oldName=existP.getName();
            existP.setName("updatedName");
        repository.save(existP);
        }
        return "oldName: " + oldName+ '\n'+ "newName"+ existP.getName();
    }

}
