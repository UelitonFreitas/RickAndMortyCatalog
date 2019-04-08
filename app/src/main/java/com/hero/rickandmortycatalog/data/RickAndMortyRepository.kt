package com.hero.rickandmortycatalog.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hero.rickandmortycatalog.data.networkRepository.RickAndMortyNetworkRepository
import com.hero.rickandmortycatalog.data.persistenRepository.dao.CharacterDAO

class RickAndMortyRepository(
    private val networkRepository: RickAndMortyNetworkRepository,
    private val characterDAO: CharacterDAO
) {

    val characters: LiveData<List<Character>> by lazy(LazyThreadSafetyMode.NONE) {
        Transformations.map(characterDAO.loadCharacters()) { list ->
            list.map { Character(it.id, it.name, it.specie) }
        }
    }
}

interface Callback<T> {
    fun onSuccess(data: T)
    fun onError(error: Exception)
}

class SuccessCallback<T>(val data: T) : CallbackResult<T>()
class ErrorCallback<T>(val error: Throwable) : CallbackResult<T>()

sealed class CallbackResult<T>

class FutureCallback<T> {

    private var result: CallbackResult<T>? = null
    private val listeners = mutableListOf<ResultListener<T>>()

    fun addListener(listener: ResultListener<T>) {
        listeners.add(listener)
    }

    fun onSuccess(data: T) {
        result = SuccessCallback(data)
        sendResultToAllListeners()
    }

    fun onError(e: Throwable) {
        result = ErrorCallback(e)
        sendResultToAllListeners()
    }

    private fun sendResultToAllListeners() {
        result?.let { result ->
            listeners.forEach { it(result) }
        }
    }
}

typealias ResultListener<T> = (CallbackResult<T>) -> Unit

class CharactersCallback : Callback<List<Character>> {
    override fun onSuccess(data: List<Character>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}