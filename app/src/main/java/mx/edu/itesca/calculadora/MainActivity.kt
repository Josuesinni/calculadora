package mx.edu.itesca.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCero: Button = findViewById(R.id.btnCero)
        val btnUno: Button = findViewById(R.id.btnUno)
        val btnDos: Button = findViewById(R.id.btnDos)
        val btnTres: Button = findViewById(R.id.btnTres)
        val btnCuatro: Button = findViewById(R.id.btnCuatro)
        val btnCinco: Button = findViewById(R.id.btnCinco)
        val btnSeis: Button = findViewById(R.id.btnSeis)
        val btnSiete: Button = findViewById(R.id.btnSiete)
        val btnOcho: Button = findViewById(R.id.btnOcho)
        val btnNueve: Button = findViewById(R.id.btnNueve)

        val btnSuma: Button = findViewById(R.id.btnSuma)
        val btnResta: Button = findViewById(R.id.btnResta)
        val btnMultiplicacion: Button = findViewById(R.id.btnMultiplicacion)
        val btnDivision: Button = findViewById(R.id.btnDivision)

        val btnResultado: Button = findViewById(R.id.btnResultado)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)

        val numero: TextView = findViewById(R.id.tvNumero)
        val operacion: TextView = findViewById(R.id.tvOperacion)

        var resultadoOperacion: Double = 0.0

        btnCero.setOnClickListener {
            validarEntrada(numero, "0")
        }
        btnUno.setOnClickListener {
            validarEntrada(numero, "1")
        }
        btnDos.setOnClickListener {
            validarEntrada(numero, "2")
        }
        btnTres.setOnClickListener {
            validarEntrada(numero, "3")
        }
        btnCuatro.setOnClickListener {
            validarEntrada(numero, "4")
        }
        btnCinco.setOnClickListener {
            validarEntrada(numero, "5")
        }
        btnSeis.setOnClickListener {
            validarEntrada(numero, "6")
        }
        btnSiete.setOnClickListener {
            validarEntrada(numero, "7")
        }
        btnOcho.setOnClickListener {
            validarEntrada(numero, "8")
        }
        btnNueve.setOnClickListener {
            validarEntrada(numero, "9")
        }

        var suma:Boolean=false
        var resta:Boolean=false
        var multiplicacion:Boolean=false
        var division:Boolean=false

        btnSuma.setOnClickListener {
            suma=true;
            resultadoOperacion=validarOperacion(operacion,numero,"+")
        }
        btnResta.setOnClickListener {
            resta=true;
            resultadoOperacion=validarOperacion(operacion,numero,"-")
        }
        btnMultiplicacion.setOnClickListener {
            multiplicacion=true;
            resultadoOperacion=validarOperacion(operacion,numero,"*")
        }
        btnDivision.setOnClickListener {
            division=true;
            resultadoOperacion=validarOperacion(operacion,numero,"/")
        }

        btnResultado.setOnClickListener {
            var resultado : Double = 0.0
            if(suma){
                resultado=resultadoOperacion+numero.text.toString().toDouble()
                suma=false;
            }else if(resta){
                resultado=resultadoOperacion-numero.text.toString().toDouble()
                resta=false;
            }else if(multiplicacion){
                resultado=resultadoOperacion*numero.text.toString().toDouble()
                multiplicacion=false;
            }else if (division){
                resultado=resultadoOperacion/numero.text.toString().toDouble()
                division=false;
            }
            operacion.setText(resultado.toString())
            numero.setText("0");
        }
        btnBorrar.setOnClickListener {
            operacion.setText("")
            numero.setText("0");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun validarEntrada(numero:TextView, valor: String){
        if (numero.text.toString().equals("0")){
            numero.setText(valor)
        }else{
            numero.setText(numero.text.toString()+valor)
        }
    }
    fun validarOperacion(operacion:TextView,numero:TextView,signo:String):Double{
        var resultadoOperacion=numero.text.toString().toDouble()
        operacion.setText(operacion.text.toString()+numero.text.toString()+signo)
        numero.setText("0");
        return resultadoOperacion;
    }
}