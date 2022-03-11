package com.example.rock_paper_scissors_220308;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    public static final int RESULT_OK = 101;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id = findViewById(R.id.userId);
                name = String.valueOf(id.getText());

                //Toast.makeText(StartActivity.this, name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext() ,MainActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
    }
}