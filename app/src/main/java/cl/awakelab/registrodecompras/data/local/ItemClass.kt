package cl.awakelab.registrodecompras.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ItemClass(val name: String, val price: Int, val quantity: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}
