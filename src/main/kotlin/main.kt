import java.util.Scanner

fun main() {

    val myNotes = MyNotes()

    while (true){
        println("1-> Add Notes\n" +
                "2-> Show Notes\n" +
                "3-> Search\n" +
                "4-> Delete\n")

        when(Scanner(System.`in`).nextInt()){
            1-> myNotes.addNote()
            2-> myNotes.showNote()
            3-> myNotes.search()
            4-> myNotes.delete()
        }
    }
}