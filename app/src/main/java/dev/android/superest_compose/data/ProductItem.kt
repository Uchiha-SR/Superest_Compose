package dev.android.superest_compose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "product_table")
data class ProductItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val description: String,
    val image: Int,
    val unit: String,
    val price: Double,
    val nutritions: String,
    val review: Double,
    var isCart: Boolean = false
)