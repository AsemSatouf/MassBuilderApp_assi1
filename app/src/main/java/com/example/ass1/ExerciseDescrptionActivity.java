package com.example.ass1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExerciseDescrptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_descrption);
        TextView viewsets=findViewById(R.id.Viewsets);
        TextView  viewreps=findViewById(R.id.Viewreps);
        TextView  viewdescrption=findViewById(R.id.Viewdescrption);
        TextView name=findViewById(R.id.Viewname);

        String nameEx =getIntent().getStringExtra("name");
        int set=getIntent().getIntExtra("sets",0);
        int reps=getIntent().getIntExtra("reps",0);
        String dec=getIntent().getStringExtra("descprion");

        name.append("\n"+nameEx);
        viewsets.append("\n"+String.valueOf(set));
        viewreps.append("\n"+String.valueOf(reps));
        viewdescrption.append("\n"+dec);
    }
}