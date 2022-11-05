package ua.olehtitov.planner.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NotebookTests {
    private Notebook notebook;

    @BeforeEach
    void init() {
        notebook = new Notebook();
        notebook.addPlan("Eat");
        notebook.addPlan("Work");
    }

    @Test
    void addPlanTest() {
        notebook.addPlan("Do sport");
        assertEquals("Do sport", notebook.showPlans().get(2));
    }

    @Test
    void showPlansTest() {
        List<String> list = Arrays.asList("Eat", "Work");
        assertIterableEquals(list, notebook.showPlans());
    }
}
