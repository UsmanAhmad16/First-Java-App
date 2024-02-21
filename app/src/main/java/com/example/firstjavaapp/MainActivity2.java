package com.example.firstjavaapp;

import static com.example.firstjavaapp.R.id.textView3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {



    EditText editText;
    TextView textView , textView1;

    Button button,button1;

    ImageButton imageButton;
    int second = 0 , milisecond = 0;
    boolean isRunning = false;


    @SuppressLint("MissingInflatedId")
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView =findViewById(textView3);
        textView1=findViewById(R.id.textView4);
        button = findViewById(R.id.button7);
        button1=findViewById(R.id.next);
        imageButton=findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning=false;
                Intent intent = new Intent(getApplicationContext(), MainActivity. class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
    }


    public void start(View view){
        textView1.setText("Hr   Min   Sec   Msec");
        Toast.makeText(MainActivity2.this, "Hii Good Morning", Toast.LENGTH_SHORT).show();
        isRunning = true;
        if(isRunning == true){
            button.setBackgroundColor(Color.parseColor("#FFEB3B"));
            startTimer();
        }
        if(isRunning==true && milisecond != 0){
            button.setText("Start");

        }
     
    }

    public void stop(View view){
    isRunning=false;
        if(isRunning==false && milisecond != 0){
            button.setBackgroundColor(Color.parseColor("#FF4CAF50"));
            button.setText("Resume");

        }

    }

    public void reset(View view){
      isRunning=false;
      second=0;
      milisecond=0;
        button.setBackgroundColor(Color.parseColor("#FF4CAF50"));
        button.setText("Start");



    }

    public void startTimer(){
        Handler handler= new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                milisecond= milisecond%10;
                if(milisecond==9){
                    second++;
                }
                int s = second%60;
                int m = second/60;
                int h= m/60;

                if(isRunning){
                    milisecond++;
                }


                String formatString = String.format(Locale.getDefault(),"%02d : %02d : %02d : %02d",h,m,s,milisecond);
                textView.setText(formatString);
                handler.postDelayed(this, 100);
            }
        };
         handler.post(runnable);


    }

}


