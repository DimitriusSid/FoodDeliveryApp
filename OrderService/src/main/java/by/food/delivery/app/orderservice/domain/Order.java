package by.food.delivery.app.orderservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "creation_date")
    private Date creationDate;

}
