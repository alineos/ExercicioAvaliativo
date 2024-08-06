package br.edu.ifsp.dmo.calculamedia.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.calculamedia.databinding.ActivityAritmeticaBinding
import br.edu.ifsp.dmo.calculamedia.model.Termo
import br.edu.ifsp.dmo.calculamedia.view.adapters.TermoAdapter
import br.edu.ifsp.dmo.calculamedia.view.listeners.TermoItemClickListener
import br.edu.ifsp.dmo.calculamedia.R
import br.edu.ifsp.dmo.calculamedia.databinding.TermoDialogAritimeticaBinding

class AritmeticaActivity: AppCompatActivity(), TermoItemClickListener {
    private lateinit var binding:ActivityAritmeticaBinding
    private val dataSource = ArrayList<Termo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAritmeticaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configListeners()
        configReciclerView()

    }

    private fun configListeners() {
        binding.buttonCalc.setOnClickListener{calculaMedia()}
        binding.buttonAdd.setOnClickListener{adicionaTermo()}

    }


    private fun configReciclerView() {
        val adapter = TermoAdapter(this,dataSource,this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }

    private fun calculaMedia() {
        if (dataSource.size > 0 ) {
            var result = 0.0

            dataSource.forEach { result += it.valor }

            result /= dataSource.size
            binding.labelResult.setText("Resultado: "+result)
        }


    }

    private fun adicionaTermo() {
        val tela = layoutInflater.inflate(R.layout.termo_dialog_aritimetica, null)
        val bindingDialog: TermoDialogAritimeticaBinding =TermoDialogAritimeticaBinding.bind(tela)
        // Configuração do AlertDialog
        val builder = AlertDialog.Builder(this)
            .setView(tela)
            .setTitle(R.string.new_term)
            .setPositiveButton(R.string.save,
                DialogInterface.OnClickListener { dialog, which ->
                    // Salvar um site é incluir um objeto na lista,
                    // e notificar o adapter que existe atualização.
                    dataSource.add(Termo(bindingDialog.edittextTerm.text.toString().toDouble(),0))
                    notifyAdapter()
                    dialog.dismiss()
                })
            .setNegativeButton(R.string.cancelar,
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
        val dialog = builder.create()
        dialog.show()
    }

    override fun clickTermoItem(position: Int) {

    }

    override fun clickDeletetTermoItem(position: Int) {
        dataSource.remove(dataSource[position])
        notifyAdapter()
    }

    private fun notifyAdapter() {
        val adapter = binding.recyclerView.adapter
        adapter?.notifyDataSetChanged()
    }

}