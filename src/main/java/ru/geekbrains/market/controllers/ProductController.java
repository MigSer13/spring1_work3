package ru.geekbrains.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.services.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/demo")
    @ResponseBody
    public String demo(){
        return "demo ОК";
    }

    @GetMapping("/repository")
    public String showCart(Model model){
        model.addAttribute("repository", productService.getProductList());
        return "repository";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add_form";
    }

    @GetMapping("/infoProduct/{id}")
    public String infoOfProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getByID(id));
        return "infoProduct";
    }

    @PostMapping("/add_new_product")
    public String addNewProduct(Model model, @RequestParam int id, @RequestParam String title, @RequestParam float cost){
        String answer = productService.addNewProduct(id, title, cost);
        if(answer.startsWith("Добавлен")){
            return "redirect:/repository";
        }else {
            model.addAttribute("answer", answer);
            return "add_form";
        }
    }

}
