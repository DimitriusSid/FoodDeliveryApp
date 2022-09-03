package by.food.delivery.app.userservice.controller;

import by.food.delivery.app.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import by.food.delivery.app.userservice.service.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class AppController {

    private final UserRepository userRepository;

    @Autowired
    public AppController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElse(new User());
        model.addAttribute("user", user);
        return "users/user";
    }

    @GetMapping("/new")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/user";
    }

    @PostMapping("")
    public String saveNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/user";
        }
        userRepository.save(user);
        return "redirect:users";
    }

}
