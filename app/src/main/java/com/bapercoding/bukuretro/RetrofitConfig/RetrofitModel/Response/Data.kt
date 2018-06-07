package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response

import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Buku
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("data")
    var data:ArrayList<Buku>? = null

    @SerializedName("error")
    var error:String? = null

    get() = field
    set(value){
        field = value
    }

}