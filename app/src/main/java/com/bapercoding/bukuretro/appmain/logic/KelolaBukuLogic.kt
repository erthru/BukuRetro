package com.bapercoding.bukuretro.appmain.logic

import android.util.Log
import com.bapercoding.bukuretro.appmain.contract.KelolaBukuContract
import com.bapercoding.bukuretro.network.response.Bawaan
import com.bapercoding.bukuretro.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class KelolaBukuLogic(private val view:KelolaBukuContract.View) : KelolaBukuContract.Presenter {

    override fun tambah(judul: String?, penerbit: String?, tglterbit: String?) {

        view.tampilLoading()

        var call = ApiClient().getInstance().tambahBuku(judul,penerbit,tglterbit)
        call.enqueue(object : retrofit2.Callback<Bawaan>{


            override fun onFailure(call: Call<Bawaan>?, t: Throwable?) {
                Log.d("ONFAILURE",t.toString())
                view.dismissLoading()
                view.pesanError()
            }

            override fun onResponse(call: Call<Bawaan>?, response: Response<Bawaan>?) {

                if(response != null) {

                    if(response.isSuccessful){

                        view.dismissLoading()
                        view.pesan(response.body()?.pesan)

                    }

                }

            }


        })

    }

    override fun edit(id: String?, judul: String?, penerbit: String?, tglterbit: String?) {

        view.tampilLoading()

        var call = ApiClient().getInstance().editbuku(id,judul,penerbit,tglterbit)
        call.enqueue(object : retrofit2.Callback<Bawaan>{

            override fun onFailure(call: Call<Bawaan>?, t: Throwable?) {
                Log.d("ONFAILURE",t.toString())
                view.dismissLoading()
                view.pesanError()
            }

            override fun onResponse(call: Call<Bawaan>?, response: Response<Bawaan>?) {

                if(response != null) {

                    if(response.isSuccessful){

                        view.dismissLoading()
                        view.pesan(response.body()!!.pesan)

                    }

                }

            }

        })

    }

    override fun hapus(id: String?) {

        view.tampilLoading()

        var call = ApiClient().getInstance().hapusbuku(id)

        call.enqueue(object : retrofit2.Callback<Bawaan>{

            override fun onFailure(call: Call<Bawaan>?, t: Throwable?) {
                Log.d("ONFAILURE",t.toString())
                view.dismissLoading()
                view.pesanError()
            }

            override fun onResponse(call: Call<Bawaan>?, response: Response<Bawaan>?) {

                if(response != null) {

                    if(response.isSuccessful){

                        view.dismissLoading()
                        view.pesan(response.body()!!.pesan)

                    }

                }

            }

        })

    }

}