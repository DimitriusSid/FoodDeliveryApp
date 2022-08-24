package by.food.delivery.app.orderservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "shoppingcarts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "creation_date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_shoppingcarts",
            joinColumns = @JoinColumn(name = "shoppingcart_id"))
    private Order order;
}
