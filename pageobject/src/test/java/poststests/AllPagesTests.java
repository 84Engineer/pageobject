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
import selenium.Driver;
import utils.BaseTest;
import workflows.PostCreator;
/**
 *
 * @author oslysenko
 */
public class AllPagesTests extends BaseTest {
    
    @Test
    public void addedPostsShowUp() {
        
        ListPostsPage.goTo(ListPostsPage.PageType.POSTS);
        ListPostsPage.storeCount();
        
        PostCreator.createPost();
        
        ListPostsPage.goTo(ListPostsPage.PageType.POSTS);
        assertEquals(ListPostsPage.previousPostCount() + 1, ListPostsPage.currentPostCount(), "Count of posts did not increase.");
        assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.previousTitle()));
        
        ListPostsPage.trashPost(PostCreator.previousTitle());
        assertEquals(ListPostsPage.previousPostCount(), ListPostsPage.currentPostCount(), "Couldn't trash post.");
        
    }
    
    @Test
    public void canSearchPost() {
        
        PostCreator.createPost();
        ListPostsPage.searchForPost(PostCreator.previousTitle());
        assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.previousTitle()));
        Driver.wait(3);
        
    }
    
}
