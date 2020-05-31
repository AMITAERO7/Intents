package com.hackernight.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonGuess ;
    EditText editEnteredGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGuess = findViewById(R.id.button_guess);
        editEnteredGuess = findViewById(R.id.editTextGuess);

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = editEnteredGuess.getText().toString();
                if (!name.isEmpty()){
                    Intent intent = new Intent(MainActivity.this,ShowGuess.class);
                    intent.putExtra("guess",name);
                    intent.putExtra("name","Amit Kumar");
                    intent.putExtra("age",21);
                    startActivityForResult(intent,REQUEST_CODE);
                    //startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pls Enter Name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            String messagefromSecondActivity = data.getStringExtra("back_message").toString();
            Toast.makeText(this, ""+messagefromSecondActivity, Toast.LENGTH_SHORT).show();
        }
    }
}