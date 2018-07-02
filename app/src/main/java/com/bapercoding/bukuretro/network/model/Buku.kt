package com.bapercoding.bukuretro.network.model

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