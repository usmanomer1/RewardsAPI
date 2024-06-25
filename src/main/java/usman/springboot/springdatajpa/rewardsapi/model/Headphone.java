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
public class Headphone implements Rewards{


    private double price=550;
    private int priceInPoints=2000;
    private int pointsAddedOnPurchase=200;
    private String category="electronics";
    private String name="Airpods Max";

    @Override
    public String getType() {
        return this.getName();
    }
}
