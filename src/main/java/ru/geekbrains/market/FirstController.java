package ru.geekbrains.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/demo")
    @ResponseBody
    public String demo(){
        return "demo ОК";
    }

    @GetMapping("/repository")
    public String showCart(Model model){
        model.addAttribute("repository", productRepository.getProductList());
        return "repository";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add_form";
    }

    @PostMapping("/add_new_product")
    public String addNewProduct(Model model, @RequestParam int id, @RequestParam String title, @RequestParam long cost){
        String answer = productRepository.addProduct(id, title, cost);
        if(answer.startsWith("Добавлен")){
            return "redirect:/repository";
        }else {
            model.addAttribute("answer", answer);
            return "add_form";
        }

    }

}
