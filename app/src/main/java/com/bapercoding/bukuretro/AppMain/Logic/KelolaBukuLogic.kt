package com.bapercoding.bukuretro.AppMain.Logic

import android.util.Log
import com.bapercoding.bukuretro.AppMain.Contract.KelolaBukuContract
import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Response.Bawaan
import com.bapercoding.bukuretro.RetrofitConfig.ApiClient
import retrofit2.Call
import retrofit2.Response

class KelolaBukuLogic(view:KelolaBukuContract.View) : KelolaBukuContract.Presenter {

    var view = view

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
                        view.pesan(response.body()!!.pesan)

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