package com.bapercoding.bukuretro.appmain.contract

interface KelolaBukuContract {

    interface Presenter{

        fun tambah(judul:String?,penerbit:String?,tglterbit:String?)

        fun edit(id:String?,judul:String?,penerbit:String?,tglterbit:String?)

        fun hapus(id:String?)

    }


    interface View{

        fun pesanError()

        fun pesan(pesan:String?)

        fun tampilLoading()

        fun dismissLoading()

    }

}