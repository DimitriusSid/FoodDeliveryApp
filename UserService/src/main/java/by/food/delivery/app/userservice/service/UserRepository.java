package by.food.delivery.app.userservice.service;

import by.food.delivery.app.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
