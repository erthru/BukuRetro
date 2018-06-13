package com.bapercoding.bukuretro.RetrofitConfig.Response

import com.bapercoding.bukuretro.RetrofitConfig.Model.Buku
import com.google.gson.annotations.SerializedName

data class Data (

        @SerializedName("data")
    var data:ArrayList<Buku>?,

        @SerializedName("error")
    var error:String?


)