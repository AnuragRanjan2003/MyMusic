package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        LottieAnimationView splashanimation;
        Button login,signup;
        TextView skip;
        login=findViewById(R.id.loginbtn);
        signup=findViewById(R.id.signupbtn);
        skip=findViewById(R.id.tvskip);
        splashanimation=findViewById(R.id.roundanim);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setVisibility(View.INVISIBLE);
                signup.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.INVISIBLE);
                splashanimation.setVisibility(View.VISIBLE);
                splashanimation.playAnimation();
                Thread thread=new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            Intent intent=new Intent(MainActivity.this,signupActivity.class);

                            startActivity(intent);
                        }

                    }
                };thread.start();
                Toast.makeText(MainActivity.this, "Redirecting to signup", Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setVisibility(View.INVISIBLE);
                signup.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.INVISIBLE);
                splashanimation.setVisibility(View.VISIBLE);
                splashanimation.playAnimation();
                Thread thread=new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);

                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            Intent intent=new Intent(MainActivity.this,loginActivity.class);
                            startActivity(intent);

                        }

                    }
                };thread.start();
                Toast.makeText(MainActivity.this, "Redirecting to login", Toast.LENGTH_SHORT).show();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,songlistActivity.class);
                startActivity(intent);
            }
        });

    }
}