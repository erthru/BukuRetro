package com.bapercoding.bukuretro.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.bapercoding.bukuretro.AppMain.UI.KelolaBukuActivity
import com.bapercoding.bukuretro.AppMain.UI.MainActivity
import com.bapercoding.bukuretro.RetrofitConfig.RetrofitModel.Buku
import com.bapercoding.bukuretro.R
import com.bapercoding.bukuretro.Tools

class RVAdapterMain(list: ArrayList<Buku>?, mainActivity: MainActivity) : RecyclerView.Adapter<RVAdapterMain.Holder>(){

    var list = list
    var mainActivity = mainActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_main,parent,false)

        return Holder(view)

    }

    override fun getItemCount(): Int {
       return list!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.lbJudulList.text = "Judul : "+list!!.get(position).judul
        holder.lbPenerbitList.text = "Penerbit : "+list!!.get(position).penerbit
        holder.lbTglTerbitList.text = "Tgl Terbit : "+ Tools.AturTanggal(list!!.get(position).tglterbit)

        holder.contentMain.setOnClickListener({

            var i = Intent(mainActivity,KelolaBukuActivity::class.java)
            i.putExtra("mode","edit")
            i.putExtra("id",list!!.get(position).id)
            i.putExtra("judul",list!!.get(position).judul)
            i.putExtra("penerbit",list!!.get(position).penerbit)
            i.putExtra("tglterbit",list!!.get(position).tglterbit)
            mainActivity.startActivity(i)

        })

    }


    class Holder(view:View) : RecyclerView.ViewHolder(view){

        var lbJudulList:TextView = view.findViewById(R.id.lbJudulList)
        var lbPenerbitList:TextView = view.findViewById(R.id.lbPenerbitList)
        var lbTglTerbitList:TextView = view.findViewById(R.id.lbTglTerbitList)
        var contentMain:LinearLayout = view.findViewById(R.id.contentMain)

    }

}