package cl.awakelab.registrodecompras.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.registrodecompras.data.Repository
import cl.awakelab.registrodecompras.data.local.ItemDataBase
import cl.awakelab.registrodecompras.data.local.ItemClass
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<ItemClass>> = repository.getAllItems()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = ItemClass(name, price, quantity)
        repository.insertItem(item)
    }

}