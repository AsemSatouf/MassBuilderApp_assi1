package com.example.ass1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private String Username ="admin";
private String Password ="1234";
private Button LoginButtoun;
private EditText Editusername;
private  EditText EditPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          LoginButtoun=findViewById(R.id.ButtounLogin);
          Editusername=findViewById(R.id.EditUsername);
           EditPassword =findViewById(R.id.EditPassword);

        LoginButtoun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usname=Editusername.getText().toString();
                String pass=EditPassword.getText().toString();
                if(usname.equals(Username) && pass.equals(Password)){
                    Intent in = new Intent(getBaseContext(),MainActivity2.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
