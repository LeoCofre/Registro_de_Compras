package cl.awakelab.registrodecompras.data

import androidx.lifecycle.LiveData
import cl.awakelab.registrodecompras.data.local.ItemClass
import cl.awakelab.registrodecompras.data.local.DaoItem

class Repository(private val itemDao: DaoItem) {


    suspend fun insertItem(item: ItemClass) {
        itemDao.insertarItem(item)

    }

    fun getAllItems(): LiveData<List<ItemClass>> {
        return itemDao.showItem()
    }


}