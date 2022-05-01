package com.example.practica2_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnC : Button
    lateinit var btnCE : Button
    lateinit var btnSigno : Button
    lateinit var btnDivision : Button
    lateinit var btnMultip : Button
    lateinit var btnResta : Button
    lateinit var btnSuma : Button
    lateinit var btnRes : Button
    lateinit var btnUno : Button
    lateinit var btnDos : Button
    lateinit var btnTres : Button
    lateinit var btnCuatro : Button
    lateinit var btnCinco : Button
    lateinit var btnSeis : Button
    lateinit var btnSiete : Button
    lateinit var btnOcho : Button
    lateinit var btnNueve : Button
    lateinit var btnCero : Button
    lateinit var btnPunto : Button
    lateinit var tvRes : TextView
    var negative : Boolean = false
    var operacion : MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnC = findViewById(R.id.btnC)
        btnCE = findViewById(R.id.btnCE)
        btnSigno = findViewById(R.id.btnSigno)
        btnDivision = findViewById(R.id.btnDivision)
        btnMultip = findViewById(R.id.btnMultip)
        btnResta = findViewById(R.id.btnResta)
        btnSuma = findViewById(R.id.btnSuma)
        btnRes = findViewById(R.id.btnRes)
        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
        btnCinco = findViewById(R.id.btnCinco)
        btnSeis = findViewById(R.id.btnSeis)
        btnSiete = findViewById(R.id.btnSiete)
        btnOcho = findViewById(R.id.btnOcho)
        btnNueve = findViewById(R.id.btnNueve)
        btnCero = findViewById(R.id.btnCero)
        btnPunto = findViewById(R.id.btnPunto)
        tvRes = findViewById(R.id.tvRes)

        btnUno.setOnClickListener { pressDigito(true, "1") }
        btnDos.setOnClickListener { pressDigito(true, "2") }
        btnTres.setOnClickListener { pressDigito(true, "3") }
        btnCuatro.setOnClickListener { pressDigito(true, "4") }
        btnCinco.setOnClickListener { pressDigito(true, "5") }
        btnSeis.setOnClickListener { pressDigito(true, "6") }
        btnSiete.setOnClickListener { pressDigito(true, "7") }
        btnOcho.setOnClickListener { pressDigito(true, "8") }
        btnNueve.setOnClickListener { pressDigito(true, "9") }
        btnCero.setOnClickListener { pressDigito(true, "0") }
        btnPunto.setOnClickListener { pressDigito(true, ".") }
        btnC.setOnClickListener { pressBtnC() }
        btnCE.setOnClickListener { pressBtnCE() }
        btnDivision.setOnClickListener { pressDigito(false, "/") }
        btnMultip.setOnClickListener { pressDigito(false, "*") }
        btnResta.setOnClickListener { pressDigito(false, "-") }
        btnSuma.setOnClickListener { pressDigito(false, "+") }
        btnRes.setOnClickListener { pressbtnRes() }
        btnSigno.setOnClickListener { pressBtnSigno() }

    }

    private fun pressDigito (op: Boolean, digito : String)
    {
        if(tvRes.text.toString().length > 30) {

        }
        else {
            when (op) {
                true -> {

                    //tvRes.text = "${tvRes.text}$digito"

                    if (!operacion.isEmpty()) {
                        //println(operacion.last())
                        if ("*".equals(operacion.last()) || operacion.last()
                                .equals("/") || operacion.last().equals("+") || operacion.last()
                                .equals("-")
                        ) {
                            if (negative) {

                                if(digito == "."){
                                    operacion.add("-0$digito")
                                    tvRes.text = "${tvRes.text}-0$digito"
                                    negative = !negative
                                }
                                else
                                {
                                    operacion.add("-$digito")
                                    tvRes.text = "${tvRes.text}-$digito"
                                    negative = !negative
                                }


                            } else {
                                if(digito == "."){
                                    operacion.add("0$digito")
                                    tvRes.text = "${tvRes.text}0$digito"
                                }
                                else{
                                    operacion.add(digito)
                                    tvRes.text = "${tvRes.text}$digito"
                                }

                            }

                        } else {

                            if(operacion.last().contains('.') && digito.equals(".")){

                            }else{
                                var n: Int = operacion.lastIndex
                                operacion[n] = "${operacion[n]}$digito"
                                tvRes.text = "${tvRes.text}$digito"
                            }

                        }
                    } else {
                        if (negative) {
                            if(digito == "."){
                                operacion.add("-0$digito")
                                tvRes.text = "${tvRes.text}-0$digito"
                                negative = !negative
                            }
                            else{
                                operacion.add("-$digito")
                                tvRes.text = "${tvRes.text}-$digito"
                                negative = !negative
                            }

                        } else {
                            if(digito == "."){
                                operacion.add("0$digito")
                                tvRes.text = "${tvRes.text}0$digito"
                            }else{
                                operacion.add(digito)
                                tvRes.text = "${tvRes.text}$digito"
                            }
                        }
                    }

                    //println(operacion)


                }
                false -> {
                    if (operacion.isNotEmpty()) {

                        if ("*".equals(operacion.last()) || operacion.last()
                                .equals("/") || operacion.last().equals("+") || operacion.last()
                                .equals("-")
                        ) {

                        } else {
                            if (operacion.last()[operacion.last().length - 1].equals('.')){
                                tvRes.text = "${tvRes.text}0$digito"
                                operacion[operacion.lastIndex] = "${operacion.last()}0"
                                operacion.add(digito)
                            }else{
                                tvRes.text = "${tvRes.text}$digito"
                                operacion.add(digito)
                            }

                            //println(operacion)
                        }
                    }
                }
            }
        }
    }

    private fun pressBtnC ()
    {
        tvRes.text = ""
        operacion.clear()
    }

    private fun pressBtnCE ()
    {

        if(operacion.isNotEmpty()) {

            if(operacion.last().length > 1)
            {
                operacion[operacion.lastIndex] = operacion.last().substring(0, operacion.last().length - 1)
            }
            else
            {
                operacion.removeAt(operacion.lastIndex)
            }
            //println(operacion)
            tvRes.text = tvRes.text.toString().substring(0, tvRes.text.toString().length - 1)

        }


    }

    private fun pressBtnSigno ()
    {

        if(!operacion.isEmpty())
        {
            //println(operacion.last())
            if("*".equals(operacion.last()) || operacion.last().equals("/") || operacion.last().equals("+") || operacion.last().equals("-"))
            {

                negative = !negative

            }
            else {

                var l: Char = operacion.last()[0]
                println("Primer Char: $l")
                var tv: String = "${
                    tvRes.text.toString()
                        .substring(0, tvRes.text.toString().length - operacion.last().length)
                }"
                println("Caracteres anteriores: $tv")

                //var sm : Char = '-'

                if (l.equals('-')) {

                    if (operacion.last().length == 2) {
                        operacion[operacion.lastIndex] = operacion.last()[1].toString()
                        println("Si es igual a -: ${operacion[operacion.lastIndex]}")
                        tvRes.text = "$tv${operacion[operacion.lastIndex]}"
                    }
                    else
                    {
                        operacion[operacion.lastIndex] = operacion.last().substring(1, operacion.last().length)
                        println("Si es igual a -: ${operacion[operacion.lastIndex]}")
                        tvRes.text = "$tv${operacion[operacion.lastIndex]}"
                    }

                }
                else{
                    operacion[operacion.lastIndex] = "-${operacion.last()}"
                    println("Si no es igual a -: ${operacion[operacion.lastIndex]}")
                    tvRes.text = "$tv${operacion[operacion.lastIndex]}"
                }
            }
        }else{
            negative = !negative
        }
    }

    private fun pressbtnRes ()
    {

        if(operacion.isNotEmpty()) {

            calcular()

            tvRes.text = "${operacion[0]}"

        }
    }

    private fun calcular ()
    {
        if(operacion.last()[operacion.last().length - 1].equals('.')){
            operacion[operacion.lastIndex] = "${operacion.last()}0"
        }

        if ("*".equals(operacion.last()) || operacion.last()
                .equals("/") || operacion.last().equals("+") || operacion.last()
                .equals("-")
        ){
            operacion.removeAt(operacion.lastIndex)
        }

        var i : Int = 0


        //Multiplicaciones
        var l : Int = operacion.count()
        while (i < l){
            if(operacion[i] == "*"){
                var n1 : Double = operacion[i-1].toDouble()
                //println(n1)
                var n2 : Double = operacion[i+1].toDouble()
                //println(n2)
                var r : Double = n1 * n2
                //println(r)
                operacion[i-1] = r.toString()
                operacion.removeAt(i+1)
                operacion.removeAt(i)
                l = operacion.count()
                --i
                //println(operacion)
            }

            i++
        }

        //Divisiones
        i = 0
        l = operacion.count()
        while (i < l){
            if(operacion[i] == "/"){
                var n1 : Double = operacion[i-1].toDouble()
                //println(n1)
                var n2 : Double = operacion[i+1].toDouble()
                //println(n2)
                var r : Double = n1 / n2
                //println(r)
                operacion[i-1] = r.toString()
                operacion.removeAt(i+1)
                operacion.removeAt(i)
                l = operacion.count()
                --i
                //println(operacion)
            }

            i++
        }

        //Sumas
        i = 0
        l = operacion.count()
        while (i < l){
            if(operacion[i] == "+"){
                var n1 : Double = operacion[i-1].toDouble()
                //println(n1)
                var n2 : Double = operacion[i+1].toDouble()
                //println(n2)
                var r : Double = n1 + n2
                //println(r)
                operacion[i-1] = r.toString()
                operacion.removeAt(i+1)
                operacion.removeAt(i)
                l = operacion.count()
                --i
                //println(operacion)
            }

            i++
        }

        //Restas
        i = 0
        l = operacion.count()
        while (i < l){
            if(operacion[i] == "-"){
                var n1 : Double = operacion[i-1].toDouble()
                //println(n1)
                var n2 : Double = operacion[i+1].toDouble()
                //println(n2)
                var r : Double = n1 - n2
                //println(r)
                operacion[i-1] = r.toString()
                operacion.removeAt(i+1)
                operacion.removeAt(i)
                l = operacion.count()
                --i
                //println(operacion)
            }

            i++
        }

    }

}