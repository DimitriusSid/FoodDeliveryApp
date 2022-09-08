package by.food.delivery.app.orderservice.controller;

import by.food.delivery.app.orderservice.domain.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AppController {

    @GetMapping("/new")
    public String showShoppingCart(Model model) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        model.addAttribute("shoppingCarts", shoppingCarts);
        return "cart";
    }

}
