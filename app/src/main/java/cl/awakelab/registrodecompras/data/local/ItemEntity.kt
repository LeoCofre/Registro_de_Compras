package cl.awakelab.registrodecompras.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_item")
data class ItemEntity(val nombre: String, val precio:Int, val cantidad: Int){
    @PrimaryKey (autoGenerate = true) var id: Long = 0
}
