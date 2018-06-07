package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response

import com.google.gson.annotations.SerializedName

class Bawaan {

    @SerializedName("error")
    var error:String? = null

    @SerializedName("pesan")
    var pesan:String? = null


    get() = field
    set(value){
        field = value
    }

}