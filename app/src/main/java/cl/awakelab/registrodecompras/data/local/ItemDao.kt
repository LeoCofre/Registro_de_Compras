package cl.awakelab.registrodecompras.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    suspend fun insertItem(item: ItemEntity)

    @Query("SELECT * FROM table_item order by id ASC")
    fun getAllItems(): LiveData<List<ItemEntity>>
}