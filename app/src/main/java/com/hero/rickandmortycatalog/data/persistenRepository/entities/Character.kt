package com.hero.rickandmortycatalog.data.persistenRepository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character constructor(@PrimaryKey val id: String = "", val name: String, val specie: String)