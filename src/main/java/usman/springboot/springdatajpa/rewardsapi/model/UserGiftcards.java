package usman.springboot.springdatajpa.rewardsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserGiftcards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Type;
    @ManyToOne
    private User user;
    private String giftCardNumber;
    private double priceInMoney;
    private int priceInPoints;
}
