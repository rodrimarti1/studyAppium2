package UI.Tests;

import UI.Functions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnnotationTests {

    private Functions functions = new Functions();

    @Before
    public void setUp() throws Exception {
        functions.setUp();
    }

    @After
    public void tearDown() throws Exception {
        functions.tearDown();
    }


    //Bookmarks

    @Test
    public void bookmarkInAnotherLanguageTest() throws Exception {
        String jiraID = "MQA-1491";
        //functions.changeLanguage();
        functions.downloadAllInCollection("Scriptures");
        //functions.openCollection("Skrifture", "Boek van Mormon", "Jakob", "5", "");
        //TODO: Open the bookmarks pannel
        //TODO: tap the + button then press done.
    }

    @Test
    public void scriptureReferenceAppearCorrectlyTest() throws Exception {
        String jiraID = "MQA-1492";
    }

    @Test
    public void createABookmarkTest() throws Exception {
        String jiraID = "MQA-1493";
    }

    @Test
    public void createBookmarkButtonIsPresentTest() throws Exception {
        String jiraID = "MQA-1494";
    }

    @Test
    public void defaultNameUpdatesItselfTest() throws Exception {
        String jiraID = "MQA-1495";
    }

    @Test
    public void deleteABookmarkTest() throws Exception {
        String jiraID = "MQA-1496";
    }

    @Test
    public void hideAndUpdateButtonsTest() throws Exception {
        String jiraID = "MQA-1497";
    }

    @Test
    public void bookmarkIconThemedTest() throws Exception {
        String jiraID = "MQA-1499";
    }

    @Test
    public void bookmarksInOtherLanguageSyncTest() throws Exception {
        String jiraID = "MQA-1500";
    }

    @Test
    public void renameBookmarkTest() throws Exception {
        String jiraID = "MQA-1501";
    }

    @Test
    public void moveBookmarkToAnotherChapterTest() throws Exception {
        String jiraID = "MQA-1500";
    }

    @Test
    public void dismissPanelAfterUpdatingTest() throws Exception {
        String jiraID = "MQA-1501";
    }

    @Test
    public void dismissPanelAfterCreatingBookmark() throws Exception {
        String jiraID = "MQA-1502";
    }

    @Test
    public void reorderBookmarkTest() throws Exception {
        String jiraID = "MQA-1503";
    }

    @Test
    public void deleteBookmarkThenUpdateDifferentBookmarkTest() throws Exception {
        String jiraID = "MQA-1503";
    }

    @Test
    public void BookmarkInRoleBasedContent() throws Exception {
        String jiraID = "MQA-1504";
    }

    @Test
    public void resetBookmarkToDefaultNameTest() throws Exception {
        String jiraID = "MQA-1505";
    }


    //Note Editor

//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }
//
//    @Test
//    public void throws Exception {
//        String jiraID = "MQA-";
//    }




    //Notebooks
    //Margin Indicators
    //Tagging
    //Notes Section
    //Misc
    //Text Selection Menu
    //Inline Notes
    //Linking
    //Highlighting
}
