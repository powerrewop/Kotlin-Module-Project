import java.util.Scanner

class Storage(
        val name: String,
        var textNote: String = "")
{

    var dataList: MutableList<Storage> = mutableListOf()

}

class ConsoleScanner private constructor(){
    companion object {
        private var scan: Scanner? = null
        fun getScanner(): Scanner? {
            if (scan == null) {
                scan = Scanner(System.`in`)
            }
            return scan
        }
    }
}