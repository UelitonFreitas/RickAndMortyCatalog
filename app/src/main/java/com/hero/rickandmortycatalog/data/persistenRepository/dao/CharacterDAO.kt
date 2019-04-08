package com.hero.rickandmortycatalog.data.persistenRepository.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hero.rickandmortycatalog.data.persistenRepository.entities.Character

@Dao
interface CharacterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: Character)

    @Query("select * from Character")
    fun loadCharacters(): LiveData<List<Character>>
}