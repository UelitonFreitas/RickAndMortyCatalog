package com.hero.rickandmortycatalog.data.cache

import com.hero.rickandmortycatalog.data.CharactersCallback
import com.hero.rickandmortycatalog.data.RickAndMortyRepository


class RickAndMortyCache(
    private val networkRepository: RickAndMortyRepository,
    private val persistentRepository: RickAndMortyRepository
) : RickAndMortyRepository {

    override fun loadCharacters(callback: CharactersCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}