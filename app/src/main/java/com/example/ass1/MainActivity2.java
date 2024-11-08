package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
private Button Buttounexercises;
private Button BtNB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     Buttounexercises=findViewById(R.id.Buttounexercises);
     BtNB=findViewById(R.id.ButtounNutritionBuild);

      BtNB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in2 = new Intent(getBaseContext(),NutritionBuild.class);

            startActivity(in2);
        }
    });

    Buttounexercises.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in = new Intent(getBaseContext(),MuscleGroupActivity.class);

            startActivity(in);
        }
    });
    }
}