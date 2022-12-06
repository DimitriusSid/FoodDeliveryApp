package by.food.delivery.app.cartservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "creation_time")
    private Date creationTime;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "cart")
    private List<Product> products;

    public void addProductToCart(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        product.setCart(this);
    }
}
