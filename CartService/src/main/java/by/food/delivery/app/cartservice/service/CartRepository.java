package by.food.delivery.app.cartservice.service;

import by.food.delivery.app.cartservice.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
