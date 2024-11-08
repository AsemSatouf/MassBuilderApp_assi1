package com.example.ass1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NutritionBuild extends AppCompatActivity {
CheckBox ckWater;
CheckBox ckSuplements;
CheckBox CkHealthyEating;
Button ViewSelection;
TextView TView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_build);

        ckSuplements=findViewById(R.id.Cksupplements);
        ckWater=findViewById(R.id.CkWater);
        CkHealthyEating=findViewById(R.id.CkHealthyEating);
        ViewSelection=findViewById(R.id.ButtounViewSelection);
        TView=findViewById(R.id.myTextview);

        ViewSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TView.setText("");
                if(ckSuplements.isChecked()){
                    TView.append("Supplements:"+"\n");
                    TView.append("Whey Protein: Enhances muscle growth and aids in post-workout recovery.\n" +
                            "Creatine: Increases endurance and strength.\n" +
                            "BCAA: Prevents muscle breakdown during long workouts.\n" +
                            "Multivitamins: Supports the immune system and boosts energy levels."+"\n");
                }
                if(ckWater.isChecked()){
                    TView.append("\n");
                    TView.append("The Water:"+"\n");
                    TView.append("Drinking 3-4 liters per day: Essential for staying hydrated.\n" +
                            "Benefits of Water: Helps detoxify the body, boosts energy and focus, and aids in muscle recovery."+"\n");
                }
                if(CkHealthyEating.isChecked()){
                    TView.append("\n");
                    TView.append("HealthyEating:"+"\n");
                    TView.append("Proteins: chicken, fish, eggs\n" +
                            "Complex Carbohydrates: brown rice, oats\n" +
                            "Healthy Fats: nuts, olive oil\n" +
                            "Vegetables and Fruits: spinach, broccoli, apples, bananas");
                }
            }
        });

    }
}