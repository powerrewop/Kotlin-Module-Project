

fun readConsole(listStorage: List<Storage>): Int{

    val scan = ConsoleScanner.getScanner()
    var userData = scan?.nextLine()
    return textIsAllow(userData, listStorage)

}

fun readConsoleName(): String{

    val scan = ConsoleScanner.getScanner()
    var userData = scan?.nextLine()
    if (userData!!.length == 0){
        println("Вы ввели пустую строку.")
    }
    return userData!!

}

fun textIsAllow(s: String?, listStorage: List<Storage>): Int{
    var correctText = true
    var ret = -1
    var digit = 0

    if (s.equals("")){
        correctText = false
        println("Вы ввели пустую строку.")
    }

    s?.forEach {
        if(!it.isDigit() and correctText){
            correctText = false
            println("Вы ввели символы, введите число.")
        }
    }

    if(correctText){
        digit = s?.toInt()!!
            if((digit < 0) or (digit > listStorage.size + 1)){
                correctText = false
                println("Вы ввели не корректное число.")
            }
        else{
            ret = digit
            }
    }

    return ret
}