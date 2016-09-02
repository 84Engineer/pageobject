/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflows;

import pages.ListPostsPage;
import pages.NewPostPage;

/**
 *
 * @author oslysenko
 */
public class PostCreator {
    
    private static String previousTitle;
    private static String previousBody;
    
    public static void createPost() {
        
        NewPostPage.goTo();
        
        previousTitle = createTitle();
        previousBody = createBody();
        
        NewPostPage.createPost(previousTitle)
                .withBody(previousBody)
                .publish();
        
    }
    
    public static String previousTitle() {
        return previousTitle;
    }
    
    private static String createTitle() {
        return generateString() + ", title";
    }

    private static String createBody() {
        return generateString() + ", body";
    }
    
    private static String generateString() {
        return "Test" + System.currentTimeMillis();
    }
    
    public static void initialize() {
        previousTitle = null;
        previousBody = null;
    }
    
    public static void cleanUp() {
        if(createdAPost()) {
            trashPost();
        }
    }
    
    private static boolean createdAPost() {
        return previousTitle != null;
    }
    
    private static void trashPost() {
        ListPostsPage.trashPost(previousTitle);
        initialize();
    }
    
}
