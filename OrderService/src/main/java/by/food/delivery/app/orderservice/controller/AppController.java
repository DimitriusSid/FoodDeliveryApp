package by.food.delivery.app.orderservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class AppController {

    @GetMapping("")
    public String showShoppingCart() {
       return "cart";
    }

}
