package com.hero.rickandmortycatalog

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.hero.rickandmortycatalog.data.cache.RickAndMortyCache
import com.hero.rickandmortycatalog.data.networkRepository.RickAndMortyNetworkRepository
import com.hero.rickandmortycatalog.data.persistenRepository.getDatabase
import com.hero.rickandmortycatalog.mainScreen.MainScreenViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = getDatabase(this)
        val repository = RickAndMortyCache(RickAndMortyNetworkRepository(), database)
        val mainViewModel = ViewModelProviders.of(this, MainScreenViewModel.FACTORY(repository))
            .get(MainScreenViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
