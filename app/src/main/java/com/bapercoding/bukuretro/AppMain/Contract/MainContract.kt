package com.bapercoding.bukuretro.AppMain.Contract

import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Buku

interface MainContract {

    interface Presenter{

        fun muatData()

    }

    interface View{

        fun dataDimuat(list:ArrayList<Buku>?)

        fun pesanError()

        fun pesan(pesan:String?)

        fun tampilLoading()

        fun dismissLoading()

    }

}