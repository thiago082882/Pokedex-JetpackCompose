package com.example.jetpackcomposepokedexpublicmyapplication.repository

import com.example.jetpackcomposepokedexpublicmyapplication.data.remote.PokeApi
import com.example.jetpackcomposepokedexpublicmyapplication.data.remote.responses.Pokemon
import com.example.jetpackcomposepokedexpublicmyapplication.data.remote.responses.PokemonList
import com.example.jetpackcomposepokedexpublicmyapplication.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api :PokeApi
){
    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokemonList>{
       val response = try{
           api.getPokemonList(limit=limit, offset=offset)
       }catch (e:Exception){
         return  Resource.Error("an unknown error occurred")
       }
        return  Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName:String):Resource<Pokemon>{
        val response = try{
            api.getPokemonInfo(name=pokemonName)
        }catch (e:Exception){
            return  Resource.Error("an unknown error occurred")
        }
        return  Resource.Success(response)
    }
}