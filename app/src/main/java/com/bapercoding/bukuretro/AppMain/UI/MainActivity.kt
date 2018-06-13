package com.bapercoding.bukuretro.AppMain.UI

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.bapercoding.bukuretro.Adapter.RVAdapterMain
import com.bapercoding.bukuretro.AppMain.Contract.MainContract
import com.bapercoding.bukuretro.AppMain.Logic.MainLogic
import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Buku
import com.bapercoding.bukuretro.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration



class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var layoutManager:LinearLayoutManager

    lateinit var rvAdapterMain:RVAdapterMain

    lateinit var presenter:MainContract.Presenter

    lateinit var loading:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("Data Buku")

        presenter = MainLogic(this)

        layoutManager = LinearLayoutManager(this)

        rvMain.layoutManager = layoutManager
        rvMain.setHasFixedSize(true)
        rvMain.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        loading = ProgressDialog(this)

        fabTambah.setOnClickListener {

            startActivity(Intent(applicationContext,KelolaBukuActivity::class.java))

        }

    }

    override fun onResume() {
        super.onResume()
        presenter!!.muatData()
    }

    override fun dataDimuat(list:ArrayList<Buku>?) {
        rvAdapterMain = RVAdapterMain(list,this)
        rvAdapterMain!!.notifyDataSetChanged()
        rvMain.adapter = rvAdapterMain
    }

    override fun pesanError() {
        Toast.makeText(applicationContext,"Koneksi gagal",Toast.LENGTH_SHORT).show()
    }

    override fun pesan(pesan: String?) {
        Toast.makeText(applicationContext,pesan,Toast.LENGTH_SHORT).show()
    }

    override fun tampilLoading() {
        loading!!.setTitle("Proses")
        loading!!.setMessage("Mengambil data...")
        loading!!.show()
    }

    override fun dismissLoading() {
        loading!!.dismiss()
    }

}
