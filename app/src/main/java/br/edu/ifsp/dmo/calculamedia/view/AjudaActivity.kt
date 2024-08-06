package br.edu.ifsp.dmo.calculamedia.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.calculamedia.databinding.ActivityAjudaBinding
import br.edu.ifsp.dmo.calculamedia.R
class AjudaActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAjudaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjudaBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.imgAritimetica.setColorFilter(this.getColor(R.color.gray))
        binding.imgAritimetica.setOnClickListener{
            val mIntent = Intent(Intent.ACTION_VIEW)
            mIntent.setData(Uri.parse("https://www.youtube.com/watch?v=QS6sdNaIEo8"))
            startActivity(mIntent)
        }

        binding.imgHarmonica.setColorFilter(this.getColor(R.color.gray))
        binding.imgHarmonica.setOnClickListener{
                val mIntent = Intent(Intent.ACTION_VIEW)
                mIntent.setData(Uri.parse("https://www.youtube.com/watch?v=17AW2znpYmU"))
                startActivity(mIntent)
            }

        binding.imgPonderada.setColorFilter(this.getColor(R.color.gray))
        binding.imgPonderada.setOnClickListener{
            val mIntent = Intent(Intent.ACTION_VIEW)
            mIntent.setData(Uri.parse("https://www.youtube.com/watch?v=xkHf8L0eTgU"))
            startActivity(mIntent)
        }


    }
}