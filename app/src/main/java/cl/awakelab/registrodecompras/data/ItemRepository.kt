package cl.awakelab.registrodecompras.data


import androidx.lifecycle.LiveData
import cl.awakelab.registrodecompras.data.local.ItemDao
import cl.awakelab.registrodecompras.data.local.ItemEntity


class ItemRepository(private val itemDao: ItemDao) {

    suspend fun insertItem(item: ItemEntity) {
        itemDao.insertItem(item)

    }

    fun getItem(): LiveData<List<ItemEntity>> {
        return itemDao.getAllItems()
    }
}