package by.food.delivery.app.orderservice.service;

import by.food.delivery.app.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAll();
}
