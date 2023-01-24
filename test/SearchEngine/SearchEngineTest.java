package test.SearchEngine;

import static org.junit.Assert.*;

import org.junit.Test;

import SearchEngine.SearchEnginController;


public class SearchEngineTest {
    public SearchEngineTest() {
        mockController = new SearchEnginController();
    }

    private SearchEnginController mockController;

    @Test
    public void testControllers() {
        assertNotEquals(null, mockController.getSearchExerciseController());
        assertNotEquals(null, mockController.getSearchWorkoutHistoryController());
    }
}