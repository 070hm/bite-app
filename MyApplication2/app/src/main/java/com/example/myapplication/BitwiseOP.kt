package com.example.myapplication


import kotlin.math.pow

const val BASE_OCATAL_SYSTEM = 8;

class BitwiseOP {
    var octa = "00000000"
    var sum = 0;






    //change the Positions
    fun changeThePostion(p: Int, v: Int) {
        octa = octa.substring(0, p) + v + octa.substring(p + 1)

    }

    //function to check two number using XOR operator
    fun numberIsEqul(n1:String,n2:String):Boolean{
        if(n1==""){
            return false
        }
        else{
            return ((n1.toInt() xor n2.toInt())==0)
        }

    }



    //function convert String as  binary to number
    //return String
    fun convertToNumber(_binary: String): String {
        var double = 0.0;
        var binary = _binary.reversed();
        for (index in 0..BASE_OCATAL_SYSTEM - 1) {
            if (binary[index] == '1') {
                double += 1.0 * (2.0.pow(index))
            } else {

            }


        }
        return double.toInt().toString();
    }

    // function convert  number  to binary
    //return String
    fun convertToBinary(_x: Int): String {
        var number = _x;
        var result = ""

        for (index in 0..BASE_OCATAL_SYSTEM - 1) {
            val mask = 1 shl index
            if (number and mask != 0) {
                result += "1"
            } else {
                result += "0"
            }
        }
        return result.reversed()
    }
}



