package com.example.homework1_dogatncr

//function for deciding whether the char is suitable for a username in Question 1.
fun isLetterNumUnder (char: Char): Boolean {
    return (char in 'a'..'z' || char in 'A'..'Z') || (char in '0'..'9') || (char == '_')
}
//Question 1 Solution
fun stringValidation (str: String):String {
    if (str.length in (4..25)) {
        if (str[0] in 'a'..'z' || str[0] in 'A'..'Z') {
            for (char in str){
                if (isLetterNumUnder(char)) {
                    if (str.last() != '_') {
                        return ("true")
                    }
                    else{
                        return("false")
                    }

                }
                else{
                    return("false")
                }

            }

        }
        else {
            return("false")

        }
    }
    else{
        return("false")

    }
    return "0"
}

//Question 2 Solution
fun aVeryBigSum (array: Array<Long>) : Long {
var sum : Long =0
for (element in array) {
    sum += element.toLong()
}
return sum
}

//Question 4 Solution
private fun firstFactorial(num: Int): Int {
    var factorial = 1
    for (x in 1..num) {
        factorial *= x
    }
    return factorial
}

//Question 5 Solution
private fun questionsMarks(str: String): String {
    var remaining = 2
    var sum = 0
    var questioncount = 0


    for (x in str) {
        if (x in '0'..'9'){
            if(remaining > 0){
                sum += x.digitToInt()
                remaining --
            }
        }
        else if(x == '?' && remaining !=2) {
            questioncount ++
        }
        else {
            //do nothing
        }


        if (remaining == 0 && sum == 10 && questioncount ==3){
            return "true"
        }
        else if (remaining == 0){
            remaining = 2
            sum = x.digitToInt()
            questioncount = 0
        }
    }
    return "false"

}





fun main (args: Array<String>) {
    //answer and test case(s) of question 1
    println("Enter the username that will be validated: ")
    val username = readLine()!!
    println(stringValidation(username))

    //answer and test case(s) of question 2
    println("Enter the length of your array: ")
    val arCount = readLine()!!.trim().toInt()
    println("Enter your array as space-separated integers: ")
    val ar = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
    val result = aVeryBigSum(ar)
    println("The sum of all array elements is $result.")

    //answer and test case(s) of question 4
    println("Enter a number to get the factorial of it: ")
    val f = readLine()!!
    println(firstFactorial(f.toInt()))

    //answer and test case(s) of question 5
    println("Enter the string that you'll check: ")
    val g = readLine()!!
    println(questionsMarks(g))
}

