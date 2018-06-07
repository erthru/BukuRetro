package com.bapercoding.bukuretro

import android.util.Log

class Tools {

    companion object {

        fun AturTanggal(tgl:String?) : String{

            var bulan = HashMap<String,String>()
            bulan.put("01","Januari")
            bulan.put("02","Februari")
            bulan.put("03","Maret")
            bulan.put("04","April")
            bulan.put("05","Mei")
            bulan.put("06","Juni")
            bulan.put("07","Juli")
            bulan.put("08","Agustus")
            bulan.put("09","September")
            bulan.put("10","Oktober")
            bulan.put("11","November")
            bulan.put("12","Desember")

            return tgl!!.substring(8,10)+" "+bulan.get(tgl!!.substring(5,7))+" "+tgl!!.substring(0,4)

        }

    }

}