package com.example.firstjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      private Button button, b;
      private TextView textView;
      private EditText editText;


    @Override
          protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
           button = findViewById(R.id.button);
           editText=findViewById(R.id.editTextNumber);
           textView=findViewById(R.id.textView);

           b = findViewById(R.id.button2);
           b.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
//                  Toast.makeText(MainActivity.this, "hiiiii", Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                 startActivity(intent);
              }
          });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hii Good Morning", Toast.LENGTH_SHORT).show();
                String s= editText.getText().toString();
                int kg = Integer.parseInt(s);
                double pound = 2.205 * kg;
                textView.setText("The corresponding value in Pounds is " + pound);



            }

        });



    }


    public void move(View view) {
        Button b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hii Good", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(String.valueOf(MainActivity2.class));
//                startActivity(intent);

            }
        });
    }
}
