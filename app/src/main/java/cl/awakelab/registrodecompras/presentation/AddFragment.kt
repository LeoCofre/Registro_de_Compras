package cl.awakelab.registrodecompras.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.awakelab.registrodecompras.R
import cl.awakelab.registrodecompras.databinding.FragmentAddItemBinding
import cl.awakelab.registrodecompras.databinding.FragmentListBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding
    private val itemVM: ItemsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(inflater, container, false)

        initListener()
        return binding.root
    }

    private fun initListener() {

        binding.agregarB.setOnClickListener {
            val nombre = binding.nombreEdit.text.toString()
            val precio = binding.precioEdit.text.toString().toInt()
            val cantidad = binding.cantidadEdit.text.toString().toInt()

            saveTarea(nombre, precio, cantidad)

            val total = precio * cantidad
            binding.resultadoTxt.text = total.toString()
        }

        binding.listarItemB.setOnClickListener {
            findNavController().navigate(R.id.action_addItemFragment_to_listFragment)
        }

    }

    private fun saveTarea(nombre: String, precio: Int, cantidad: Int) {
        itemVM.insertItem(nombre, precio, cantidad)

    }
}



