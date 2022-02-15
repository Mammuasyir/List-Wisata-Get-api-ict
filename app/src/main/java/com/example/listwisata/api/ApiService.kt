package com.example.listwisata.api

import com.example.listwisata.model.ResponseListWisata
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("wisata")
    fun getWisata() : Call<ResponseListWisata>
}