package com.bapercoding.bukuretro.appmain.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.VISIBLE
import android.widget.Toast
import com.bapercoding.bukuretro.appmain.contract.KelolaBukuContract
import com.bapercoding.bukuretro.appmain.logic.KelolaBukuLogic
import com.bapercoding.bukuretro.R
import kotlinx.android.synthetic.main.activity_kelola_buku.*
import java.util.*

class KelolaBukuActivity : AppCompatActivity(), KelolaBukuContract.View {

    lateinit var loading:ProgressDialog

    lateinit var presenter:KelolaBukuContract.Presenter

    var i:Intent? = null

    lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_buku)

        supportActionBar!!.setTitle("Kelola Buku")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        loading = ProgressDialog(this)

        presenter = KelolaBukuLogic(this)

        i = intent

        if(i!!.hasExtra("mode")){
            if(i!!.getStringExtra("mode").equals("edit")){
                btnKelola.text = "Perbarui"
                txJudul.setText(i?.getStringExtra("judul"))
                txPenerbit.setText(i?.getStringExtra("penerbit"))
                txTglTerbit.setText(i?.getStringExtra("tglterbit"))
                id = i!!.getStringExtra("id")
                btnHapus.visibility = VISIBLE
            }
        }

        txTglTerbit.setOnClickListener {

            val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            val month = Calendar.getInstance().get(Calendar.MONTH)
            val year = Calendar.getInstance().get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->

                txTglTerbit.setText(year.toString()+"-"+(month+1).toString()+"-"+day.toString())

            },year,month,day)
            dpd.show()

        }

        btnKelola.setOnClickListener({

            if(i!!.hasExtra("mode")){
                if(i!!.getStringExtra("mode").equals("edit")){
                    presenter.edit(id,txJudul.text.toString(),txPenerbit.text.toString(),txTglTerbit.text.toString())
                }
            }else{
                presenter.tambah(txJudul.text.toString(),txPenerbit.text.toString(),txTglTerbit.text.toString())
            }

        })

        btnHapus.setOnClickListener({

            AlertDialog.Builder(this)
                    .setTitle("Konfirmasi")
                    .setMessage("Hapus data ini")
                    .setPositiveButton("IYA", DialogInterface.OnClickListener { dialogInterface, i ->

                        presenter.hapus(id)

                    })
                    .setNegativeButton("BATAL",DialogInterface.OnClickListener { dialogInterface, i ->

                        dialogInterface.dismiss()

                    })
                    .show()

        })

    }

    override fun pesanError() {
        Toast.makeText(applicationContext,"Koneksi error",Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){

            android.R.id.home ->{

                this.finish()

            }

        }

        return super.onOptionsItemSelected(item)
    }

    override fun pesan(pesan: String?) {
        if(pesan!!.contains("berhasil")) this.finish()
        Toast.makeText(applicationContext,pesan,Toast.LENGTH_SHORT).show()
    }

    override fun tampilLoading() {
        loading.setTitle("Proses")
        loading.setMessage("Mohon tunggu...")
        loading.show()
    }

    override fun dismissLoading() {
        loading.dismiss()
    }

}
