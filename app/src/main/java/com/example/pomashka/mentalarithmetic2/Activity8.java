package com.example.pomashka.mentalarithmetic2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Activity8 extends AppCompatActivity {

    TextView numTime;
    Button showPrev, showNext;
    Button a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, b1, b2, b3, b4, b5, b6, b7, b8, b9, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
    int[] tasksA = new int[10];
    int[] tasksB = new int[9];
    int[] tasksC = new int[11];
    int tasksD50, tasksD100;
    ViewFlipper viewFlipper;
    int gTime;
    int viewFlipInt = 1;
    SharedPreferences saveSettings;
    boolean settingsOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        numTime = findViewById(R.id.numTime);
        viewFlipper = findViewById(R.id.viewFlipper);

        showNext = findViewById(R.id.showNext);
        showPrev = findViewById(R.id.showPrev);

        a1 = findViewById(R.id.a1);     //Инициализация кнопок для выбора примеров
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);

    }


    public void minusTextTime(View v) {
        int num = Integer.parseInt(numTime.getText().toString());     //Установка времени
        if (num > 1) {
            numTime.setText(Integer.toString(num - 1));
        }
    }

    public void plusTextTime(View v) {
        int num = Integer.parseInt(numTime.getText().toString());
        if (num < 5) {
            numTime.setText(Integer.toString(num + 1));
        }
    }


    public void showPrev(View view) {     //Перелистывание страниц примеров
        viewFlipInt -= 1;
        switch (viewFlipInt) {
            case 1:
                showNext.setText("× :");
                showPrev.setText("^ √");
                break;
            case 2:
                showNext.setText("^ √");
                showPrev.setText("+ -");
                break;
            case 0:
                viewFlipInt = 3;
                showNext.setText("+ -");
                showPrev.setText("× :");
                break;
        }
        viewFlipper.showPrevious();
    }

    public void showNext(View view) {
        viewFlipInt += 1;
        switch (viewFlipInt) {
            case 1:
                showNext.setText("× :");
                showPrev.setText("^ √");
                break;
            case 2:
                showNext.setText("^ √");
                showPrev.setText("+ -");
                break;
            case 3:
                showNext.setText("+ -");
                showPrev.setText("× :");
                break;
            case 4:
                viewFlipInt = 1;
                showNext.setText("× :");
                showPrev.setText("^ √");
                break;
        }
        viewFlipper.showNext();
    }


    //Выбор примеров с зарисовкой (НАЖАТИЯ НА КНОПКИ)
    public void taskClick(View view) {
        Button taskButton = (Button) view;
        switch (taskButton.getId()) {

            case R.id.a1:           //Задания А
                if (tasksA[0] == 0) {
                    tasksA[0] = 1;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[0] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a2:
                if (tasksA[1] == 0) {
                    tasksA[1] = 2;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[1] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a3:
                if (tasksA[2] == 0) {
                    tasksA[2] = 3;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[2] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a4:
                if (tasksA[3] == 0) {
                    tasksA[3] = 4;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[3] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a5:
                if (tasksA[4] == 0) {
                    tasksA[4] = 5;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[4] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a6:
                if (tasksA[5] == 0) {
                    tasksA[5] = 6;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[5] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a7:
                if (tasksA[6] == 0) {
                    tasksA[6] = 7;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[6] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a8:
                if (tasksA[7] == 0) {
                    tasksA[7] = 8;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[7] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a9:
                if (tasksA[8] == 0) {
                    tasksA[8] = 9;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[8] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.a10:
                if (tasksA[9] == 0) {
                    tasksA[9] = 10;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksA[9] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;


            case R.id.b1:                    //Задания В
                if (tasksB[0] == 0) {
                    tasksB[0] = 1;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[0] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b2:
                if (tasksB[1] == 0) {
                    tasksB[1] = 2;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[1] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b3:
                if (tasksB[2] == 0) {
                    tasksB[2] = 3;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[2] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b4:
                if (tasksB[3] == 0) {
                    tasksB[3] = 4;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[3] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b5:
                if (tasksB[4] == 0) {
                    tasksB[4] = 5;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[4] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b6:
                if (tasksB[5] == 0) {
                    tasksB[5] = 6;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[5] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b7:
                if (tasksB[6] == 0) {
                    tasksB[6] = 7;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[6] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b8:
                if (tasksB[7] == 0) {
                    tasksB[7] = 8;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[7] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.b9:
                if (tasksB[8] == 0) {
                    tasksB[8] = 9;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksB[8] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;


            case R.id.c1:                    //Задания С
                if (tasksC[0] == 0) {
                    tasksC[0] = 1;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[0] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c2:
                if (tasksC[1] == 0) {
                    tasksC[1] = 2;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[1] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c3:
                if (tasksC[2] == 0) {
                    tasksC[2] = 3;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[2] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c4:
                if (tasksC[3] == 0) {
                    tasksC[3] = 4;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[3] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c5:
                if (tasksC[4] == 0) {
                    tasksC[4] = 5;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[4] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c6:
                if (tasksC[5] == 0) {
                    tasksC[5] = 6;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[5] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c7:
                if (tasksC[6] == 0) {
                    tasksC[6] = 7;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[6] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c8:
                if (tasksC[7] == 0) {
                    tasksC[7] = 8;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[7] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c9:
                if (tasksC[8] == 0) {
                    tasksC[8] = 9;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[8] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c10:
                if (tasksC[9] == 0) {
                    tasksC[9] = 10;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[9] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
            case R.id.c11:
                if (tasksC[10] == 0) {
                    tasksC[10] = 11;
                    taskButton.setTextColor(Color.GRAY);
                } else {
                    tasksC[10] = 0;
                    taskButton.setTextColor(Color.BLACK);
                }
                break;
        }
    }

    public void backTo1(View view) {                          //Возвращение на Act1
        Intent backTo1 = new Intent(".Activity1");
        startActivity(backTo1);
    }

    @Override
    protected void onResume() {     //Возвращение к сохранённому состоянию

        super.onResume();

        saveSettings = getSharedPreferences("settingsOfGame", MODE_PRIVATE);     //Получение сохранённых настроек

        tasksA[0] = saveSettings.getInt("a1", 0);     //Данные
        tasksA[1] = saveSettings.getInt("a2", 0);
        tasksA[2] = saveSettings.getInt("a3", 0);
        tasksA[3] = saveSettings.getInt("a4", 0);
        tasksA[4] = saveSettings.getInt("a5", 0);
        tasksA[5] = saveSettings.getInt("a6", 0);
        tasksA[6] = saveSettings.getInt("a7", 0);
        tasksA[7] = saveSettings.getInt("a8", 0);
        tasksA[8] = saveSettings.getInt("a9", 0);
        tasksA[9] = saveSettings.getInt("a10", 0);

        tasksB[0] = saveSettings.getInt("b1", 0);
        tasksB[1] = saveSettings.getInt("b2", 0);
        tasksB[2] = saveSettings.getInt("b3", 0);
        tasksB[3] = saveSettings.getInt("b4", 0);
        tasksB[4] = saveSettings.getInt("b5", 0);
        tasksB[5] = saveSettings.getInt("b6", 0);
        tasksB[6] = saveSettings.getInt("b7", 0);
        tasksB[7] = saveSettings.getInt("b8", 0);
        tasksB[8] = saveSettings.getInt("b9", 0);

        tasksC[0] = saveSettings.getInt("c1", 0);
        tasksC[1] = saveSettings.getInt("c2", 0);
        tasksC[2] = saveSettings.getInt("c3", 0);
        tasksC[3] = saveSettings.getInt("c4", 0);
        tasksC[4] = saveSettings.getInt("c5", 0);
        tasksC[5] = saveSettings.getInt("c6", 0);
        tasksC[6] = saveSettings.getInt("c7", 0);
        tasksC[7] = saveSettings.getInt("c8", 0);
        tasksC[8] = saveSettings.getInt("c9", 0);
        tasksC[9] = saveSettings.getInt("c10", 0);
        tasksC[10] = saveSettings.getInt("c11", 0);

        gTime = saveSettings.getInt("gTime", 1);

drawing();
    }

    @Override
    protected void onPause() {       //Сохранение состояния | Эти настройки будут приняты в Act1 через getSharedPreferences("settingsOfGame", MODE_PRIVATE)


        SharedPreferences.Editor saveSettingsEdit = saveSettings.edit();
        saveSettingsEdit.clear();
        saveSettingsEdit.putInt("a1", tasksA[0]);
        saveSettingsEdit.putInt("a2", tasksA[1]);
        saveSettingsEdit.putInt("a3", tasksA[2]);
        saveSettingsEdit.putInt("a4", tasksA[3]);
        saveSettingsEdit.putInt("a5", tasksA[4]);
        saveSettingsEdit.putInt("a6", tasksA[5]);
        saveSettingsEdit.putInt("a7", tasksA[6]);
        saveSettingsEdit.putInt("a8", tasksA[7]);
        saveSettingsEdit.putInt("a9", tasksA[8]);
        saveSettingsEdit.putInt("a10", tasksA[9]);


        saveSettingsEdit.putInt("b1", tasksB[0]);
        saveSettingsEdit.putInt("b2", tasksB[1]);
        saveSettingsEdit.putInt("b3", tasksB[2]);
        saveSettingsEdit.putInt("b4", tasksB[3]);
        saveSettingsEdit.putInt("b5", tasksB[4]);
        saveSettingsEdit.putInt("b6", tasksB[5]);
        saveSettingsEdit.putInt("b7", tasksB[6]);
        saveSettingsEdit.putInt("b8", tasksB[7]);
        saveSettingsEdit.putInt("b9", tasksB[8]);


        saveSettingsEdit.putInt("c1", tasksC[0]);
        saveSettingsEdit.putInt("c2", tasksC[1]);
        saveSettingsEdit.putInt("c3", tasksC[2]);
        saveSettingsEdit.putInt("c4", tasksC[3]);
        saveSettingsEdit.putInt("c5", tasksC[4]);
        saveSettingsEdit.putInt("c6", tasksC[5]);
        saveSettingsEdit.putInt("c7", tasksC[6]);
        saveSettingsEdit.putInt("c8", tasksC[7]);
        saveSettingsEdit.putInt("c9", tasksC[8]);
        saveSettingsEdit.putInt("c10", tasksC[9]);
        saveSettingsEdit.putInt("c11", tasksC[10]);

        gTime = Integer.parseInt(numTime.getText().toString());
        saveSettingsEdit.putInt("gTime", gTime);

        saveSettingsEdit.apply();

        super.onPause();
    }



    public void drawing() {
        //Отрисовка

        numTime.setText(Integer.toString(gTime));

        if (tasksA[0] > 0) {             //А
            a1.setTextColor(Color.GRAY);
        }
        if (tasksA[1] > 0) {
            a2.setTextColor(Color.GRAY);
        }
        if (tasksA[2] > 0) {
            a3.setTextColor(Color.GRAY);
        }
        if (tasksA[3] > 0) {
            a4.setTextColor(Color.GRAY);
        }
        if (tasksA[4] > 0) {
            a5.setTextColor(Color.GRAY);
        }
        if (tasksA[5] > 0) {
            a6.setTextColor(Color.GRAY);
        }
        if (tasksA[6] > 0) {
            a7.setTextColor(Color.GRAY);
        }
        if (tasksA[7] > 0) {
            a8.setTextColor(Color.GRAY);
        }
        if (tasksA[8] > 0) {
            a9.setTextColor(Color.GRAY);
        }
        if (tasksA[9] > 0) {
            a10.setTextColor(Color.GRAY);
        }

        if (tasksB[0] > 0) {              //В
            b1.setTextColor(Color.GRAY);
        }
        if (tasksB[1] > 0) {
            b2.setTextColor(Color.GRAY);
        }
        if (tasksB[2] > 0) {
            b3.setTextColor(Color.GRAY);
        }
        if (tasksB[3] > 0) {
            b4.setTextColor(Color.GRAY);
        }
        if (tasksB[4] > 0) {
            b5.setTextColor(Color.GRAY);
        }
        if (tasksB[5] > 0) {
            b6.setTextColor(Color.GRAY);
        }
        if (tasksB[6] > 0) {
            b7.setTextColor(Color.GRAY);
        }
        if (tasksB[7] > 0) {
            b8.setTextColor(Color.GRAY);
        }
        if (tasksB[8] > 0) {
            b9.setTextColor(Color.GRAY);
        }

        if (tasksC[0] > 0) {            //С
            c1.setTextColor(Color.GRAY);
        }
        if (tasksC[1] > 0) {
            c2.setTextColor(Color.GRAY);
        }
        if (tasksC[2] > 0) {
            c3.setTextColor(Color.GRAY);
        }
        if (tasksC[3] > 0) {
            c4.setTextColor(Color.GRAY);
        }
        if (tasksC[4] > 0) {
            c5.setTextColor(Color.GRAY);
        }
        if (tasksC[5] > 0) {
            c6.setTextColor(Color.GRAY);
        }
        if (tasksC[6] > 0) {
            c7.setTextColor(Color.GRAY);
        }
        if (tasksC[7] > 0) {
            c8.setTextColor(Color.GRAY);
        }
        if (tasksC[8] > 0) {
            c9.setTextColor(Color.GRAY);
        }
        if (tasksC[9] > 0) {
            c10.setTextColor(Color.GRAY);
        }
        if (tasksC[10] > 0) {
            c11.setTextColor(Color.GRAY);
        }

    }


}