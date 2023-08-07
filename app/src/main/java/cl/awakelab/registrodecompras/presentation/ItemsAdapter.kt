package cl.awakelab.registrodecompras.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.registrodecompras.data.local.ItemClass
import cl.awakelab.registrodecompras.databinding.ItemLayoutBinding

class ItemsAdapter: RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private var items: List<ItemClass> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun setData(items: List<ItemClass>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemClass) {
            binding.tvItemName.text = item.name
            binding.tvItemPrice.text = item.price.toString()
            binding.tvItemQuantity.text = item.quantity.toString()
            binding.tvItemTotal.text = (item.price * item.quantity).toString()
        }
    }
}