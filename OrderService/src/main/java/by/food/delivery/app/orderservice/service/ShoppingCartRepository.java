package by.food.delivery.app.orderservice.service;

import by.food.delivery.app.orderservice.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
