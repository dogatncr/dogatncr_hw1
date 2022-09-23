package com.example.homework1_dogatncr

/*      Implemented by Doga Tuncer
 */

//function for deciding whether the char is suitable for a username in Question 1.
fun isLetterNumUnder (char: Char): Boolean {
    return (char in 'a'..'z' || char in 'A'..'Z') || (char in '0'..'9') || (char == '_')
}
//Question 1 Solution
fun stringValidation (str: String):String {
    if (str.length in (4..25)) {//length control
        if (str[0] in 'a'..'z' || str[0] in 'A'..'Z') {//starting letter control
            for (char in str){//iteration over string
                if (isLetterNumUnder(char)) {//util function that we mentioned above
                    if (str.last() != '_') {//last char control
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
var sum : Long =0 //parameter and sum variable defined as long type to prevent out of memory error.
for (element in array) {
    sum += element
}
return sum
}

//Question 4 Solution
private fun firstFactorial(num: Int): Int {
    var factorial = 1
    for (x in 1..num) { //iteration 'till our parameter.
        factorial *= x
    }
    return factorial
}

//Question 5 Solution
private fun questionsMarks(str: String): String {
    var remaining = 2 //for checking whether the sum includes both numbers
    var sum = 0 // will update for every number found
    var questioncount = 0 //for counting questionMarks


    for (x in str) {
        if (x in '0'..'9'){ //condition for chars that can convert to integer.
            if(remaining > 0){
                sum += x.digitToInt()
                remaining --
            }
        }
        else if(x == '?' && remaining !=2) { //condition for question marks.
            questioncount ++
        }
        else {
            //do nothing because we don't need to process other chars.
        }


        if (remaining == 0 && sum == 10 && questioncount ==3){ //check whether the expected conditions are met.
            return "true"
        }
        else if (remaining == 0){ //if expected conditions are not met and there is no remaining sum left, start iteration from the last sum element.
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

