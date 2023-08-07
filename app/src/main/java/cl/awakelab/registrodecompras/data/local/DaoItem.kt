package cl.awakelab.registrodecompras.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoItem {

    @Insert
    suspend fun insertarItem(itemClass: ItemClass)

    @Query("SELECT * FROM item_table order by id ASC")
    fun showItem(): LiveData<List<ItemClass>>
}


