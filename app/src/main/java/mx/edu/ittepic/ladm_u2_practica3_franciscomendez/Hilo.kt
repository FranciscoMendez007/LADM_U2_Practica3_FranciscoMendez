package mx.edu.ittepic.ladm_u2_practica3_franciscomendez

class Hilo (p:MainActivity) : Thread(){

    var estado = false
    var puntero = p
    var persona = clasePersona()
    var d1=0
    var d2=0
    var pausa = true

    override fun run() {
        super.run()
        estado = true
        while(estado){
            sleep(900)
            if(!pausa){
                d1=persona.tiros()
                d2=persona.tiros()
                puntero.runOnUiThread {
                    persona.etiqueta!!.setText (persona.nombre+ " esta tirando")
                }
                sleep(750)
                persona.puntos+=d1
                persona.puntos+=d2
                puntero.runOnUiThread {
                    puntero.puntaje()
                    persona.etiqueta!!.setText( persona.nombre+ " esperando turno")
                }
                pausar()
                when(persona.nombre){
                    "J1"->{
                        puntero.j2!!.despausar()
                    }
                    "J2"->{
                        puntero.j3!!.despausar()
                    }
                    "J3"->{
                        puntero.j4!!.despausar()
                    }
                    "J4"->{
                        puntero.turnos--
                        if(puntero.turnos!=0){
                            puntero.j1!!.despausar()
                        }
                        else{
                            puntero.runOnUiThread { puntero.resultado() }
                        }
                    }
                }
            }
        }
    }

    fun pausar() {
        pausa = true
        //Se requiere poner nuevamente en true para mandar llamar la funcion, y el metodo de por echo que lo esta, y que de lo contrario hace un bucle
    }
    fun despausar() {
        pausa = false
    }
}