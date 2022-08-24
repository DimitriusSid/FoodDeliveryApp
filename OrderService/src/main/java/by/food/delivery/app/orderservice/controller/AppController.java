package by.food.delivery.app.orderservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class AppController {

    @PostMapping("")
    public String showShoppingCart() {
        return "shopping-cart";
    }

}
