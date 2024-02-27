package com.Student.controller;

import com.Student.entity.Wishlist;
import com.Student.service.WishlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateNewWishlist() {
        Wishlist wishlist = new Wishlist();
        wishlist.setItemId("1");
        when(wishlistService.createWishlist(any(Wishlist.class))).thenReturn("Created");
        ResponseEntity<String> responseEntity = wishlistController.createNewWishlist(wishlist);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Created", responseEntity.getBody());
    }

    @Test
    public void testGetAllUserWishlists() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = Arrays.asList(wishlist1, wishlist2);
        when(wishlistService.getUserWishlist()).thenReturn(wishlists);
        ResponseEntity<List<Wishlist>> responseEntity = wishlistController.getAllUserWishlists();
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void testDeleteWishlist() {
        String id = "1";
        when(wishlistService.delteWishlist(id)).thenReturn("Deleted");
        ResponseEntity<String> responseEntity = wishlistController.deleteWishlist(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deleted", responseEntity.getBody());
    }
}
