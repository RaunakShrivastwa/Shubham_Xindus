package com.Student.service;

import com.Student.entity.Wishlist;

import java.util.List;

public interface WishlistService {

    String createWishlist(Wishlist list);

    List<Wishlist> getUserWishlist();

    String delteWishlist(String id);
}
