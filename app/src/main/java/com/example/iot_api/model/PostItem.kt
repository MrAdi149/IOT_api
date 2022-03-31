package com.example.iot_api.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "postitem")
data class PostItem(
    val description: String,
    @PrimaryKey
    val id: Int,
    val image_link: String,
    val name: String,
    val price: String,
    val brand:String
)