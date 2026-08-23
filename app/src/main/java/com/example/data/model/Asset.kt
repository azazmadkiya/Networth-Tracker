package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room database entity class 'Asset' to store asset type, name, category (self, father, mother), and value.
 */
@Entity(tableName = "assets")
data class Asset(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: String,
    val category: String, // self, father, mother
    val value: Double
)
