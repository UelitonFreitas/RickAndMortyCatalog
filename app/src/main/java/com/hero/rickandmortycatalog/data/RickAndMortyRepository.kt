package com.hero.rickandmortycatalog.data

interface RickAndMortyRepository {
    fun loadCharacters(callback: CharactersCallback)
}

interface Callback<T>{
    fun onSuccess(data: T)
    fun onError(error: Exception)
}

class CharactersCallback : Callback<List<Character>> {
    override fun onSuccess(data: List<Character>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}