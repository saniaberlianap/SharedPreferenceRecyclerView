package com.example.sharedpreferencemahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.textViewNama?.text = user.nama
        holder?.textViewNomor?.text = user.nomor
        holder?.textViewAlamat?.text = user.alamat

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewNama = itemView.findViewById(R.id.textViewNama) as TextView
        val textViewNomor = itemView.findViewById(R.id.textViewNomor) as TextView
        val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView




    }




}