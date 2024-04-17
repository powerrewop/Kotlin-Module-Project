import java.util.Scanner

class Storage(
        val typeData: TypeStorage,
        val name: String,
        var textNote: String = "")
{

    var dataList: MutableList<Storage> = mutableListOf()

}

enum class TypeStorage(){
    archive,
    note
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