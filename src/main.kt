
class Tiempo(var horas: Int, var minutos: Int, var segundos: Int) {

    init {
        require(horas < 24)
        require(minutos < 60)
        require(segundos < 60)
    }

    constructor(horas: Int): this(horas, 0, 0)

    constructor(horas: Int, minutos: Int): this(horas, minutos, 0)

    companion object {
        val MAX_HORA: Int = 23
        val MAX_SEGUNDOS: Int = 86399
    }

    fun incrementarTiempo(t: Tiempo): Boolean {

        if (t.horas + horas > MAX_HORA) {
            println("No puedes llegar hasta el día siguiente")
            return false
        }

        val tiempoTotal = obtenerSegundos(t)

        if (tiempoTotal > MAX_SEGUNDOS) {
            println("No puedes sobrepasar las 23:59:59")
            return false
        }

        val tiempoActual = obtenerSegundosClase(horas, minutos, segundos)

        if (tiempoTotal + tiempoActual > MAX_SEGUNDOS) {
            println("No puedes sobrepasar las 23:59:59")
            return false
        }

        actualizarSegundos(tiempoTotal + tiempoActual)
        return true
    }

    fun obtenerSegundos(t: Tiempo): Int {
        return (t.horas * 3600) + (t.minutos * 60) + t.segundos
    }

    fun obtenerSegundosClase(h: Int, m: Int, s: Int): Int {
        return (h * 3600) + (m * 60) + s
    }

    fun actualizarSegundos(tiempoTotal: Int) {

        
    }

    override fun toString(): String {
        return "${horas}h ${minutos}m ${segundos}s"
    }

}

fun main() {
    val hora1 = Tiempo(0)
    val hora2 = Tiempo(0, 0)
    val hora3 = Tiempo(0,0,0)
}