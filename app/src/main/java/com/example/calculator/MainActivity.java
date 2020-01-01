package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button info;
    private Button refresh;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private TextView operation;
    private TextView result;

    private Button sum;
    private Button sub;
    private Button multi;
    private Button divi;

    private Button equal;

    private final char add ='+';
    private final char subs ='-';
    private final char multiplication ='*';
    private final char division ='/';
    private final char E =0;

    private double val1 = Double.NaN;
    private double val2 ;

    private char Action;

    private Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, about.class);
                startActivity(i);
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString()+"9");
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else if(operation.getText().length() ==0) {
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else {
                    computing();
                    Action = add;
                    result.setText(String.valueOf(val1)+"+");
                    operation.setText(null);}
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else if(operation.getText().length() ==0) {
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else{
                    computing();
                    Action = subs;
                    result.setText(String.valueOf(val1)+"-");
                    operation.setText(null);}
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else if(operation.getText().length() ==0) {
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else{
                    computing();
                    Action = multiplication;
                    result.setText(String.valueOf(val1)+"*");
                    operation.setText(null);}
            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else if(operation.getText().length() ==0) {
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else{
                    computing();
                    Action = division;
                    result.setText(String.valueOf(val1)+"/");
                    operation.setText(null);}
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                else if(operation.getText().length() ==0) {
                    Intent i = new Intent(MainActivity.this, Exception.class);
                    startActivity(i);
                }
                computing();
                Action= E;
                result.setText(result.getText().toString()+String.valueOf(val2)+ "=" +String.valueOf(val1) );
                // val1 with his operator and val2 stays here
                operation.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().length()==0 && result.getText().length()==0){
                    Intent i = new Intent(MainActivity.this, e.class);
                    startActivity(i);
                }
                else if(result.getText().length()==0 && operation.getText().length()>0){
                    CharSequence i = operation.getText().toString();
                    operation.setText(i.subSequence(0, i.length()-1));
                }
                else if(operation.getText().length()==0 && result.getText().length()>0){
                    CharSequence i = result.getText().toString();
                    result.setText(i.subSequence(0, i.length()-1));
                }

            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Double.NaN;
                val2=Double.NaN;
                operation.setText(null);
                result.setText(null);
            }
        });

    }
    private void setupUIViews(){
        refresh=(Button)findViewById(R.id.btnall);
        info=(Button)findViewById(R.id.btninfo);

        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        zero=(Button)findViewById(R.id.btn10);

        operation=(TextView)findViewById(R.id.textview);
        result=(TextView)findViewById(R.id.textview1);

        sum=(Button)findViewById(R.id.btn13);
        sub=(Button)findViewById(R.id.btn14);
        multi=(Button)findViewById(R.id.btn15);
        divi=(Button)findViewById(R.id.btn16);

        equal=(Button)findViewById(R.id.btn17);
        clear=(Button)findViewById(R.id.btnclear);
    }

    private void computing() {
        if (!Double.isNaN(val1)) {
            val2=Double.parseDouble(operation.getText().toString());
            switch (Action){
                case add:
                    val1 =val1+val2;
                    break;
                case subs:
                    val1 =val1-val2;
                    break;
                case multiplication:
                    val1 =val1*val2;
                    break;
                case division:
                    val1 =val1/val2;
                    break;
                case E:
                    break;
            }
        }

        else{
            val1=Double.parseDouble(operation.getText().toString());

        }
    }
}
