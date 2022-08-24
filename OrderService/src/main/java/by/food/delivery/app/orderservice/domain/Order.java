package by.food.delivery.app.orderservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_shoppingcarts",
    joinColumns = @JoinColumn(name = "order_id"))
    private List<ShoppingCart> shoppingCartList;

    public void addShoppingCartToOrder(ShoppingCart shoppingCart) {
        if (shoppingCartList == null) {
            shoppingCartList = new ArrayList<>();
        }
        shoppingCartList.add(shoppingCart);
    }

}
