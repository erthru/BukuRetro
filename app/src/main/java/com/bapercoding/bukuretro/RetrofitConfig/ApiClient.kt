package com.bapercoding.bukuretro.RetrofitConfig

import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response.Bawaan
import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiClient {


    fun getRetrofit() : Retrofit{

        return Retrofit.Builder()
                .baseUrl("http://192.168.43.39/anows/buku/index.php/buku/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getInstance() : ApiInterface{

        return getRetrofit().create(ApiInterface::class.java)

    }

}

interface ApiInterface{

    @GET("semua")
    fun semuaBuku(): Call<Data>

    @FormUrlEncoded
    @POST("tambah")
    fun tambahBuku(

            @Field("judul") judul:String?,
            @Field("penerbit") penerbit:String?,
            @Field("tglterbit") tglterbit:String?

    ) : Call<Bawaan>


    @FormUrlEncoded
    @PUT("edit")
    fun editbuku(

            @Field("id") id:String?,
            @Field("judul") judul:String?,
            @Field("penerbit") penerbit:String?,
            @Field("tglterbit") tglterbit:String?

    ) : Call<Bawaan>

    @GET("hapus")
    fun hapusbuku(

            @Query("id")id:String?

    ) : Call<Bawaan>

}