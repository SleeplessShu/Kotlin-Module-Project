object ArchiveStorage {
    private var storage = mutableMapOf<String, MutableList<MutableList<String>>>()
    fun drawArchiveMap() {
        println("\n${TextDisplaying.archiveList}\n${TextDisplaying.createArchive}")
        InterfaceHandler.listDrawer(storage.keys.toList(), mutableListOf(), "Список архивов")
    }
    fun drawNotesMap(archiveName: String) {
        println(TextDisplaying.notesList)
        println(TextDisplaying.createNote)
        GlobalVariables.currentArchive = archiveName
        InterfaceHandler.listDrawer(listOf(), getArchive(archiveName) ?: mutableListOf(), "Список заметок")
    }
    fun drawNote(archiveName: String, num: Int) {
        val archive = storage[archiveName]
        InterfaceHandler.noteDrawer(archive?.getOrNull(num))
    }

    fun getStorage(): MutableMap<String, MutableList<MutableList<String>>> {
        return storage
    }
    fun getArchive(archiveName: String): MutableList<MutableList<String>>? {
        return storage[archiveName]
    }
    fun createArchive(archiveName: String) {
        if (!storage.containsKey(archiveName)) {
            storage[archiveName] = mutableListOf()
        } else {
            println("Архив '$archiveName' уже существует.")
        }
    }
    fun createNote(archiveName: String, noteName: String, description: String) {
        val archive = storage[archiveName]
        if (archive != null) {
            val note = mutableListOf(noteName, description)
            archive.add(note)
            println("Заметка '$noteName' добавлена в архив '$archiveName'.")
        } else {
            println("Архив '$archiveName' не найден.")
        }
    }
}