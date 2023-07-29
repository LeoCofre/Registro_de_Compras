package cl.awakelab.registrodecompras.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.registrodecompras.data.ItemRepository
import cl.awakelab.registrodecompras.data.local.ItemDataBase
import cl.awakelab.registrodecompras.data.local.ItemEntity
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository

    init {
        val dao = ItemDataBase.getDatabase(application).getItems()
        repository = ItemRepository(dao)
    }

    fun getAllItems(): LiveData<List<ItemEntity>> = repository.getAllItems()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = ItemEntity(nombre, precio, cantidad)
        repository.insertItem(item)
    }
}