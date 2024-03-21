object InterfaceHandler {
    fun listDrawer(archives: List<String>, notes: List<List<String>>, type: String) {
        var numOfOptions: Int = 1
        var keys: MutableList<String> = mutableListOf()
        if (archives.isNotEmpty() || notes.isNotEmpty()) {
            val allItems = archives + notes.map { it[0] }
            keys.addAll(allItems)
            for (i in allItems.indices) {
                println("${i + 1} - ${allItems[i]}")
            }
            print("${allItems.size + 1} - ")
            numOfOptions += allItems.size
        } else {
            println(if (type == "Список архивов") TextDisplaying.archiveListIsEmpty else
                TextDisplaying.noteListIsEmpty)
            print("1 - ")
        }
        println("Выход")
        InputHandler.menuSelector(numOfOptions, keys, type)
    }
    fun noteDrawer(note: List<String>? ) {
        if (note != null) {
            println(TextDisplaying.openNote)
            for (line in note) {
                println(line)
            }
        } else {
            println(TextDisplaying.note404)
        }
        println(TextDisplaying.zeroForExit)
        InputHandler.menuSelector(0, mutableListOf(),"Заметка")
    }
}