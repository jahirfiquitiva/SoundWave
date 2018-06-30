package co.soundwave.extensions

fun ignore(print: Boolean = true, what: () -> Unit) {
    try {
        what()
    } catch (e: Exception) {
        if (print)
            e.printStackTrace()
    }
}