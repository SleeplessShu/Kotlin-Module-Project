import kotlin.system.exitProcess

object ChoiceHandler {
    fun menuChoiceHandler(num: Int, keys: List<String>, type: String) {
        if (num == 9999) {
            when (type) {
                "Создание архива" -> ArchiveStorage.drawArchiveMap()
                "Создание заметки" -> ArchiveStorage.drawNotesMap(GlobalVariables.currentArchive)
                "Список заметок" -> ArchiveStorage.drawArchiveMap()
                "Заметка" -> ArchiveStorage.drawNotesMap(GlobalVariables.currentArchive)
                "Список архивов" -> exitProgram()
            }
        } else if (num == 0 && type == "Список архивов") {
            ArchiveStorage.createArchive(InputHandler.nameInput(type, keys))
            ArchiveStorage.drawArchiveMap()
        } else if (num == 0 && type == "Список заметок") {
            ArchiveStorage.createNote( GlobalVariables.currentArchive,
                InputHandler.nameInput(type, keys),InputHandler.descriptionInput())
            ArchiveStorage.drawNotesMap(GlobalVariables.currentArchive)
        } else {
            when (type) {
                "Список архивов" -> ArchiveStorage.drawNotesMap(keys[num - 1])
                "Список заметок" -> ArchiveStorage.drawNote(GlobalVariables.currentArchive, num - 1)
            }
        }
    }
    fun exitProgram(){
        println(TextDisplaying.closeProgram)
        exitProcess(0)
    }
}