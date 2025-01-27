class Tiempo(var horas: Int, var minutos: Int, var segundos: Int) {

    constructor(horas: Int): this(horas, 0, 0)

    constructor(horas: Int, minutos: Int): this(horas, minutos, 0)

    companion object {
        val MAX_HORA: Int = 23
        val MAX_SEGUNDOS: Int = 86399
    }

    init {
        require(horas < 24)
        require(minutos < 60)
        require(segundos < 60)
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

    fun comparar(t: Tiempo): Int {

        val tiempoTotal = obtenerSegundos(t)
        val tiempoActual = obtenerSegundos(horas, minutos, segundos)
        var resultado = -2

        if (tiempoActual == tiempoTotal) {
            resultado = 0
        }
        else if (tiempoActual < tiempoTotal) {
            resultado = -1
        }
        else if (tiempoActual > tiempoTotal) {
            resultado = 1
        }

        return resultado
    }

    fun copiar(): Tiempo {
        return Tiempo(this.horas, this.minutos, this.segundos)
    }

    fun copiar(t: Tiempo){
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

    fun esMayorQue(t: Tiempo): Boolean {
        if (obtenerSegundos(this) > obtenerSegundos(t)) return true else return false
    }

    fun esMenorQue(t: Tiempo): Boolean {
        if (obtenerSegundos(this) < obtenerSegundos(t)) return true else return false
    }

    fun obtenerSegundos(t: Tiempo): Int {
        return (t.horas * 3600) + (t.minutos * 60) + t.segundos
    }

    fun obtenerSegundos(h: Int, m: Int, s: Int): Int {
        return (h * 3600) + (m * 60) + s
    }


    override fun toString(): String {
        return "${horas}h ${minutos}m ${segundos}s"
    }

}