package com.joel.noteapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int ?= null,
    val title : String,
    val content : String,
//    val backgroundColor : BackGroundColor,
//    val tag : List<Tag>
)
