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
public class Telephone implements Rewards{


    private double price=1500;
    private int priceInPoints=5000;
    private int pointsAddedOnPurchase=500;
    private String category="electronics";
    private String name="iphone 15 pro max";

    @Override
    public String getType() {
        return this.getName();
    }
}
