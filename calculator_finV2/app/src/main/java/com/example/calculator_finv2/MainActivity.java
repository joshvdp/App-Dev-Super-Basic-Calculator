package com.example.calculator_finv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //DELA PEÑA, JOSHUA VER S. 3BSEMC-GD
    private TextView Screen;
    private String input = "", Answer;
    private boolean clearResult;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        Toast.makeText(this, "Basic Calculator By Joshua Dela Peña", Toast.LENGTH_LONG).show();
    }
    //DELA PEÑA, JOSHUA VER S. 3BSEMC-GD
    public void onClickButton(View pressed)
    {
        Button btn = (Button) pressed;
        String data = btn.getText().toString();
        switch (data)
        {
            case "AC":
                input="";
                break;
            case "Mem":
                clearResult=false;
                input+=Answer;
                break;
            case "X":
                clearResult=false;
                Solve();
                input+="*";
                break;
            case "^":
                clearResult=false;
                Solve();
                input+="^";
                break;
            case "=":
                clearResult=true;
                Solve();
                Answer=input;
                break;
            case "C":
                if(input.length()>0)
                {
                    clearResult=false;
                    String newText=input.substring(0,input.length()-1);
                    input=newText;
                }
                break;
            default:
                if(input==null)
                {
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/"))
                {
                    clearResult=false;
                    Solve();
                }
                else if(clearResult==true)
                {
                    input="";
                    clearResult=false;
                }
                input+=data;
        }
        Screen.setText(input);
    }
    public void Solve(){
        if(input.split("\\*").length==2)
        {
            String numbers[]=input.split("\\*");
            try
            {
                double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                input=mul+"";
            }
            catch (Exception e)
            {

            }
        }
        else if(input.split("/").length==2)
        {
            String numbers[]=input.split("/");
            try
            {
                double div=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                input=div+"";
            }
            catch (Exception e)
            {

            }
        }
        else if(input.split("\\^").length==2)
        {
            String numbers[]=input.split("\\^");
            try
            {
                double pow=Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
                input=pow+"";
            }
            catch (Exception e)
            {

            }
        }
        else if(input.split("\\+").length==2)
        {
            String numbers[]=input.split("\\+");
            try
            {
                double sum=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                input=sum+"";
            }
            catch (Exception e)
            {

            }
        }
        else if(input.split("\\-").length>1)
        {
            String numbers[]=input.split("\\-");
            if(numbers[0]=="" && numbers.length==2)
            {
                numbers[0]=0+"";
            }
            try
            {
                double sub=0;
                if(numbers.length==2)
                {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                }
                else if(numbers.length==3)
                {
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input=sub+"";
            }
            catch (Exception e)
            {

            }
        }
        String n[]=input.split("\\.");
        if(n.length>1)
        {
            if(n[1].equals("0"))
            {
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}
