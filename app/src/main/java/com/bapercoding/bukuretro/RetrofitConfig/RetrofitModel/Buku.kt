package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel

import com.google.gson.annotations.SerializedName

class Buku {

    @SerializedName("id")
    var id:String? = null

    @SerializedName("judul")
    var judul:String? = null

    @SerializedName("penerbit")
    var penerbit:String? = null

    @SerializedName("tglterbit")
    var tglterbit:String? = null

}