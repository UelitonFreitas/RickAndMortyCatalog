package com.hero.rickandmortycatalog.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hero.rickandmortycatalog.data.RickAndMortyRepository

class MainScreenViewModel(private val repository: RickAndMortyRepository) : ViewModel() {
    companion object {
        val FACTORY = singleArgViewModelFactory(::MainScreenViewModel)
    }

    val characters = repository.characters
}


fun <T : androidx.lifecycle.ViewModel, A> singleArgViewModelFactory(constructor: (A) -> T): (A) -> ViewModelProvider.NewInstanceFactory {
    return { arg: A ->
        object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <V : androidx.lifecycle.ViewModel> create(modelClass: Class<V>): V {
                return constructor(arg) as V
            }
        }
    }
}