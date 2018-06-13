package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Model

import com.google.gson.annotations.SerializedName

data class Buku (

    @SerializedName("id")
    var id:String?,

    @SerializedName("judul")
    var judul:String?,

    @SerializedName("penerbit")
    var penerbit:String?,

    @SerializedName("tglterbit")
    var tglterbit:String?

)