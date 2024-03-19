package com.example.dntylancar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dntylancarS.DataBuku

class BukuAdapter(

    private val context: Context,
    private var images : MutableList<DataBuku>
)

    : RecyclerView.Adapter<BukuAdapter.ImageViewHolder>()
{
    fun setData(newData: List<DataBuku>) {
        images = newData.toMutableList()
        notifyDataSetChanged()
    }
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ImageViewHolder {

//        ImageViewHolder(
//            LayoutInflater.from(context)
//                .inflate(R.layout.fragment_konten_buku_terkini, parent, false)
//        )

        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_konten_buku_terkini, viewGroup, false)

        return ImageViewHolder(v)

    }


    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}

