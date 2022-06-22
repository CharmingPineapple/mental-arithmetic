package com.example.pomashka.mentalarithmetic2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Random;

public class Activity1 extends AppCompatActivity {

    Button next;
    Button delete;
    Button addDot;
    TextView equalText;
    TextView task;
    TextView answer;
    TextView timer;
    boolean gameStarted;
    int gTime;
    int[] tasksA = new int[10];
    int[] tasksTestA = new int[10];
    int[] tasksB = new int[9];
    int[] tasksTestB = new int[9];
    int[] tasksC = new int[11];
    int[] tasksTestC = new int[11];
    int lengthA = 0, lengthB = 0, lengthC = 0;
    int tasksD50, tasksD100;
    SharedPreferences saveSettings;
    final Random random = new Random();

    int numTasks = 0;


    String[] textAllTasks;
    String textTask;
    String[] textAllTrueAnswer;
    String textTrueAnswer;
    String[] textAllUsersAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        next = findViewById(R.id.next);     //Инициализация кнопок
        delete = findViewById(R.id.delete);
        addDot = findViewById(R.id.addDot);
        task = findViewById(R.id.task);
        timer = findViewById(R.id.timer);
        answer = findViewById(R.id.answer);
        equalText = findViewById(R.id.equal);
    }


    public void addNum(View view) {     //Ввод ответа посимвольно
        Button clickNum = (Button) view;
        answer.append(clickNum.getText());
        delete.setEnabled(true);

        //Запрет на написание несуществующих чисел. Например: 0003, 1...234..1 и тп

        if (answer.getText().toString().equals("0")) {     //Преобразования нуля с индесом 0
            answer.setText("0.");
        }

        if (answer.getText().toString().contains(".")) {     //Запрет на вторую точку
            addDot.setEnabled(false);
        } else {
            addDot.setEnabled(true);
        }
        if (answer.getText().toString().equals(".")) {     //Преобразования точки с индексом 0
            answer.setText("0.");
            addDot.setEnabled(false);
        }
    }


    public void delete(View view) {     //Удаление символа
        if (answer.getText().toString().equals("0.")) {
            answer.setText("");
        }

        if (answer.length() > 0) {     //Удаление одного символа
            String textAns = answer.getText().toString();
            answer.setText(textAns.substring(0, answer.length() - 1));
        } else {
            delete.setEnabled(false);
        }

        if (!answer.getText().toString().contains(".")) {     //Разрешение на ввод точки после её удаления
            addDot.setEnabled(true);
        }
    }


    public void start(View view) {         //Старт сессии///////////////////////////////////////////////////////////////////////////////////////

        if ((gameStarted)&&(answer.getText().toString().length()>0)) {   //Выдача заданий | Работа с кнопкой NEXT

            // Ввод ответа: занесение в массивы ответ юзера, правильный ответ, их сравнение, текст задания
            textAllUsersAnswer[numTasks] = answer.getText().toString();
            textAllTasks[numTasks] = textTask;
            textAllTrueAnswer[numTasks] = textTrueAnswer;

            startGameMain();
            task.setText(textTask);


        }


        if (!gameStarted) {   // Игра начата

            //Проверка на наличие настроек и включение таймера
            if (!((lengthA + lengthB + lengthC) == 0)) {
                gameStarted = true;                       //  | Однозначный запуск сессии
                next.setText("next");        //Изменение кнопки

                startGameMain();
                task.setText(textTask);


                new CountDownTimer(gTime * 60000, 1000) {      //Запуск таймера
                    public void onTick(long millisUntilFinished) {
                        String time = String.valueOf(millisUntilFinished / 1000);
                        timer.setText(time);
                    }

                    public void onFinish() {     //Конец сессии, переход на активити вывода

                        timer.setText("End.");
                    }
                }.start();
            } else {
                String settingsOff = "Настройки сессии не заданы.";       //Если ни одно задание не выбрано
                Toast.makeText(Activity1.this, settingsOff, Toast.LENGTH_SHORT).show();
            }
        }



    }


    public void to8(View view) {     //Переход на страницу с настройками (Передачи данных не происходит)
        Intent to8 = new Intent(".Activity8");
        startActivity(to8);
    }

    public void test(View view) {
        task.setText(Integer.toString(tasksA[2]));
    }


    public void startA() {
        int aA;
        int bB;
        switch (tasksA[random.nextInt(lengthA)]) {
            case 0:
                textTask = "Error!";
                break;
            case 1:
                aA = random.nextInt(9) + 1;
                bB = random.nextInt(9) + 1;
                textTask = aA + "+" + bB;
                textTrueAnswer = Integer.toString(aA + bB);
                break;
            case 2:
                aA = random.nextInt(90) + 10;
                bB = random.nextInt(9) + 1;
                textTask = aA + "+" + bB;
                textTrueAnswer = Integer.toString(aA + bB);
                break;
            case 3:
                aA = random.nextInt(90) + 10;
                bB = random.nextInt(90) + 10;
                textTask = aA + "+" + bB;
                textTrueAnswer = Integer.toString(aA + bB);
                break;
            case 4:
                aA = random.nextInt(899) + 100;
                bB = random.nextInt(89) + 10;
                textTask = aA + "+" + bB;
                textTrueAnswer = Integer.toString(aA + bB);
                break;
            case 5:
                aA = random.nextInt(899) + 100;
                bB = random.nextInt(899) + 100;
                textTask = aA + "+" + bB;
                textTrueAnswer = Integer.toString(aA + bB);
                break;
            case 6:
                aA = random.nextInt(9) + 1;
                bB = random.nextInt(9) + 1;
                while (aA < bB) {
                    aA = random.nextInt(9) + 1;
                    bB = random.nextInt(9) + 1;
                }
                textTask = aA + "-" + bB;
                textTrueAnswer = Integer.toString(aA - bB);
                break;
            case 7:
                aA = random.nextInt(89) + 1;
                bB = random.nextInt(9) + 1;
                while (aA < bB) {
                    aA = random.nextInt(89) + 10;
                    bB = random.nextInt(9) + 1;
                }
                textTask = aA + "-" + bB;
                textTrueAnswer = Integer.toString(aA - bB);
                break;
            case 8:
                aA = random.nextInt(89) + 10;
                bB = random.nextInt(89) + 10;
                while (aA < bB) {
                    aA = random.nextInt(89) + 10;
                    bB = random.nextInt(89) + 10;
                }
                textTask = aA + "-" + bB;
                textTrueAnswer = Integer.toString(aA - bB);
                break;
            case 9:
                aA = random.nextInt(899) + 100;
                bB = random.nextInt(89) + 10;
                while (aA < bB) {
                    aA = random.nextInt(899) + 100;
                    bB = random.nextInt(89) + 10;
                }
                textTask = aA + "-" + bB;
                textTrueAnswer = Integer.toString(aA - bB);
                break;
            case 10:
                aA = random.nextInt(899) + 100;
                bB = random.nextInt(899) + 100;
                while (aA < bB) {
                    aA = random.nextInt(899) + 100;
                    bB = random.nextInt(899) + 100;
                }
                textTask = aA + "-" + bB;
                textTrueAnswer = Integer.toString(aA - bB);
                break;
        }
    }

    public void startB() {
        int aB;
        int bB;
        switch (tasksB[random.nextInt(lengthB)]) {
            case 0:
                textTask = "Error!";
                break;
            case 1:
                aB = random.nextInt(9) + 1;
                bB = random.nextInt(9) + 1;
                textTask = aB + "×" + bB;
                textTrueAnswer = Integer.toString(aB * bB);
                break;
            case 2:
                aB = random.nextInt(89) + 10;
                bB = random.nextInt(9) + 1;
                textTask = aB + "×" + bB;
                textTrueAnswer = Integer.toString(aB * bB);
                break;
            case 3:
                aB = random.nextInt(89) + 10;
                bB = random.nextInt(89) + 10;
                textTask = aB + "×" + bB;
                textTrueAnswer = Integer.toString(aB * bB);
                break;
            case 4:
                aB = random.nextInt(899) + 100;
                bB = random.nextInt(89) + 10;
                textTask = aB + "×" + bB;
                textTrueAnswer = Integer.toString(aB * bB);
                break;
            case 5:
                aB = random.nextInt(9) + 1;
                bB = random.nextInt(8) + 2;
                while (!(((aB % bB) == 0) && (aB != bB))) {
                    aB = random.nextInt(9) + 1;
                    bB = random.nextInt(8) + 2;
                }
                textTask = aB + ":" + bB;
                textTrueAnswer = Integer.toString(aB / bB);
                break;
            case 6:
                aB = random.nextInt(89) + 10;
                bB = random.nextInt(8) + 2;
                while (!(((aB % bB) == 0) && (aB != bB))) {
                    aB = random.nextInt(89) + 10;
                    bB = random.nextInt(8) + 2;
                }
                textTask = aB + ":" + bB;
                textTrueAnswer = Integer.toString(aB / bB);
                break;
            case 7:
                aB = random.nextInt(89) + 10;
                bB = random.nextInt(89) + 10;
                while (!(((aB % bB) == 0) && (aB != bB))) {
                    aB = random.nextInt(89) + 10;
                    bB = random.nextInt(89) + 10;
                }
                textTask = aB + ":" + bB;
                textTrueAnswer = Integer.toString(aB / bB);
                break;
            case 8:
                aB = random.nextInt(899) + 100;
                bB = random.nextInt(89) + 10;
                while (!(((aB % bB) == 0) && (aB != bB))) {
                    aB = random.nextInt(899) + 100;
                    bB = random.nextInt(89) + 10;
                }
                textTask = aB + ":" + bB;
                textTrueAnswer = Integer.toString(aB / bB);
                break;
            case 9:
                aB = random.nextInt(899) + 100;
                bB = random.nextInt(899) + 100;
                while (!(((aB % bB) == 0) && (aB != bB))) {
                    aB = random.nextInt(899) + 100;
                    bB = random.nextInt(899) + 100;
                }
                textTask = aB + ":" + bB;
                textTrueAnswer = Integer.toString(aB / bB);
                break;
        }
    }

    public void startC() {
        int aC, bC = 3, cC, dC = 3, v;
        switch (tasksC[random.nextInt(lengthC)]) {
            case 0:
                textTask = "Error!";
                break;
            case 1:
                aC = random.nextInt(8) + 2;
                switch (aC) {
                    case 2:
                        bC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        bC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        bC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        bC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        bC = random.nextInt(2) + 2;
                        break;
                }
                textTask = aC + "^" + bC;
                textTrueAnswer = Double.toString(Math.pow(aC, bC));
                break;

            case 2:
                aC = random.nextInt(30) + 10;
                bC = 2;
                textTask = aC + "^" + bC;
                textTrueAnswer = Double.toString(Math.pow(aC, bC));
                break;

            case 3:
                aC = random.nextInt(8) + 2;
                switch (aC) {
                    case 2:
                        bC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        bC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        bC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        bC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        bC = random.nextInt(2) + 2;
                        break;
                }
                v = random.nextInt(2);
                switch (v) {
                    case 0: // +
                        cC = random.nextInt(8) + 2;
                        textTask = aC + "^" + bC + "+" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) + cC);
                        break;
                    case 1: // -
                        cC = random.nextInt(8) + 2;
                        while ((Math.pow(aC, bC) - cC) < 0) {
                            cC = random.nextInt(8) + 2;
                        }
                        textTask = aC + "^" + bC + "-" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) - cC);
                        break;
                }
                break;
            case 4:
                aC = random.nextInt(8) + 2;
                switch (aC) {
                    case 2:
                        bC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        bC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        bC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        bC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        bC = random.nextInt(2) + 2;
                        break;
                }
                v = random.nextInt(2);
                switch (v) {
                    case 0: // +
                        cC = random.nextInt(90) + 10;
                        textTask = aC + "^" + bC + "+" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) + cC);
                        break;
                    case 1: // -
                        cC = random.nextInt(90) + 10;
                        while ((Math.pow(aC, bC) - cC) < 0) {
                            cC = random.nextInt(90) + 10;
                        }
                        textTask = aC + "^" + bC + "-" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) - cC);
                        break;
                }
                break;
            case 5:
                aC = random.nextInt(8) + 2;   //  ac^bC  cC^dC
                cC = random.nextInt(8) + 2;
                switch (aC) {
                    case 2:
                        bC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        bC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        bC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        bC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        bC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        bC = random.nextInt(2) + 2;
                        break;
                }
                switch (cC) {
                    case 2:
                        dC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        dC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        dC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        dC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        dC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        dC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        dC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        dC = random.nextInt(2) + 2;
                        break;
                }
                v = random.nextInt(2);
                switch (v) {
                    case 0: // +
                        textTask = aC + "^" + bC + "+" + cC + "^" + dC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) + Math.pow(cC, dC));
                        break;
                    case 1: // -

                        while (Math.pow(aC, bC) < Math.pow(cC, dC)) {
                            cC = random.nextInt(8) + 2;
                            switch (cC) {
                                case 2:
                                    dC = random.nextInt(9) + 2;
                                    break;
                                case 3:
                                    dC = random.nextInt(5) + 2;
                                    break;
                                case 4:
                                    dC = random.nextInt(4) + 2;
                                    break;
                                case 5:
                                    dC = random.nextInt(3) + 2;
                                    break;
                                case 6:
                                    dC = random.nextInt(2) + 2;
                                    break;
                                case 7:
                                    dC = random.nextInt(2) + 2;
                                    break;
                                case 8:
                                    dC = random.nextInt(2) + 2;
                                    break;
                                case 9:
                                    dC = random.nextInt(2) + 2;
                                    break;
                            }
                        }
                        textTask = aC + "^" + bC + "-" + cC + "^" + dC;
                        textTrueAnswer = Double.toString(Math.pow(aC, bC) - Math.pow(cC, dC));
                        break;
                }
                break;
            case 6:
                aC = random.nextInt(30) + 2;
                bC = random.nextInt(9) + 2;
                cC = random.nextInt(2) + 2;
                v = random.nextInt(2);
                switch (v) {
                    case 0: // +
                        aC = random.nextInt(20) + 2;
                        textTask = "(" + aC + "+" + bC + ")" + "^" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC + bC, cC));
                        break;
                    case 1: // -
                        while (((aC - bC) == 1) && (aC < bC)) {
                            bC = random.nextInt(9) + 2;
                        }
                        textTask = "(" + aC + "-" + bC + ")" + "^" + cC;
                        textTrueAnswer = Double.toString(Math.pow(aC - bC, cC));
                        break;
                }
                break;
            case 7:
                aC = 4;
                v = random.nextInt(2);
                switch (v) {
                    case 0:
                        aC = 4;
                        break;
                    case 1:
                        aC = 9;
                        break;
                }
                textTask = "√" + aC;
                textTrueAnswer = Double.toString(Math.sqrt(aC));
                break;
            case 8:
                aC = 16;
                v = random.nextInt(6);
                switch (v) {
                    case 0: // 16
                        aC = 16;
                        break;
                    case 1: // 25
                        aC = 25;
                        break;
                    case 2: // 36
                        aC = 36;
                        break;
                    case 3: // 49
                        aC = 49;
                        break;
                    case 4: // 64
                        aC = 64;
                        break;
                    case 5: // 81
                        aC = 81;
                        break;
                }
                textTask = "√" + aC;
                textTrueAnswer = Double.toString(Math.sqrt(aC));
                break;
            case 9:
                v = random.nextInt(6);
                aC = 16;
                bC = random.nextInt(9) + 2;
                switch (v) {
                    case 0: // 16
                        aC = 16;
                        break;
                    case 1: // 25
                        aC = 25;
                        break;
                    case 2: // 36
                        aC = 36;
                        break;
                    case 3: // 49
                        aC = 49;
                        break;
                    case 4: // 64
                        aC = 64;
                        break;
                    case 5: // 81
                        aC = 81;
                        break;
                }
                textTask = "√" + aC + "×" + bC;
                textTrueAnswer = Double.toString(Math.sqrt(aC) * bC);
                break;
            case 10:
                v = random.nextInt(6);
                aC = 16;
                bC = random.nextInt(89) + 2;
                switch (v) {
                    case 0: // 16
                        aC = 16;
                        break;
                    case 1: // 25
                        aC = 25;
                        break;
                    case 2: // 36
                        aC = 36;
                        break;
                    case 3: // 49
                        aC = 49;
                        break;
                    case 4: // 64
                        aC = 64;
                        break;
                    case 5: // 81
                        aC = 81;
                        break;
                }
                textTask = "√" + aC + "×" + bC;
                textTrueAnswer = Double.toString(Math.sqrt(aC) * bC);
                break;
            case 11:
                v = random.nextInt(15);
                aC = 16;
                cC = 3;
                switch (v) {
                    case 0: // 16
                        aC = 16;
                        break;
                    case 1: // 25
                        aC = 25;
                        break;
                    case 2: // 36
                        aC = 36;
                        break;
                    case 3: // 49
                        aC = 49;
                        break;
                    case 4: // 64
                        aC = 64;
                        break;
                    case 5: // 81
                        aC = 81;
                        break;
                    case 6: // 121
                        aC = 121;
                        break;
                    case 7: // 144
                        aC = 144;
                        break;
                    case 8: // 169
                        aC = 169;
                        break;
                    case 9: // 196
                        aC = 196;
                        break;
                    case 10: // 225
                        aC = 225;
                        break;
                    case 11: // 256
                        aC = 256;
                        break;
                    case 12: // 289
                        aC = 289;
                        break;
                    case 13: // 324
                        aC = 324;
                        break;
                    case 14: // 361
                        aC = 361;
                        break;
                }
                bC = random.nextInt(8) + 2;
                switch (bC) {
                    case 2:
                        cC = random.nextInt(9) + 2;
                        break;
                    case 3:
                        cC = random.nextInt(5) + 2;
                        break;
                    case 4:
                        cC = random.nextInt(4) + 2;
                        break;
                    case 5:
                        cC = random.nextInt(3) + 2;
                        break;
                    case 6:
                        cC = random.nextInt(2) + 2;
                        break;
                    case 7:
                        cC = random.nextInt(2) + 2;
                        break;
                    case 8:
                        cC = random.nextInt(2) + 2;
                        break;
                    case 9:
                        cC = random.nextInt(2) + 2;
                        break;
                }
                textTask = "√" + aC + "×" + bC + "^" + cC;
                textTrueAnswer = Double.toString(Math.sqrt(aC) * (Math.pow(bC, cC)));
                break;
        }
    }

    public void startGameMain() {
        switch (random.nextInt(4)) {
            case 0:
                if ((lengthA) != 0) {
                    startA();
                    break;
                } else {
                    if ((lengthC) != 0) {
                        startC();
                        break;
                    } else {
                        if ((lengthB) != 0) {
                            startB();
                            break;
                        }
                    }
                }
            case 1:
                if ((lengthB) != 0) {
                    startB();
                    break;
                } else {
                    if ((lengthA) != 0) {
                        startA();
                        break;
                    } else {
                        if ((lengthC) != 0) {
                            startC();
                            break;
                        }
                    }
                }
            case 2:
                if ((lengthC) != 0) {
                    startC();
                    break;
                } else {
                    if ((lengthA) != 0) {
                        startA();
                        break;
                    } else {
                        if ((lengthB) != 0) {
                            startB();
                            break;
                        }
                    }
                }
            case 4:
                if ((lengthA == 0) || (lengthB == 0) || (lengthC == 0)) {
                    if ((lengthB) != 0) {
                        startB();
                        break;
                    } else {
                        if ((lengthC) != 0) {
                            startC();
                            break;
                        }
                    }
                } else {
                    startGameMain();
                }
        }
    }

    @Override
    protected void onResume() {
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


        sortArrays();

    }

    public void sortArrays() {
        tasksTestA = tasksA;
        tasksTestB = tasksB;
        tasksTestC = tasksC;

        int y, x = 0;
        //Сортировка А
        for (y = 0; y < 10; ) {
            if (tasksA[y] != 0) {
                tasksA[x] = tasksTestA[y];
                x++;
            }
            y++;
        }
        lengthA = x;
        while (x < 10) {
            tasksA[x] = 0;
            x++;
        }
        x = 0;
        y = 0;
        //Сортировка В
        for (y = 0; y < 9; ) {
            if (tasksB[y] != 0) {
                tasksB[x] = tasksTestB[y];
                x++;
            }
            y++;
        }
        lengthB = x;
        while (x < 9) {
            tasksB[x] = 0;
            x++;
        }
        x = 0;
        y = 0;

        //Сортировка C
        for (y = 0; y < 11; ) {
            if (tasksC[y] != 0) {
                tasksC[x] = tasksTestC[y];
                x++;
            }
            y++;
        }
        lengthC = x;
        while (x < 11) {
            tasksC[x] = 0;
            x++;
        }


    }
}
