package cl.awakelab.registrodecompras.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelab.registrodecompras.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val itemVM: ItemsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = Adapter()
        itemVM.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
            binding.recyclerView.adapter = adapter
            binding.totalAPagarTxt.text = "$ " + adapter.sumarTotal().toString()
        }
    }
}