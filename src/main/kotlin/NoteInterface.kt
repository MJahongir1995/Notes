interface NoteInterface {
    fun fileWriter(list: List<Notes>)
    fun readFile():ArrayList<Notes>

    fun addNote()
    fun showNote()
    fun search()
    fun delete()
}