package cl.awakelab.registrodecompras.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.awakelab.registrodecompras.R
import cl.awakelab.registrodecompras.databinding.FragmentListBinding
import cl.awakelab.registrodecompras.presentation.ItemsViewModel
import cl.awakelab.registrodecompras.presentation.ItemsAdapter

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private val viewModel: ItemsViewModel by activityViewModels()

    private val adapter = ItemsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        initRecyclerView()
        loadData()
        initListener()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.listItems.adapter = adapter
    }

    private fun loadData() {
        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initListener() {
        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }
}