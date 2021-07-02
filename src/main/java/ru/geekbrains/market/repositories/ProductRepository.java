package ru.geekbrains.market.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
           new Product(1, "Яблоко", 15),
           new Product(2, "Хлеб", 41),
           new Product(3, "Огурец", 13),
           new Product(4, "Молоко", 60),
           new Product(5, "Сок", 75)
        ));
    }

    public Product getByID(int id){
        for(Product p : productList){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String addProduct(int id, String title, float cost){
        Product newProduct = getByID(id);
        if((newProduct==null)){
            productList.add(new Product(id, title, cost));
            return "Добавлен новый продукт " + id + "-" + title + "-" + cost;
        }else {
            return "Продукт с id = " +id+ " уже существует";
        }
    }
}
