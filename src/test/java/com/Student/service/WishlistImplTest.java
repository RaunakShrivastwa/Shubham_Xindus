package com.Student.service;

import com.Student.entity.User;
import com.Student.entity.Wishlist;
import com.Student.impl.WishlistImpl;
import com.Student.repositery.UserRespositery;
import com.Student.repositery.WishlistRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WishlistImplTest {

    @Mock
    private WishlistRepo wishlistRepo;

    @Mock
    private UserRespositery userRespositery;

    @InjectMocks
    private WishlistImpl wishlistService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateWishlist() {
        // Mocking authentication and user
        Authentication authentication = new UsernamePasswordAuthenticationToken("test@example.com", null);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        User user = new User();
        user.setId("userId");
        when(userRespositery.findByEmail(anyString())).thenReturn(user);

        // Creating wishlist object
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId("userId");

        // Mocking save method of wishlistRepo
        doNothing().when(wishlistRepo).save(wishlist);

        // Testing createWishlist method
        assertEquals("Wishlist Created", wishlistService.createWishlist(wishlist));
    }

    @Test
    public void testGetUserWishlist() {
        // Mocking authentication and user
        Authentication authentication = new UsernamePasswordAuthenticationToken("test@example.com", null);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        User user = new User();
        user.setId("userId");
        when(userRespositery.findByEmail(anyString())).thenReturn(user);

        // Creating wishlist objects
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = new ArrayList<>();
        wishlists.add(wishlist1);
        wishlists.add(wishlist2);

        when(wishlistRepo.findByUserId("userId")).thenReturn(wishlists);

        // Testing getUserWishlist method
        assertEquals(wishlists, wishlistService.getUserWishlist());
    }

    @Test
    public void testDeleteWishlist() {
        // Mocking authentication and user
        Authentication authentication = new UsernamePasswordAuthenticationToken("test@example.com", null);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        User user = new User();
        user.setId("userId");
        when(userRespositery.findByEmail(anyString())).thenReturn(user);

        // Mocking deleteById method of wishlistRepo
        doNothing().when(wishlistRepo).deleteById("wishlistId");

        // Testing deleteWishlist method
        assertEquals("Wishlist Deleted", wishlistService.delteWishlist("wishlistId"));
    }
}

