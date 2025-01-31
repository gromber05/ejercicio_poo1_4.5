fun main() {
    print("Introduce la hora del objeto principal: ")
    val hora = readln().toInt()

    print("Introduce los minutos: ")
    val minutoInput = readlnOrNull()?.takeIf { it.isNotEmpty() }?.toInt() ?: 0

    print("Introduce los segundos: ")
    val segundoInput = readlnOrNull()?.takeIf { it.isNotEmpty() }?.toInt() ?: 0

    val tiempoPrincipal = Tiempo(hora, minutoInput, segundoInput)

    print("Introduce la hora del objeto t: ")
    val horaT = readln().toInt()

    print("Introduce los minutos: ")
    val minutoTInput = readlnOrNull()?.takeIf { it.isNotEmpty() }?.toInt() ?: 0

    print("Introduce los segundo: ")
    val segundoTInput = readlnOrNull()?.takeIf { it.isNotEmpty() }?.toInt() ?: 0

    limpiarPantalla()


    val tiempoT = Tiempo(horaT, minutoTInput, segundoTInput)

    if (tiempoPrincipal.incrementarTiempo(tiempoT)) {
        println("Tiempo incrementado: $tiempoPrincipal")
    } else {
        println("Error: No se puede incrementar más allá de 23:59:59")
    }

    if (tiempoPrincipal.decrementarTiempo(tiempoT)) {
        println("Tiempo decrementado: $tiempoPrincipal")
    } else {
        println("Error: No se puede decrementar más allá de 00:00:00")
    }



    val comparacion = tiempoPrincipal.comparar(tiempoT)
    val resultadoComparacion = when (comparacion) {
        -1 -> "El tiempo principal es menor que t"
        0 -> "Ambos tiempos son iguales"
        1 -> "El tiempo principal es mayor que t"
        else -> "Error en la comparación"
    }
    println(resultadoComparacion)



    val copiaTiempo = tiempoPrincipal.copiar()
    println("Copia del tiempo principal: $copiaTiempo")

    tiempoPrincipal.copiar(tiempoT)
    println("Tiempo principal después de copiar t: $tiempoPrincipal")



    val sumaTiempo = tiempoPrincipal.sumarTiempo(tiempoT)
    if (sumaTiempo != null) {
        println("Suma de tiempos: $sumaTiempo")
    } else {
        println("Error: La suma pasa de las 23:59:59")
    }


    val restaTiempo = tiempoPrincipal.restarTiempo(tiempoT)
    if (restaTiempo != null) {
        println("Resta de tiempos: $restaTiempo")
    } else {
        println("Error: La resta es menor que 00:00:00")
    }


    if (tiempoPrincipal.esMayorQue(tiempoT)) {
        println("El tiempo principal es mayor que t")
    } else {
        println("El tiempo principal no es mayor que t")
    }

    if (tiempoPrincipal.esMenorQue(tiempoT)) {
        println("El tiempo principal es menor que t")
    } else {
        println("El tiempo principal no es menor que t")
    }
}

fun limpiarPantalla() {
    repeat(50){
        println("")
    }
}