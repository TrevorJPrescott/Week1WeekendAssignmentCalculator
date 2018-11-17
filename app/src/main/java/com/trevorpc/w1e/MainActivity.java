package com.trevorpc.w1e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        numBtn(4);
//        numBtn(6);
//        numBtn(7);
//        decBtn();
//        numBtn(9);
//        numBtn(5);
//        opBtn("+");
//        numBtn(1);
//        numBtn(0);
//        numBtn(0);
//        opBtn("/");
//        numBtn(4);
//        numBtn(2);
//        answerBtn();
    }
    

    double numNow=0;
    double numThen=0;

    boolean decimal = false;

    String temp="nope";

    int decCount =1;
    double raise;

    public void numBtn(int input)
    {
        if (decimal)
        {
            raise =Math.pow(10,decCount);
            numNow=(numNow*raise+input)/(raise);
            decCount++;
            Log.d("decCount", "numBtn: "+decCount);
        }
        else
         {
            numNow = numNow * 10 + input;
         }
        Log.d("numNow", "numBtn: "+numNow);
    }
    public void decBtn()
    {
        decimal = true;
    }

    public void opBtn(String input)
    {
        if(!(temp.equals("nope")))
            answerBtn();
        decimal = false;
        decCount=1;
        numThen=numNow;
        numNow=0;
        Log.d("numThen", "OpBtn: "+numThen);
        temp=input;

    }
    public void additionMethod()
    {
        numThen=numNow+numThen;
        Log.d("numThen", "additionMethod: "+numThen);
    }
    public void subtractionMethod()
    {
        numThen=numThen-numNow;
        Log.d("numThen", "subtractionMethod: "+numThen);
    }
    public void divisionMethod()
    {
        numThen=numThen/numNow;
        Log.d("numThen", "divisionMethod: "+numThen);
    }
    public void multiplicationMethod()
    {
        numThen=numThen*numNow;
        Log.d("numThen", "multiplicationMethod: "+numThen);
    }
    public void clear()
    {
        opBtn("");
        numThen=0;

    }
    public void answerBtn()
    {
        switch(temp)
        {
            case("+"): additionMethod();
            case("-"): subtractionMethod();
            case("*"): multiplicationMethod();
            case("/"): divisionMethod();
        }
        Log.d("num", "answerBtn: The Answer is "+numThen);
        temp="nope";


    }
    // TODO create method to round Answer


}
