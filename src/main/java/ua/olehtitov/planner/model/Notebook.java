package ua.olehtitov.planner.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Notebook {
    private final List<Plan> plans = new ArrayList<>();

    public void addPlan(String text) {
        Plan plan = new Plan();
        plan.setText(text);
        plans.add(plan);
    }

    public List<String> showPlans() {
        return plans.stream().map(Plan::getText).toList();
    }
}
