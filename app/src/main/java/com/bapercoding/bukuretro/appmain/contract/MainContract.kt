package com.bapercoding.bukuretro.appmain.contract

import com.bapercoding.bukuretro.network.model.Buku

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