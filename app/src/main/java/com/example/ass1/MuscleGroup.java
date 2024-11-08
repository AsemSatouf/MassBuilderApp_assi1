package com.example.ass1;

import java.util.ArrayList;
import java.util.List;

public class MuscleGroup {
    private String name;  // Muscle group name (e.g., chest)
    private List<Exercise> menExercises;  // List of exercises for men
    private List<Exercise> womenExercises;  // List of exercises for women



    public MuscleGroup(String name,List<Exercise>men,List<Exercise> women) {
        this.name = name;
        this.menExercises = men;
        this.womenExercises = women;

    }
    public String getName() {
        return name;
    }

    public List<Exercise> getWomenExercises() {
        return womenExercises;
    }

    public List<Exercise> getMenExercises() {
        return menExercises;
    }


}
