package android.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv,correctDisp,wrongDisp;
    Button submit;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {"1+1",
    "22+29",
    "31+38",
    "59+48",
    "12+10"};

    String answers[] = {"2","51","69","107","22"};
    String opt[] = {"1","2","3","4",
            "43","55","51","54",
    "65","102","76","69",
    "102","105","117","107",
    "18","22","26","30"};

    int flag = 0;
    public static int marks = 0 ,correct = 0,wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView score = findViewById(R.id.textView4);
        TextView textView = findViewById(R.id.dispName);

        textView.setText("Hello User");
        submit = findViewById(R.id.button3);
        tv = findViewById(R.id.tvque);
        correctDisp = findViewById(R.id.correctDisp);
        wrongDisp = findViewById(R.id.wrongDisp);

        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton1);
        rb3 = findViewById(R.id.radioButton2);
        rb4 = findViewById(R.id.radioButton3);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Toast.makeText(MainActivity.this, "End of Quiz", Toast.LENGTH_SHORT).show();
                }
                radio_g.clearCheck();
                correctDisp.setText("Correct : "+String.valueOf(correct));
                wrongDisp.setText("Wrong : "+String.valueOf(wrong));
            }
        });
    }
}
