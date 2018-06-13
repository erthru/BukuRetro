package com.bapercoding.bukuretro.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bapercoding.bukuretro.AppMain.UI.KelolaBukuActivity
import com.bapercoding.bukuretro.AppMain.UI.MainActivity
import com.bapercoding.bukuretro.RetrofitConfig.Model.Buku
import com.bapercoding.bukuretro.R
import com.bapercoding.bukuretro.Tools
import kotlinx.android.synthetic.main.list_main.view.*

class RVAdapterMain(private val list: ArrayList<Buku>?, private val mainActivity: MainActivity) : RecyclerView.Adapter<RVAdapterMain.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_main,parent,false))

    }

    override fun getItemCount(): Int = list!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.lbJudulList.text = "Judul : "+list!!.get(position).judul
        holder.view.lbPenerbitList.text = "Penerbit : "+list!!.get(position).penerbit
        holder.view.lbTglTerbitList.text = "Tgl Terbit : "+ Tools.AturTanggal(list!!.get(position).tglterbit)

        holder.view.contentMain.setOnClickListener({

            var i = Intent(mainActivity,KelolaBukuActivity::class.java)
            i.putExtra("mode","edit")
            i.putExtra("id",list!!.get(position).id)
            i.putExtra("judul",list!!.get(position).judul)
            i.putExtra("penerbit",list!!.get(position).penerbit)
            i.putExtra("tglterbit",list!!.get(position).tglterbit)
            mainActivity.startActivity(i)

        })

    }


    class Holder(val view:View) : RecyclerView.ViewHolder(view)
}