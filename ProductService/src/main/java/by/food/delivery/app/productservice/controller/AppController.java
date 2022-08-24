package by.food.delivery.app.productservice.controller;

import by.food.delivery.app.productservice.domain.Product;
import by.food.delivery.app.productservice.domain.ProductType;
import by.food.delivery.app.productservice.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/doners")
    public String showDoners(Model model) {
        model.addAttribute("products", getProducts(ProductType.DONER));
        return "products/products";
    }

    @GetMapping("/burgers")
    public String showBurgers(Model model) {
        model.addAttribute("products", getProducts(ProductType.BURGER));
        return "products/products";
    }

    @GetMapping("/salads")
    public String showSalads(Model model) {
        model.addAttribute("products", getProducts(ProductType.SALAD));
        return "products/products";
    }

    @GetMapping("/fries")
    public String showFries(Model model) {
        model.addAttribute("products", getProducts(ProductType.FRIES));
        return "products/products";
    }

    @GetMapping("/sauces")
    public String showSauces(Model model) {
        model.addAttribute("products", getProducts(ProductType.SAUCE));
        return "products/products";
    }

    @GetMapping("/desserts")
    public String showDesserts(Model model) {
        model.addAttribute("products", getProducts(ProductType.DESSERT));
        return "products/products";
    }

    @GetMapping("/drinks")
    public String showDrinks(Model model) {
        model.addAttribute("products", getProducts(ProductType.DRINK));
        return "products/products";
    }

    @PostMapping("")
    public String createOrder() {

        return "redirect:orders";
    }


    private List<Product> getProducts(ProductType productType) {
        return productRepository.findAllByProductType(productType);
    }
}
