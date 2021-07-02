package ru.geekbrains.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addNewProduct(int id, String title, float cost){
        return productRepository.addProduct(id, title, cost);
    }

    public List<Product> getProductList(){
        return productRepository.getProductList();
    }

    public Product getByID(int id){
        return productRepository.getByID(id);
    }

}
