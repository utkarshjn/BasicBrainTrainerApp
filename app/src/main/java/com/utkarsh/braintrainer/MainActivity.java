package com.utkarsh.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button5;
    GridLayout myGridLayout;
    TextView scoreText;
    TextView timerText;
    TextView finishText;
    Button button6;
    TextView questionText;
    TextView first;
    TextView second;
    TextView third;
    TextView fourth;
    ImageView imageView1;
    int c;
    int i=0;
    int j=0;

    public void generateQuestion(){
        int text1=Integer.parseInt(first.getTag().toString());
        int text2=Integer.parseInt(second.getTag().toString());
        int text3=Integer.parseInt(third.getTag().toString());
        int text4=Integer.parseInt(fourth.getTag().toString());
        Random rand=new Random();
        int a=rand.nextInt(21); //Generates random number between 0-20
        int b=rand.nextInt(21);
        int ans=a+b;
        questionText.setText(Integer.toString(a)+" + "+Integer.toString(b));

        c=rand.nextInt(4)+1; //Generates random number between 1-4
        if(text1==c){
            first.setText(Integer.toString(ans));
        }else{
            first.setText(Integer.toString(rand.nextInt(41)));
            while(Integer.toString(ans)==first.getText()){
                first.setText(Integer.toString(rand.nextInt(41)));
            }
        }
        if(text2==c){
            second.setText(Integer.toString(ans));
        }else{
            second.setText(Integer.toString(rand.nextInt(41)));
            while(Integer.toString(ans)==second.getText()){
                second.setText(Integer.toString(rand.nextInt(41)));
            }
        }
        if(text3==c){
            third.setText(Integer.toString(ans));
        }else{
            third.setText(Integer.toString(rand.nextInt(41)));
            while(Integer.toString(ans)==third.getText()){
                third.setText(Integer.toString(rand.nextInt(41)));
            }
        }
        if(text4==c){
            fourth.setText(Integer.toString(ans));
        }else{
            fourth.setText(Integer.toString(rand.nextInt(41)));
            while(Integer.toString(ans)==fourth.getText()){
                fourth.setText(Integer.toString(rand.nextInt(41)));
            }
        }
    }


    public void numberPressed(View view){
        int tappedCounter=Integer.parseInt(view.getTag().toString());
        if(tappedCounter==c){
            finishText.setText("Correct");
            i++;
            j++;
        }
        else{
            finishText.setText("Wrong");
            j++;
        }
        generateQuestion();
        scoreText.setText(Integer.toString(i)+"/"+Integer.toString(j));
    }

    public void gameTimer(){
        new CountDownTimer(30000,1000){
            public void onTick(long millisecondsUntilDone ){
                timerText.setText(Integer.toString((int)millisecondsUntilDone/1000));
            }
            public void onFinish(){
                timerText.setText("0");
                finishText.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                first.setClickable(false);
                second.setClickable(false);
                third.setClickable(false);
                fourth.setClickable(false);
                if(i>=10){
                    finishText.setText("Your Score: "+scoreText.getText()+"\nYou are quite intelligent!");
                }
                else if(i<10&&i>5){
                    finishText.setText("Your Score: "+scoreText.getText()+"\nYou can do better");
                }
                else{
                    finishText.setText("Your Score: "+scoreText.getText()+"\nYou need to improve");
                }
            }

        }.start();
    }

    public void playButton(View view){
        button5.setVisibility(View.INVISIBLE);
        myGridLayout.setVisibility(View.VISIBLE);
        scoreText.setVisibility(View.VISIBLE);
        timerText.setVisibility(View.VISIBLE);
        questionText.setVisibility(View.VISIBLE);
        finishText.setVisibility(View.VISIBLE);
        gameTimer();
        generateQuestion();
        imageView1.animate().alpha(0f).setDuration(500);
    }
    public void againButton(View view){
        i=0;
        j=0;
        button6.setVisibility(View.INVISIBLE);
        finishText.setVisibility(View.INVISIBLE);
        scoreText.setText("0/0");
        gameTimer();
        generateQuestion();
        first.setClickable(true);
        second.setClickable(true);
        third.setClickable(true);
        fourth.setClickable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button5=(Button)findViewById(R.id.button5);
        myGridLayout=(GridLayout)findViewById(R.id.myGridLayout);
        scoreText=(TextView)findViewById(R.id.scoreText);
        timerText=(TextView)findViewById(R.id.timerText);
        finishText=(TextView)findViewById(R.id.finishText);
        questionText=(TextView)findViewById(R.id.questionText);
        button6=(Button)findViewById(R.id.button6);
        first=(TextView)findViewById(R.id.textView1);
        second=(TextView)findViewById(R.id.textView2);
        third=(TextView)findViewById(R.id.textView3);
        fourth=(TextView)findViewById(R.id.textView4);
        imageView1=(ImageView)findViewById(R.id.imageView1);
    }
}
