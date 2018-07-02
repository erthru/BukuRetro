package com.bapercoding.bukuretro.appmain.logic

import android.util.Log
import com.bapercoding.bukuretro.appmain.contract.MainContract
import com.bapercoding.bukuretro.network.response.Data
import com.bapercoding.bukuretro.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainLogic(private val view:MainContract.View) : MainContract.Presenter {

    override fun muatData(){

        view.tampilLoading()

        var call = ApiClient().getInstance().semuaBuku()
        call.enqueue(object : retrofit2.Callback<Data>{

            override fun onFailure(call: Call<Data>?, t: Throwable?) {
                Log.d("ONFAILURE",t.toString())
                view.dismissLoading()
                view.pesanError()
            }

            override fun onResponse(call: Call<Data>?, response: Response<Data>?) {
                if(response != null){

                    if(response.isSuccessful){

                        var data = response.body()?.data

                        view.dataDimuat(data)
                        view.dismissLoading()

                    }else{

                        view.pesan("data gagal dimuat")
                        view.dismissLoading()

                    }

                }
            }


        })

    }

}