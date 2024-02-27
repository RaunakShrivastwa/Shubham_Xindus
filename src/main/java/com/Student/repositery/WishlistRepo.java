package com.Student.repositery;

import com.Student.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,String> {
  List<Wishlist> findByUserId(String id);
}

