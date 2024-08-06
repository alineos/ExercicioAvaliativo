package br.edu.ifsp.dmo.calculamedia.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo.calculamedia.R
import br.edu.ifsp.dmo.calculamedia.databinding.ActivityMainBinding
import android.content.Intent
import android.util.Log
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configSpinner()
        configurarListener()
    }

    private fun configurarListener() {
        binding.buttonCalc.setOnClickListener{calculaMedia()}
        binding.buttonHelp.setOnClickListener{pedeAjuda()}
    }

    private fun calculaMedia() {
        val tipMedia:Int = binding.spinnerMedias.selectedItemPosition

        //Log.e("teste","teste"+tipMedia)

        when(tipMedia){
            0-> mediaAritmetica()
            1-> mediaHarmonica()
            2-> mediaPonderada()
        }
    }

    private fun mediaHarmonica() {
        val mIntent = Intent(this,HarmonicaActivity::class.java)
        startActivity(mIntent)
    }

    private fun mediaPonderada() {
        val mIntent = Intent(this,PonderadaActivity::class.java)
        startActivity(mIntent)

    }

    private fun mediaAritmetica() {
        val mIntent = Intent(this,AritmeticaActivity::class.java)
        startActivity(mIntent)
    }

    private fun pedeAjuda() {
        val mIntent = Intent(this, AjudaActivity::class.java)
        startActivity(mIntent)
    }

    private fun configSpinner() {
        val adapter = ArrayAdapter<String>(
            this,android.R.layout.simple_spinner_dropdown_item,resources.getStringArray(R.array.medias)
        )
        binding.spinnerMedias.adapter= adapter
    }
}
