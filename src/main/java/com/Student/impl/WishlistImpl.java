package com.Student.impl;

import com.Student.entity.User;
import com.Student.entity.Wishlist;
import com.Student.repositery.UserRespositery;
import com.Student.repositery.WishlistRepo;
import com.Student.service.WishlistService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistImpl implements WishlistService {

    @Autowired
    private WishlistRepo repo;

    @Autowired
    private UserRespositery userRespositery;
    @Override
    public String createWishlist(Wishlist list) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRespositery.findByEmail(email);
        System.out.println("login USer"+user);
        System.out.println("body user"+list);
        if(user.getId().equals(list.getUserId())){
            list.setItemId(UUID.randomUUID().toString());
            this.repo.save(list);
            return "Wishlist Created";
        }else{
            return "Not Allowed";
        }
    }

    @Override
    public List<Wishlist> getUserWishlist() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRespositery.findByEmail(email);
        return this.repo.findByUserId(user.getId());
    }

    @Override
    public String delteWishlist(String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRespositery.findByEmail(email);
        if(user.getId().equals(id)){
            this.repo.deleteById(id);
            return "Wishlist Deleted";
        }else{
            return "Not Allowed To Delete Another Wishlist";
        }
    }
}
