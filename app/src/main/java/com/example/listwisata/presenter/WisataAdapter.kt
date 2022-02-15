package com.example.listwisata.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listwisata.R
import com.example.listwisata.model.DataItem
import kotlinx.android.synthetic.main.item_row_list.view.*

class WisataAdapter(val dataWisata: List<DataItem?>?, val context: Context) :
    RecyclerView.Adapter<WisataAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageWisata = view.item_img_wisata
        val textWisata = view.item_text_wisata
        val textkota = view.item_text_kota
        val textprovinsi = view.item_text_provinsi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textWisata.text = dataWisata?.get(position)?.namaWisata
        holder.textkota.text = dataWisata?.get(position)?.kota
        holder.textprovinsi.text = dataWisata?.get(position)?.provinsi
        Glide.with(context)
            .load(dataWisata?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageWisata)
    }

    override fun getItemCount(): Int {
        if (dataWisata != null){
            return dataWisata.size
        }
        return 0
    }
}