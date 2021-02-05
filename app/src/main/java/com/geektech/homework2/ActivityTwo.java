package com.geektech.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.geektech.homework2.databinding.ActivityMainBinding;

public class ActivityTwo extends AppCompatActivity {



    EditText editText2;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        button2 = findViewById(R.id.button);
        editText2 = findViewById(R.id.etTextTwo);

        String text = editText2.getText().toString();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTwo.this,MainActivity.class);
                intent.putExtra("key1",text);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}