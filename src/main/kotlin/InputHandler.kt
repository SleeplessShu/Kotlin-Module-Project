object InputHandler {
    fun menuSelector(num: Int, keys: List<String>, type: String) {
        var usersChoice: Int
        var isNumberCorrect: Boolean = false
        while (!isNumberCorrect) {
            try {
                println()
                println(TextDisplaying.chooseYourAction)
                usersChoice = (readLine()!!.toInt())
                if (usersChoice < 0 || usersChoice > num) {
                    println(TextDisplaying.incorrectInputNum)
                } else {
                    isNumberCorrect = true
                    if (usersChoice == num) {
                        usersChoice = 9999
                    }
                    ChoiceHandler.menuChoiceHandler(usersChoice, keys, type)
                }
            } catch (e: NumberFormatException) {
                println(TextDisplaying.incorrectInputNaN)
            }
        }
    }
    fun nameInput(type: String, keys: List<String>): String {
        var name: String = ""
        var isNameCorrect: Boolean = false
        val messageStartCreation = "Создаём ${messageStringEnd(type, "start")}"
        while (!isNameCorrect) {

            val messageInputName = "Имя ${messageStringEnd(type, "name")}"
            println("\n${messageStartCreation}\n${TextDisplaying.zeroForExit}\n$messageInputName")
            name = readLine()!!
            if (name == "0") {
                if (type == "Список архивов") {
                    ChoiceHandler.menuChoiceHandler(9999, keys, "Создание архива")
                } else {
                    ChoiceHandler.menuChoiceHandler(9999, keys, "Создание заметки")
                }
            } else if (!name.isEmpty() && name !in keys) {
                isNameCorrect = true
            } else {
                println(TextDisplaying.incorrectInputName)
            }
        }
        return name
    }
    fun descriptionInput(): String {
        var message: String = ""
        println(TextDisplaying.noteDescription)
        println(TextDisplaying.zeroForExit)
        message = readLine().toString()
        if (message == "0") {
            ChoiceHandler.menuChoiceHandler(9999, mutableListOf(), "Заметка")
        } else if (message == ""){
            message = TextDisplaying.descriptionIsEmpty
        }
        return message
    }
    private fun messageStringEnd(type: String, ender: String): String {
        var message: String = if (type == "Список архивов") "архив" else "заметк"
        message += when {
            type == "Список архивов" && ender == "name" -> "а"
            type == "Список заметок" && ender == "name" -> "и"
            type == "Список заметок" && ender == "start" -> "у"
            else -> ""
        }
        return message
    }
}