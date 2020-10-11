package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


var bitwise = BitwiseOP();
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputNumbper = InputNumber;
        var frame = bgFream;
        var sw0:Switch = findViewById(R.id.switch0)
        var sw1:Switch = findViewById(R.id.switch1)
        var sw2:Switch = findViewById(R.id.switch2)
        var sw3:Switch = findViewById(R.id.switch3)
        var sw4:Switch = findViewById(R.id.switch4)
        var sw5:Switch = findViewById(R.id.switch5)
        var sw6 :Switch= findViewById(R.id.switch6)
        var sw7 :Switch= findViewById(R.id.switch7)
        var result:TextView = findViewById(R.id.Result);

        change(sw0,0);
        change(sw1,1);
        change(sw2,2);
        change(sw3,3);
        change(sw4,4);
        change(sw5,5);
        change(sw6,6);
        change(sw7,7);
        
        //function to check two number using XOR operator
        fun numberIsEqul(n1:String,n2:String):Boolean{
            if(n1==""){
                return false
            }
            else{
                return ((n1.toInt() xor n2.toInt())==0)
            }

        }


        //to handle the number input and check if match with the result of the bitwise result
        inputNumbper.addTextChangedListener(

            object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {

                    if(numberIsEqul(s.toString(), bitwise.sum.toString())){
                        frame.setBackgroundColor(Color.GREEN)
                    }
                    else{
                        frame.setBackgroundColor(Color.WHITE)
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    if(numberIsEqul(s.toString(), bitwise.sum.toString())){
                        frame.setBackgroundColor(Color.GREEN)
                    }
                    else{
                        frame.setBackgroundColor(Color.WHITE)
                    }
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(numberIsEqul(s.toString(), bitwise.sum.toString())){
                        frame.setBackgroundColor(Color.GREEN)
                    }
                    else{
                        frame.setBackgroundColor(Color.WHITE)
                    }
                }



        })








    }


fun change (sw:Switch,p:Int){
    var  result= Result;
    sw?.setOnCheckedChangeListener(){ it , isChecked ->
        if (isChecked){
             bitwise.changeThePostion(p,1)
           Toast.makeText(this, bitwise.octa,Toast.LENGTH_LONG).show()
              bitwise.sum=bitwise.convertToNumber(bitwise.octa.reversed()).toInt()
            result.text= bitwise.sum.toString();

            it.text="1"


        }
        else{
            bitwise.changeThePostion(p,0)
            bitwise.sum=bitwise.convertToNumber(bitwise.octa.reversed()).toInt()
            result.text= bitwise.sum.toString();

            it.text="0"
        }

    }

}




}
