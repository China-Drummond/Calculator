package com.example.drummond.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.*;
import android.view.*;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnClr;
    private Button btnResult;
    private TextView textShow;
    private List<Item> items = new ArrayList<Item>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnClr = (Button) findViewById(R.id.btnClear);
        btnResult = (Button) findViewById(R.id.btnResult);
        textShow = (TextView) findViewById(R.id.textShow);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClr.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn0:
                textShow.append("0");
                break;
            case R.id.btn1:
                textShow.append("1");
                break;
            case R.id.btn2:
                textShow.append("2");
                break;
            case R.id.btn3:
                textShow.append("3");
                break;
            case R.id.btn4:
                textShow.append("4");
                break;
            case R.id.btn5:
                textShow.append("5");
                break;
            case R.id.btn6:
                textShow.append("6");
                break;
            case R.id.btn7:
                textShow.append("7");
                break;
            case R.id.btn8:
                textShow.append("8");
                break;
            case R.id.btn9:
                textShow.append("9");
                break;
            case R.id.btnAdd:
                items.add(new Item(Double.parseDouble(textShow.getText().toString()), Types.NUM));
                checkAndResult();
                items.add(new Item(0, Types.ADD));
                textShow.setText("");
                break;
            case R.id.btnSub:
                items.add(new Item(Double.parseDouble(textShow.getText().toString()), Types.NUM));
                checkAndResult();
                items.add(new Item(0, Types.SUB));
                textShow.setText("");
                break;
            case R.id.btnMul:
                items.add(new Item(Double.parseDouble(textShow.getText().toString()), Types.NUM));
                checkAndResult();
                items.add(new Item(0, Types.MUL));
                textShow.setText("");
                break;
            case R.id.btnDiv:
                items.add(new Item(Double.parseDouble(textShow.getText().toString()), Types.NUM));
                checkAndResult();
                items.add(new Item(0, Types.DIV));
                textShow.setText("");
                break;
            case R.id.btnClear:
                textShow.setText("");
                items.clear();
                break;
            case R.id.btnResult:
                items.add(new Item(Double.parseDouble(textShow.getText().toString()), Types.NUM));
                checkAndResult();
                textShow.setText(Double.toString(items.get(0).m_value));
                items.clear();
                break;
        }
    }

    public void checkAndResult(){
        if (items.size() >= 3){

            double num1 = items.get(0).m_value;
            double num2 = items.get(2).m_value;
            int opt = items.get(1).m_type;
            items.clear();

            switch (opt){
                case 2:
                    items.add(new Item(num1+num2,Types.NUM));
                    break;
                case 3:
                    items.add(new Item(num1-num2,Types.NUM));
                    break;
                case 4:
                    items.add(new Item(num1*num2,Types.NUM));
                    break;
                case 5:
                    items.add(new Item(num1/num2,Types.NUM));
                    break;
            }
        }
    }
}

