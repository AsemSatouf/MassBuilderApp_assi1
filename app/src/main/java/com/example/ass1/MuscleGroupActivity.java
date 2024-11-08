package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MuscleGroupActivity extends AppCompatActivity {
    ArrayList<MuscleGroup> musclesGroup;
    Spinner spinner;
    Button btExcrise;
    RadioGroup radioGroup;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group);

        spinner = findViewById(R.id.myspinner);
        btExcrise = findViewById(R.id.ButtounShowExrcise);
        radioGroup=findViewById(R.id.radiogroup);
        listView=findViewById(R.id.myListView);

        Initialzied();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getSMuscleNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btExcrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select =radioGroup.getCheckedRadioButtonId();
                RadioButton rd=findViewById(select);
                String selectspinner=spinner.getSelectedItem().toString();

                if(select ==R.id.radiomale){
                    List<Exercise> listmen= getSExrecisemen(selectspinner);
                    ArrayList<String>nameExercisemen= new ArrayList<>();
                    for(Exercise exercise: listmen){
                        nameExercisemen.add(exercise.getName());
                    }
                    arrayAdapter = new ArrayAdapter<>(MuscleGroupActivity.this, android.R.layout.simple_list_item_1,nameExercisemen);
                    listView.setAdapter(arrayAdapter);


                } else if (select ==R.id.radiofemal) {
                    List<Exercise> listfemal= getSExreciseFemal(selectspinner);
                    ArrayList<String>nameExercisfemal= new ArrayList<>();
                    for(Exercise exercise: listfemal){
                        nameExercisfemal.add(exercise.getName());
                    }
                    arrayAdapter = new ArrayAdapter<>(MuscleGroupActivity.this, android.R.layout.simple_list_item_1,nameExercisfemal);
                    listView.setAdapter(arrayAdapter);
                }
                else{
                    Toast.makeText(MuscleGroupActivity.this, "Select Female or Male ", Toast.LENGTH_SHORT).show();
                }

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedExerciseName = (String) parent.getItemAtPosition(position);
                        List<Exercise> exercises;

                        if (radioGroup.getCheckedRadioButtonId() == R.id.radiomale) {
                            exercises = getSExrecisemen(spinner.getSelectedItem().toString());
                        } else {
                            exercises = getSExreciseFemal(spinner.getSelectedItem().toString());
                        }
                        Exercise selectedExercise = null;

                        for (Exercise exercise : exercises) {
                            if (exercise.getName().equals(selectedExerciseName)) {
                                selectedExercise = exercise;
                                break;
                            }
                        }
                        Intent in = new Intent(MuscleGroupActivity.this,ExerciseDescrptionActivity.class);
                        in.putExtra("name",selectedExercise.getName());
                        in.putExtra("sets",selectedExercise.getSets());
                        in.putExtra("reps",selectedExercise.getReps());
                        in.putExtra("descprion",selectedExercise.getDescription());
                        startActivity(in);

                    }
                });


            }

        });


    }

    private List<String> getSMuscleNames() {
        List<String> MuscleNames = new ArrayList<>();
        for (MuscleGroup muscle : musclesGroup) {
            MuscleNames.add(muscle.getName());
        }
        return MuscleNames;
    }

    private List<Exercise> getSExrecisemen(String musclename) {
        for (MuscleGroup muscle : musclesGroup) {
            if (muscle.getName().equals(musclename))
                return muscle.getMenExercises();
        }
        return  new ArrayList<>();
    }

        private List<Exercise> getSExreciseFemal(String musclename) {
            for (MuscleGroup muscle : musclesGroup) {
                if (muscle.getName().equals(musclename))
                    return muscle.getWomenExercises();
                }
          return new ArrayList<>();
            }


            private void Initialzied () {
                musclesGroup = new ArrayList<>();
                musclesGroup.add(new MuscleGroup("Legs",
                        List.of(
                                new Exercise("Squats", 4, 8, "Stand with your feet shoulder-width apart. Lower yourself slowly, bending your knees until your thighs are parallel to the ground, then push up to stand."),
                                new Exercise("Leg Press", 4, 8, "Sit on the machine with your feet firmly on the platform. Push slowly to extend your legs, then return to the starting position."),
                                new Exercise("Lunges", 4, 10, "Stand straight, step forward with one leg, and bend your knee at a 90-degree angle. Return to standing and repeat with the other leg."),
                                new Exercise("Leg Extensions", 4, 10, "Sit on the leg extension machine, place your legs under the pads, extend your legs slowly until straight, then return to the start position."),
                                new Exercise("Leg Curls", 4, 12, "Sit on the machine, adjust your position, curl your legs up towards your body, then lower them back down slowly.")
                        ),
                        List.of(
                                new Exercise("Glute Bridges", 3, 15, "Lie on your back with knees bent, lift your hips until your body forms a straight line from knees to shoulders, then lower down."),
                                new Exercise("Lunges", 3, 15, "Step forward and alternate lunges with each leg to target legs and glutes."),
                                new Exercise("Step-ups", 3, 15, "Step onto a bench or platform with one foot, lift your body up, then step down and repeat with the other leg."),
                                new Exercise("Bodyweight Squats", 3, 20, "Perform gentle squats without added weight, keeping your back straight and knees aligned."),
                                new Exercise("Leg Extensions", 3, 15, "Use light weight to perform leg extensions focusing on controlled motion.")
                        )
                ));

// Back exercises for men and women
                musclesGroup.add(new MuscleGroup("Back",
                        List.of(
                                new Exercise("Deadlifts", 4, 6, "Stand with feet hip-width apart, bend at your hips and knees to lower down and lift the bar, keeping your back straight as you rise."),
                                new Exercise("Pull-ups", 4, 8, "Grip the bar with hands slightly wider than shoulder-width, pull yourself up until your chin is above the bar, then lower back down."),
                                new Exercise("Lat Pulldowns", 4, 8, "Sit at the machine, grip the bar, and pull it down to your upper chest, then slowly release it back up."),
                                new Exercise("T-Bar Rows", 4, 8, "Hold the handle with both hands, pull the weight towards your chest, then release back down slowly."),
                                new Exercise("Barbell Rows", 4, 8, "Stand with knees slightly bent, bend forward, pull the barbell towards your lower chest, then lower it back.")
                        ),
                        List.of(
                                new Exercise("Lat Pulldowns", 3, 10, "Sit and pull the bar down toward your upper chest while keeping your back straight."),
                                new Exercise("Seated Rows", 3, 12, "Sit on the machine, grip the handle, and pull towards your torso, then release slowly."),
                                new Exercise("Supermans", 3, 15, "Lie face down and lift arms and legs simultaneously for lower back strength."),
                                new Exercise("Dumbbell Rows", 3, 12, "Use a bench for support, pull the dumbbell up towards your waist, then lower it slowly."),
                                new Exercise("Reverse Flyes", 3, 15, "With slight bend in knees, bend forward and lift arms outward to engage rear shoulders and back.")
                        )
                ));

// Triceps exercises for men and women
                musclesGroup.add(new MuscleGroup("Triceps",
                        List.of(
                                new Exercise("Tricep Dips", 4, 8, "Use parallel bars or a bench to lower and lift your body, targeting the triceps."),
                                new Exercise("Close-Grip Bench Press", 4, 8, "Lie on a bench, hold the bar with a close grip, and press upwards to engage triceps."),
                                new Exercise("Overhead Tricep Extensions", 4, 10, "Hold a dumbbell overhead and lower it behind your head, then lift back up."),
                                new Exercise("Tricep Pushdowns", 4, 10, "Use a cable machine, pull the handle down to engage triceps, then release slowly."),
                                new Exercise("Skull Crushers", 4, 8, "Lie on a bench, lower the bar to your forehead, then push back up for tricep activation.")
                        ),
                        List.of(
                                new Exercise("Tricep Kickbacks", 3, 15, "With a dumbbell in one hand, extend your arm backward, then return to start."),
                                new Exercise("Overhead Tricep Extensions", 3, 15, "Hold a light dumbbell overhead, lower behind your head, then lift back."),
                                new Exercise("Tricep Dips", 3, 12, "Using a bench, lower and lift your body to engage the triceps."),
                                new Exercise("Close-Grip Push-ups", 3, 20, "Perform push-ups with hands close together to focus on triceps."),
                                new Exercise("Tricep Pushdowns", 3, 15, "Use a lighter weight to perform pushdowns with controlled movement.")
                        )
                ));

// Chest exercises for men and women
                musclesGroup.add(new MuscleGroup("Chest",
                        List.of(
                                new Exercise("Bench Press", 4, 8, "Lie on a bench, press the bar upwards to engage the chest, then lower back down."),
                                new Exercise("Incline Bench Press", 4, 8, "On an incline bench, press the bar upward to target the upper chest."),
                                new Exercise("Chest Flyes", 4, 10, "With dumbbells in each hand, open your arms wide, then bring them together above your chest."),
                                new Exercise("Cable Chest Press", 4, 10, "Use cables to press hands together, feeling the tension in your chest."),
                                new Exercise("Push-ups", 4, 15, "Perform standard push-ups to engage chest and build endurance.")
                        ),
                        List.of(
                                new Exercise("Dumbbell Chest Press", 3, 12, "Press dumbbells up from your chest, then lower down."),
                                new Exercise("Incline Dumbbell Press", 3, 12, "On an incline bench, press dumbbells upward to target upper chest."),
                                new Exercise("Chest Flyes", 3, 15, "Perform flyes with lighter weight for shaping the chest."),
                                new Exercise("Push-ups", 3, 20, "Perform push-ups for increased chest endurance."),
                                new Exercise("Cable Chest Flyes", 3, 15, "Use cables to bring hands together, engaging chest and shoulders.")
                        )
                ));

// Biceps exercises for men and women
                musclesGroup.add(new MuscleGroup("Biceps",
                        List.of(
                                new Exercise("Barbell Curls", 4, 8, "Stand with barbell, curl it towards chest, then lower down."),
                                new Exercise("Hammer Curls", 4, 10, "Hold dumbbells with palms facing inward and curl up."),
                                new Exercise("Preacher Curls", 4, 8, "Use preacher bench to isolate biceps, curl barbell up and down slowly."),
                                new Exercise("EZ Bar Curls", 4, 8, "Hold EZ bar with close grip, curl towards chest, then lower."),
                                new Exercise("Concentration Curls", 4, 10, "Sit with arm resting on thigh, curl dumbbell up, then lower with control.")
                        ),
                        List.of(
                                new Exercise("Dumbbell Curls", 3, 15, "Hold dumbbells, curl up and down for toning."),
                                new Exercise("Hammer Curls", 3, 15, "Perform curls with palms inward to target forearms and biceps."),
                                new Exercise("Cable Curls", 3, 15, "Use cable machine to curl with consistent tension."),
                                new Exercise("Concentration Curls", 3, 15, "Focus on form and contraction with light dumbbell curls."),
                                new Exercise("Barbell Curls", 3, 12, "Barbell curls for strength and definition.")
                        )
                ));

// Shoulders exercises for men and women
                musclesGroup.add(new MuscleGroup("Shoulders",
                        List.of(
                                new Exercise("Overhead Press", 4, 8, "Press weight overhead to target shoulder muscles, then lower."),
                                new Exercise("Arnold Press", 4, 10, "Hold dumbbells, rotate arms as you press up."),
                                new Exercise("Lateral Raises", 4, 12, "Lift dumbbells to sides until shoulder height, then lower."),
                                new Exercise("Front Raises", 4, 10, "Hold dumbbells in front, lift to shoulder height, then lower."),
                                new Exercise("Rear Delt Flyes", 4, 12, "Bend forward slightly, lift arms outward to engage rear deltoids.")
                        ),
                        List.of(
                                new Exercise("Dumbbell Shoulder Press", 3, 12, "Press dumbbells up and lower with control."),
                                new Exercise("Lateral Raises", 3, 15, "Perform lateral raises with lighter weights."),
                                new Exercise("Front Raises", 3, 15, "Lift dumbbells in front to shoulder height."),
                                new Exercise("Reverse Flyes", 3, 15, "Lift weights outward to target rear shoulders."),
                                new Exercise("Upright Rows", 3, 15, "Hold barbell, lift towards chin, then lower.")
                        )
                ));


            }
        }