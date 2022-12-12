package com.example.vocabulary20.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vocab_table")
data class Vocab(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val meaning: String

    )