package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response

import com.google.gson.annotations.SerializedName

data class Bawaan (

    @SerializedName("error")
    var error:String?,

    @SerializedName("pesan")
    var pesan:String?

)