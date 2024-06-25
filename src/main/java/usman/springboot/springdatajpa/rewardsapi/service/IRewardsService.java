package usman.springboot.springdatajpa.rewardsapi.service;

import usman.springboot.springdatajpa.rewardsapi.model.Headphone;
import usman.springboot.springdatajpa.rewardsapi.model.Laptop;
import usman.springboot.springdatajpa.rewardsapi.model.Rewards;
import usman.springboot.springdatajpa.rewardsapi.model.Telephone;

public interface IRewardsService {
    public void addPoints(int points);
    //public void redeemPoints(int points,int UserId);
    public String buyHeadpones(int UserId, Headphone hp);
    public String buyLaptop(int UserId, Laptop lp);
    public String buyMobile(int UserId, Telephone tp);
    public String buyItem(int userId, Rewards r);






}
