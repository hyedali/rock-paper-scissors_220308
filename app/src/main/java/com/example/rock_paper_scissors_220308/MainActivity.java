package com.example.rock_paper_scissors_220308;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_OK = 101;

    int winScore = 0, drawScore = 0, loseScore = 0;
    int totalScore = 0; //총 점수

    int randNum;

    String name;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText user_id = findViewById(R.id.user);
        TextView computer_s = findViewById(R.id.computer);
        TextView player_s = findViewById(R.id.player);
        TextView result_s = findViewById(R.id.result);
        TextView score_s = findViewById(R.id.totalScore);
        TextView win_s = findViewById(R.id.winScore);
        TextView lose_s = findViewById(R.id.loseScore);
        TextView draw_s = findViewById(R.id.drawScore);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        user_id.setText(name);

        Button scissorsBtn = findViewById(R.id.scissors);
        scissorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_s.setText("가위");

                randNum = random.nextInt(3) + 1; //1~3까지 난수 생성

                computer_s.setText(rand_print(randNum));

                result_s.setText(result_print(1,randNum));

                win_s.setText(Integer.toString(winScore));
                lose_s.setText(Integer.toString(loseScore));
                draw_s.setText(Integer.toString(drawScore));
                score_s.setText(Integer.toString(totalScore));
            }
        });

        findViewById(R.id.rock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_s.setText("바위");

                randNum = random.nextInt(3) + 1; //1~3까지 난수 생성

                computer_s.setText(rand_print(randNum));

                result_s.setText(result_print(2,randNum));

                win_s.setText(Integer.toString(winScore));
                lose_s.setText(Integer.toString(loseScore));
                draw_s.setText(Integer.toString(drawScore));
                score_s.setText(Integer.toString(totalScore));
            }
        });

        findViewById(R.id.paper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_s.setText("보");

                randNum = random.nextInt(3) + 1; //1~3까지 난수 생성

                computer_s.setText(rand_print(randNum));

                result_s.setText(result_print(3,randNum));

                win_s.setText(Integer.toString(winScore));
                lose_s.setText(Integer.toString(loseScore));
                draw_s.setText(Integer.toString(drawScore));
                score_s.setText(Integer.toString(totalScore));
            }
        });

    }

    public String rand_print(int num){
        String rand_result;
        rand_result = "";
        switch (randNum){
            case 1:
                rand_result = "가위";
                break;
            case 2:
                rand_result = "바위";
                break;
            case 3:
                rand_result = "보";
                break;
        }
        return rand_result;
    }

    public String result_print(int pNum, int cNum){
        String result_print = "";

        if((pNum == 1 && cNum == 3) || (pNum == 2 && cNum == 1)||(pNum == 3 && cNum == 2)){
            result_print = "You Win!";
            winScore += 1;
            totalScore += 10;
        } else if((pNum == 1 && cNum == 2) || (pNum == 2 && cNum == 3) || (pNum == 3 && cNum == 1)){
            result_print = "You Lose!";
            loseScore += 1;
            totalScore -= 10;
        } else{
            result_print = "You Draw!";
            drawScore += 1;
        }

        return result_print;
    }

}
