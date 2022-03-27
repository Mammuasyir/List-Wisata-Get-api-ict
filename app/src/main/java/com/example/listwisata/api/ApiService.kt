package com.example.listwisata.api

import com.example.listwisata.model.ResponseListWisata
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("wisata")
    fun getWisata() : Call<ResponseListWisata>

    @FormUrlEncoded
    @POST("add-wisata")
    fun addWisata(
        @Field("kategori_id") katWisata: Int,
        @Field("nama_wisata") nameWisata: String,
        @Field("harga") priceWisata: String,
        @Field("deskripsi") descWisata: String,
        @Field("kota") cityWisata: String,
        @Field("provinsi") provinceWisata: String,
        @Field("alamat") addressWisata: String,
        @Field("waktu_buka") openWisata: String,
        @Field("latitude") latWisata: String,
        @Field("longitude") longWisata: String,
        @Field("image") imgWisata: String,
    ): Call<ResponseListWisata>

    @FormUrlEncoded
    @POST("edit-wisata")
    fun editWisata(
        @Field("id") idWisata: String,
        @Field("kategori_id") katWisata: Int,
        @Field("nama_wisata") nameWisata: String,
        @Field("harga") priceWisata: String,
        @Field("deskripsi") descWisata: String,
        @Field("kota") cityWisata: String,
        @Field("provinsi") provinceWisata: String,
        @Field("alamat") addressWisata: String,
        @Field("waktu_buka") openWisata: String,
        @Field("latitude") latWisata: String,
        @Field("longitude") longWisata: String,
        @Field("image") imgWisata: String,
    ): Call<ResponseListWisata>
}