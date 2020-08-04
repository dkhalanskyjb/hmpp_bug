import kotlinx.datetime.*

expect fun f(): LocalDate

fun g() {
    // println(f().toNSDateComponents())
}