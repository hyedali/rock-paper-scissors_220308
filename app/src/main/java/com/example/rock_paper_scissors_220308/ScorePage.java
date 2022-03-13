package com.example.rock_paper_scissors_220308;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScorePage extends AppCompatActivity {
    TextView textView;

    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        textView = findViewById(R.id.memo);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);

    }

    private void processIntent(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            DataSave data = bundle.getParcelable(KEY_SIMPLE_DATA);
            if(intent != null){
                textView.setText("아이디 : " + data.message + "\n 점수 : " + data.number);
            }
        }
    }
}