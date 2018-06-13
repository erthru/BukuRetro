package com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response

import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Model.Buku
import com.google.gson.annotations.SerializedName

data class Data (

    @SerializedName("data")
    var data:ArrayList<Buku>?,

    @SerializedName("error")
    var error:String?


)