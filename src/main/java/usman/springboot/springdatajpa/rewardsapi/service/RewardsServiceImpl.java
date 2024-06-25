package usman.springboot.springdatajpa.rewardsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import usman.springboot.springdatajpa.rewardsapi.dao.IRewardsRepo;
import usman.springboot.springdatajpa.rewardsapi.model.*;

import java.util.Optional;
import java.util.Random;

@Service
public class RewardsServiceImpl implements IRewardsService{
    private static final int MIN_POINTS = 1000;
    private static final int MAX_POINTS = 20000;
    private Random random = new Random();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    IRewardsRepo repo;
    private int userId;
    private Rewards item;

    @Override
    public void addPoints(int points) {

        // Generate random points between 1000 and 20000
        int randomPoints = random.nextInt(MAX_POINTS - MIN_POINTS + 1) + MIN_POINTS;
        Integer minUserId = repo.findMinUserId();
        Integer maxUserId = repo.findMaxUserId();
        // Assuming the user is already logged in and their id is available
        Integer randomUserId = random.nextInt(maxUserId - minUserId + 1) + minUserId;

        // Retrieve the user from the database
        Optional<User> optional = repo.findById(randomUserId);
        User user = optional.orElseThrow(() -> new RuntimeException("User not found"));
        // Add points to the user's current points
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPoints(user.getPoints() + points);
       repo.save(user);

    }
//    @Override
//    public void redeemPoints(int points, int userId) {
//        // Retrieve the user from the database
//        Optional<User> optional = repo.findById(userId);
//        User user = optional.orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Check if the user has enough points to redeem
//        if (user.getPoints() < points) {
//            throw new RuntimeException("Not enough points to redeem");
//        }
//
//        // Subtract the points from the user's current points
//        user.setPoints(user.getPoints() - points);
//
//        // Save the user back to the database
//        repo.save(user);
//
//    }

    @Override
    public String buyHeadpones(int UserId, Headphone hp) {
        return buyItem(UserId, hp);


    }

    @Override
    public String buyLaptop(int UserId, Laptop lp) {
        return buyItem(UserId, lp);

    }

    @Override
    public String buyMobile(int UserId, Telephone tp){
        return buyItem(UserId, tp);


    }
    @Override
    public String buyItem(int userId, Rewards item) {

        // Retrieve the user from the database
        Optional<User> optional = repo.findById(userId);
        User user = optional.orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the user has enough points to buy the item
        if (user.getPoints() < item.getPriceInPoints()) {
            throw new RuntimeException("Not enough points to buy " + item.getType());
        }

        // Subtract the points from the user's current points
        user.setPoints(user.getPoints() - item.getPriceInPoints());

        // Save the user back to the database
        repo.save(user);

        // Return a success message
        return "Purchase successful! You bought " + item.getType() + " with " + item.getPriceInPoints() + " points. Now you have " + user.getPoints() + " points left.";
    }

//write my user register class here
    public void registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
}
