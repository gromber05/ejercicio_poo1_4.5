class Tiempo(var horas: Int, var minutos: Int = 0, var segundos: Int = 0) {

    companion object {
        const val MAX_HORA = 23
        const val MAX_SEGUNDOS = 86399
    }

    init {
        require(horas in 0..23) { "Las horas deben estar entre 0 y 23" }
        require(minutos in 0..59) { "Los minutos deben estar entre 0 y 59" }
        require(segundos in 0..59) { "Los segundos deben estar entre 0 y 59" }
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

        val tiempoActual = obtenerSegundos(horas, minutos, segundos)

        if (tiempoTotal + tiempoActual > MAX_SEGUNDOS) {
            println("No puedes sobrepasar las 23:59:59")
            return false
        }

        horas += t.horas
        minutos += t.minutos
        segundos += t.segundos

        println(this)
        return true
    }

    fun decrementarTiempo(t: Tiempo): Boolean {

        if ((horas - t.horas) < 0) {
            println("No puedes restar menos horas de las que hay")
            return false
        }

        val tiempoTotal = obtenerSegundos(t)
        val tiempoActual = obtenerSegundos(horas, minutos, segundos)

        if ((tiempoActual - tiempoTotal) < 0) {
            println("No puedes restar menos tiempo del que ya hay")
            return false
        }

        horas -= t.horas
        minutos -= t.minutos
        segundos -= t.segundos

        println(this)
        return true
    }

    fun comparar(t: Tiempo): Int = obtenerSegundos(this).compareTo(obtenerSegundos(t))

    fun copiar(): Tiempo = Tiempo(horas, minutos, segundos)

    fun copiar(t: Tiempo) {
        this.horas = t.horas
        this.minutos = t.minutos
        this.segundos = t.segundos
    }

    fun sumarTiempo(t: Tiempo): Tiempo? {
        if (obtenerSegundos(t) + obtenerSegundos(this) > MAX_SEGUNDOS) {
            return null
        } else {
            t.incrementarTiempo(this)
            return t
        }
    }

    fun restarTiempo(t: Tiempo): Tiempo? {
        if (obtenerSegundos(t) - obtenerSegundos(this) < 0) {
            return null
        } else {
            t.decrementarTiempo(this)
            return t
        }
    }

    fun esMayorQue(t: Tiempo): Boolean = obtenerSegundos(this) > obtenerSegundos(t)

    fun esMenorQue(t: Tiempo): Boolean = obtenerSegundos(this) < obtenerSegundos(t)

    private fun obtenerSegundos(t: Tiempo): Int {
        return (t.horas * 3600) + (t.minutos * 60) + t.segundos
    }

    private fun obtenerSegundos(h: Int, m: Int, s: Int): Int {
        return (h * 3600) + (m * 60) + s
    }



    override fun toString(): String = "%02d:%02d:%02d".format(horas, minutos, segundos)
}
