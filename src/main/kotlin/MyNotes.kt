import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MyNotes:NoteInterface {
    private val gson = Gson()
    private val date = Date()
    private val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy  HH:mm:ss")

    private val file = File("notes.txt")

    private val scan = Scanner(System.`in`)

    override fun fileWriter(list: List<Notes>) {
        val fileWriter = FileWriter(file)

        gson.toJson(list, fileWriter)

        fileWriter.close()
    }

    override fun readFile(): ArrayList<Notes> {
        val list = ArrayList<Notes>()

        try {
            val inputStream = file.inputStream()
            val bufferedReader = inputStream.bufferedReader()
            val listString = bufferedReader.readLine()

            val type = object : TypeToken<ArrayList<Notes>>(){}.type
            list.addAll(gson.fromJson(listString, type))

        } catch (_: java.lang.Exception){}

        return list
    }
        override fun addNote() {
            println("Enter title of your note: ")
            val title = scan.next()

            println("Enter your note: ")
            val note = scan.next()

            val created_at = simpleDateFormat.format(date)

            val notes = Notes(title, note, created_at)

            val list = readFile()
            list.add(notes)

            fileWriter(list)

            println("Saved")
        }

        override fun showNote() {
            val list = readFile()

            for (notes in list) {
                println(notes)
            }
        }

        override fun search() {
            println("Enter title: ")
            val T = scan.next()

            val list = readFile()

            for (s in list) {
                if (T.equals(s.title)) {
                    println(s)
                }
            }
        }

        override fun delete() {
            val list = readFile()
            val fileWriter = FileWriter(file)

            var count = 0
            for ((i, s) in list.withIndex()) {
                println("$count) ${list[count]}")
                count++
            }
            println("Choose title to delete: ")
            val del = scan.nextInt()
            list.removeAt(del)
            println("Removed")

            fileWriter(list)
            fileWriter.close()
        }


}