package com.example.vocabulary20.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Vocab::class], version = 1 )
abstract class VocabDatabase : RoomDatabase() {

    abstract fun VocabDao () : VocabDao

    companion object{

        @Volatile
        private var INSTANCE : VocabDatabase ?= null

        fun getInstance(context: Context): VocabDatabase{

            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VocabDatabase::class.java,
                    "vocab"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}