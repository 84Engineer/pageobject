/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poststests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.ListPostsPage;
import pages.NewPostPage;
import utils.BaseTest;
/**
 *
 * @author oslysenko
 */
public class AllPagesTests extends BaseTest {
    
    @Test
    public void addedPostsShowUp() {
        
        ListPostsPage.goTo(ListPostsPage.PageType.POSTS);
        ListPostsPage.storeCount();
        
        NewPostPage.goTo();
        NewPostPage.createPost("Added posts show up, title")
                .withBody("Added posts show up, body")
                .publish();
        
        ListPostsPage.goTo(ListPostsPage.PageType.POSTS);
        assertEquals(ListPostsPage.previousPostCount() + 1, ListPostsPage.currentPostCount(), "Count of posts did not increase.");
        assertTrue(ListPostsPage.doesPostExistWithTitle("Added posts show up, title"));
        
        ListPostsPage.trashPost("Added posts show up, title");
        assertEquals(ListPostsPage.previousPostCount(), ListPostsPage.currentPostCount(), "Couldn't trash post.");
        
    }
    
}
