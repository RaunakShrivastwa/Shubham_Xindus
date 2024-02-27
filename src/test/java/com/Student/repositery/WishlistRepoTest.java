package com.Student.repositery;

import com.Student.entity.Wishlist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class WishlistRepoTest {

    @Mock
    private WishlistRepo wishlistRepo;

    @InjectMocks
    private Wishlist wishlist;

    @Test
    public void testFindByUserId() {
        // Create test data
        String userId = "user123";
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setItemId("1");
        wishlist1.setUserId(userId);

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setItemId("2");
        wishlist2.setUserId(userId);

        List<Wishlist> expectedWishlists = new ArrayList<>();
        expectedWishlists.add(wishlist1);
        expectedWishlists.add(wishlist2);

        // Mock the repository method
        when(wishlistRepo.findByUserId(userId)).thenReturn(expectedWishlists);

        // Call the repository method
        List<Wishlist> actualWishlists = wishlistRepo.findByUserId(userId);

        // Verify the results
        assertEquals(expectedWishlists.size(), actualWishlists.size());
        assertEquals(expectedWishlists.get(0).getItemId(), actualWishlists.get(0).getItemId());
        assertEquals(expectedWishlists.get(1).getItemId(), actualWishlists.get(1).getItemId());
        assertEquals(expectedWishlists.get(0).getUserId(), actualWishlists.get(0).getUserId());
        assertEquals(expectedWishlists.get(1).getUserId(), actualWishlists.get(1).getUserId());
        // Add more assertions as needed
    }
}
