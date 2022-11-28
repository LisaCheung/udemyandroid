package com.example.sharedpreferences19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);
        showSavedText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveText(editText.getText().toString());
            }
        });
    }
    private void showSavedText(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        String temp= sharedPreferences.getString("input", "no input");
        textView.setText(temp);
    }
    private void saveText(String input){
        textView.setText(input);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("input", input);
        editor.commit();
    }
}