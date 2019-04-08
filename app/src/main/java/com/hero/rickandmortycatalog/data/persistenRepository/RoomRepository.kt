package com.hero.rickandmortycatalog.data.persistenRepository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hero.rickandmortycatalog.data.persistenRepository.dao.CharacterDAO
import com.hero.rickandmortycatalog.data.persistenRepository.entities.Character


@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDAO
}

private lateinit var INSTANCE: RickAndMortyDatabase

fun getDatabase(context: Context): RickAndMortyDatabase {
    synchronized(RickAndMortyDatabase::class) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                RickAndMortyDatabase::class.java,
                "rickAndMorty_db"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}