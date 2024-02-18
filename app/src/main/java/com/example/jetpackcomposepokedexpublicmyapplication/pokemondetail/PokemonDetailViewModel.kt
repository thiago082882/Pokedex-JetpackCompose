package com.example.jetpackcomposepokedexpublicmyapplication.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposepokedexpublicmyapplication.data.remote.responses.Pokemon
import com.example.jetpackcomposepokedexpublicmyapplication.repository.PokemonRepository
import com.example.jetpackcomposepokedexpublicmyapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonDetailViewModel  @Inject  constructor(
    private val repository: PokemonRepository
):ViewModel(){
    suspend fun  getPokemonInfo(pokemonName:String):Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }

}