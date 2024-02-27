package com.Student.controller;

import com.Student.entity.Wishlist;
import com.Student.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService service;

    @PostMapping("/api/wishlists")
    public ResponseEntity<String> createNewWishlist(@RequestBody Wishlist list){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createWishlist(list));
    }

    @GetMapping("/api/wishlists")
    public  ResponseEntity<List<Wishlist>> getAllUserWishlists(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.service.getUserWishlist());
    }

    @DeleteMapping("/api/wishlists/{id}")
    public ResponseEntity<String> deleteWishlist(@PathVariable String id){
        return ResponseEntity.status(200).body(this.service.delteWishlist(id));
    }
}
