package com.bapercoding.bukuretro.network.response

import com.bapercoding.bukuretro.network.model.Buku
import com.google.gson.annotations.SerializedName

data class Data (

        @SerializedName("data")
    var data:ArrayList<Buku>?,

        @SerializedName("error")
    var error:String?


)