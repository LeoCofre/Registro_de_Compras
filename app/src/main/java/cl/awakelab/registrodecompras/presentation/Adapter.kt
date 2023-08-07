package cl.awakelab.registrodecompras.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.registrodecompras.data.local.ItemClass
import cl.awakelab.registrodecompras.databinding.ItemLayoutBinding



class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {


    private var items: List<ItemClass> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun getItemCount(): Int {
        return items.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemEntity = items[position]
        holder.bind(itemEntity)
    }

    fun setData(itemClass: List<ItemClass>) {
        this.items = itemClass
    }

    fun sumarTotal(): Int {
        var resultado = 0
        for (i: ItemClass in items) {
            resultado += (i.quantity * i.price)
        }
        return resultado
    }

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemClass: ItemClass) {
            binding.tvItemName.text = itemClass.name
            binding.tvItemPrice.text = " $" + itemClass.price.toString() + "c/u"
            binding.tvItemQuantity.text = "Cantidad " + itemClass.quantity.toString()
            val totalItem = itemClass.price * itemClass.quantity
            binding.tvItemTotal.text = "$ $totalItem"
        }
    }
}