package com.example.mobiledeveloplab3

class Calc {
    companion object{
        var firstNum: Double? = null
        var secondNum: Double? = null
        var mathOperation: String = ""

        fun calc(): Double?{
            var result: Double? = null

            if (firstNum!=null && secondNum!=null){
                when(mathOperation){
                    "+" -> result = firstNum!! + secondNum!!
                    "-" -> result = firstNum!! - secondNum!!
                    "*" -> result = firstNum!! * secondNum!!
                    "/" -> result = firstNum!! / secondNum!!
                }
            }
            return result
        }
    }
}