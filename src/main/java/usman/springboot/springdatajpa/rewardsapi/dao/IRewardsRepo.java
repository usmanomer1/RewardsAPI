package usman.springboot.springdatajpa.rewardsapi.dao;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usman.springboot.springdatajpa.rewardsapi.model.User;

public interface IRewardsRepo extends JpaRepository<User, Integer> {
    @Query("SELECT MIN(u.id) FROM User u")
    Integer findMinUserId();

    @Query("SELECT MAX(u.id) FROM User u")
    Integer findMaxUserId();
}
