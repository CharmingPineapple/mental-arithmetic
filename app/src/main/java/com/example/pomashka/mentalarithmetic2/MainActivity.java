package com.example.pomashka.mentalarithmetic2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;




public class MainActivity extends AppCompatActivity {

    //Переменные виджетов
    private Button to1;
    private Button to2;
    private Button to3;
    private Button to4;
    private Button to5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация переменных виджетов (кнопки)
        to1 = findViewById(R.id.to1);
        to2 = findViewById(R.id.to2);
        to3 = findViewById(R.id.to3);
        to4 = findViewById(R.id.to4);
        to5 = findViewById(R.id.to5);

    }
    public void to1 (View v){
        Intent to1 = new Intent(".Activity1");
        startActivity(to1);
    }


}





