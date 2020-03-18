package com.example.sharedpreferencemahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.json.JSONArray

class AddData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        back.setOnClickListener{
            startActivity(Intent(this@AddData,dashboard::class.java))
            finish()
        }

        btnTambah.setOnClickListener {

            var data_nama = edtNama.text.toString()
            var data_nomor = edtNomor.text.toString()
            var data_alamat = edtAlamat.text.toString()

            postkeserver(data_nama, data_nomor, data_alamat)

            startActivity(Intent(this@AddData,dashboard::class.java))
            finish()
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String){

        AndroidNetworking.post("http://192.168.0.7/shared/add.php")
            .addBodyParameter("nama_mahasiswa", data1)
            .addBodyParameter("nomor_mahasiswa", data2)
            .addBodyParameter("alamat_mahasiswa", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
//                  do anything with response
                }

                override fun onError(anError: ANError?) {
                    // handle error
                }
            })
    }

}
