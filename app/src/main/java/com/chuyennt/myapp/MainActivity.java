package com.chuyennt.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btCe;
    private Button btC;
    private ImageButton btBs;
    private Button btInverse;
    private TextView result;
    private TextView answer;
    private ArrayList<Double> num = new ArrayList<>();
    private ArrayList<String> op = new ArrayList<>();
    private int i = 0;
    private int j = 0;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("0");
                result.setText("");
                i = 0;
                j = 0;
                num.clear();
                op.clear();
                flag = false;
            }
        });

        btCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("0");
            }
        });

        btInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().charAt(0) == '-') {
                    answer.setText(answer.getText().toString().substring(1));
                }
                else {
                    answer.setText("-"+answer.getText().toString());
                }
            }
        });

        btBs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().length() <= 1) {
                    answer.setText("0");
                }
                if (!answer.getText().toString().equals("0")) {
                    answer.setText(answer.getText().toString().substring(0,answer.getText().toString().length()-1));
                }
            }
        });
    }

    private void mapping() {
        btCe = findViewById(R.id.button);
        btC = findViewById(R.id.button2);
        btBs = findViewById(R.id.button3);
        btInverse = findViewById(R.id.button17);
        result = findViewById(R.id.result);
        answer = findViewById(R.id.answer);
    }

    public void click(View view) {
        if (answer.getText().toString().equals("0")) {
            answer.setText("");
        }
        answer.setText(answer.getText().toString()+((Button)view).getText().toString());
    }

    public void click1(View view) {
        num.add(Double.parseDouble(answer.getText().toString()));
        op.add(((Button)view).getText().toString());
        if (flag) {
            result.setText(answer.getText().toString()+((Button)view).getText().toString());
            flag = false;
        } else {
            result.setText(result.getText().toString()+answer.getText().toString()+((Button)view).getText().toString());
        }
        answer.setText("0");
        if(((Button)view).getText().toString().equals("=")) {
            flag = true;
            if (op.get(j).equals("+")) {
                answer.setText(String.valueOf(num.get(i) + num.get(i+1)));
            } else if (op.get(j).equals("-")) {
                answer.setText(String.valueOf(num.get(i) - num.get(i+1)));
            } else if (op.get(j).equals("x")) {
                answer.setText(String.valueOf(num.get(i) * num.get(i+1)));
            } else if (op.get(j).equals("/")) {
                answer.setText(String.valueOf(num.get(i) / num.get(i+1)));
            }
            else answer.setText(String.valueOf(num.get(i)));
            num.clear();
            op.clear();
            i = 0;
            j = 0;
        }
    }
}


