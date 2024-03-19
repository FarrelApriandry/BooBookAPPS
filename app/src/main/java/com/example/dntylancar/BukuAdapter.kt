package com.example.dntylancar

import android.content.Context
import android.media.Image
import android.provider.ContactsContract.Data
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dntylancar.databinding.FragmentKontenBukuTerkiniBinding

class BukuAdapter (

    private val context : Context,
    private val images : List <DataBuku>)

    : RecyclerView.Adapter<BukuAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val coverBuku = itemView.findViewById<ImageView>(R.id.cover_buku)
        val judulBuku = itemView.findViewById<TextView>(R.id.judul_buku)
        val ratingBuku = itemView.findViewById<TextView>(R.id.rating_buku)

        fun bindView(dataBuku: DataBuku) {
            coverBuku.setImageResource(dataBuku.dcoverBuku)
            judulBuku.text = dataBuku.dJudulBuku
            ratingBuku.text = dataBuku.dRatingBuku
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =

        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_konten_buku_terkini,parent, false))


    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}

