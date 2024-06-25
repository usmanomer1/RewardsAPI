package usman.springboot.springdatajpa.rewardsapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop implements Rewards{


    private double price=5000;
    private int priceInPoints=10000;
    private int pointsAddedOnPurchase=1000;
    private String category="electronics";
    public String name="Macbook Pro";

    @Override
    public String getType() {
        return this.getName();
    }
}
