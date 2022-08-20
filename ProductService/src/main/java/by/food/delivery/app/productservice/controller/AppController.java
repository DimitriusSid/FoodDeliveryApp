package by.food.delivery.app.productservice.controller;

import by.food.delivery.app.productservice.domain.Product;
import by.food.delivery.app.productservice.domain.ProductType;
import by.food.delivery.app.productservice.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class AppController {

    private final ProductRepository productRepository;

    @Autowired
    public AppController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String showAllMenu(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products/products";
    }

    @GetMapping("/burgers")
    public String showAllBurgers(Model model) {
        List<Product> products = productRepository.findAllByProductType(ProductType.BURGER);
        model.addAttribute("products", products);
        return "products/burgers";
    }



}
