package mx.edu.ittepic.ladm_u2_practica3_franciscomendez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var j1: Hilo? = null
    var j2: Hilo? = null
    var j3: Hilo? = null
    var j4: Hilo? = null
    var turnos = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        j1 = Hilo(this)
        j2 = Hilo(this)
        j3 = Hilo(this)
        j4 = Hilo(this)

        j1!!.persona.etiqueta = Jugador1
        j2!!.persona.etiqueta = Jugador2
        j3!!.persona.etiqueta = Jugador3
        j4!!.persona.etiqueta = Jugador4

        j1!!.persona.nombre="J1"
        j2!!.persona.nombre="J2"
        j3!!.persona.nombre="J3"
        j4!!.persona.nombre="J4"

        j1!!.persona.etiqueta!!.setText("J1 esperando")
        j2!!.persona.etiqueta!!.setText("J2 esperando")
        j3!!.persona.etiqueta!!.setText("J3 esperando")
        j4!!.persona.etiqueta!!.setText("J4 esperando")

        comenzar.setOnClickListener {
            partida()
        }
    }

    fun partida() {
        puntaje()
        j1!!.start()
        j2!!.start()
        j3!!.start()
        j4!!.start()
        j1!!.despausar()
    }

    fun puntaje() {
        TiroJugador1.text = "" + j1!!.persona.puntos
        TiroJugador2.text = "" + j2!!.persona.puntos
        TiroJugador3.text = "" + j3!!.persona.puntos
        TiroJugador4.text = "" + j4!!.persona.puntos
    }

    fun resultado() {
        var ganador=""
        var empate=""
        var ju1 = j1!!.persona.puntos
        var ju2 = j2!!.persona.puntos
        var ju3 = j3!!.persona.puntos
        var ju4 = j4!!.persona.puntos

        if(ju1>ju2 && ju1>ju3 && ju1>ju4){
                    ganador="Jugador 1"
        }else if(ju2>ju1 && ju2>ju3 && ju2>ju4){
                    ganador="Jugador 2"
        }else if(ju3>ju1 && ju3>ju2 && ju3>ju4){
                    ganador="Jugador 3"
        }else if(ju4>ju1 && ju4>ju2 && ju4>ju3){
                    ganador="Jugador 4"
        }
        if (ju1==ju2 || ju1==ju3 || ju1==ju4){
            ganador=""
            empate="Jugador 1 empata"
        }
        if (ju2==ju1 || ju2==ju3 || ju2==ju4){
            ganador=""
            empate="Jugador 2 empata"
        }
        if (ju3==ju1 || ju3==ju2 || ju3==ju4){
            ganador=""
            empate="Jugador 3 empata"
        }
        if (ju4==ju1 || ju4==ju2 || ju4==ju3){
            ganador=""
            empate="Jugador 4 empata"
        }
        if (ganador!=""){
        dialogo(ganador+" gana")
        }else{
            dialogo(empate)
        }
    }

    fun dialogo(s: String) {
        AlertDialog.Builder(this).setTitle("ATENCION").setMessage(s)
            .setPositiveButton("OK") { d, i -> }
            .show()
    }
}

class clasePersona(){

    var etiqueta:TextView?=null
    var nombre = ""
    var puntos = 0

    fun tiros():Int{
        return (1..6).random()
    }
}


