fun main(args: Array<String>) {

    var mainMunu = 0 //0 - archive, 1 - note, 2 - text note
    var arhives: MutableList<Storage> = mutableListOf() //тут архивы
    var activeList = arhives
    var prevMenu: MutableList<Storage> = mutableListOf()
    var activeStorage: Storage? = null//тут выбранная заметка

    while(true){

        var titleText = when(mainMunu){
            0 -> "Список архивов:"
            1 -> "Список заметок:"
            else -> ""
        }

        println(titleText)

        if (mainMunu == 2){
            println("0. Дополнить")
        }else{
            println("0. Создать")
            activeList.forEach {
                println("${activeList.indexOf(it) + 1}. ${it.name}")
            }
        }

        println("${activeList.size + 1}. Выход")

        var pp = readConsole(activeList)

        if (pp == activeList.size + 1){
            mainMunu--
            if (mainMunu < 0){
                break
            }

            if (mainMunu == 0){
                activeList = arhives
            }else if (mainMunu == 1){
                activeList = prevMenu
            }

        } else if (pp == 0){

                when(mainMunu) {
                   0 -> {
                       println("Введите название архива")
                       var userText = readConsoleName()
                       if (userText.length > 0){
                           activeList.add(Storage(TypeStorage.archive, userText))
                       }

                   }
                    1 -> {println("Введите название заметки")
                        var userName = readConsoleName()
                        if (userName.length > 0){

                            println("Введите текст заметки")
                            var userText = readConsoleName()
                            if (userText.length > 0){
                                activeList.add(Storage(TypeStorage.note, userName, userText))
                            }

                        }}
                    2 -> {println("Введите дополнительный текст")
                        var userText = readConsoleName()
                        if (userText.length > 0){
                            activeStorage!!.textNote  = activeStorage.textNote + "\n" + userText
                            println("Финальный текст: \n" + activeStorage.textNote)
                        }
                    }
                }

        }else if (pp == -1){
            //Ничего, ошибочный ввод
        }else{

            if(mainMunu < 2) {

                mainMunu++
                prevMenu = activeList
                activeList = activeList[pp - 1].dataList
            }
            if (mainMunu == 2){

                activeStorage = prevMenu[pp - 1]
                println("Заметка " + activeStorage.name + ": ")
                println(activeStorage.textNote)
            }

        }

    }

}



