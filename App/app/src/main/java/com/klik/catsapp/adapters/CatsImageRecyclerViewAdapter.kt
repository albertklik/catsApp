package com.klik.catsapp.adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.klik.catsapp.R
import com.klik.catsapp.models.CatsSearchRequest
import java.net.URL


class CatsImageRecyclerViewAdapter (private val dataSet: List<CatsSearchRequest.CatsImage>) : RecyclerView.Adapter<CatsImageRecyclerViewAdapter.ViewHolder>()
{
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val textView : TextView = view.findViewById(R.id.textView)
        var imageView : ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(viewgroup : ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.img_item,viewgroup,false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.textView.text = dataSet[position].title
        Glide.with(holder.imageView.context)
            .load(dataSet[position].getCoverUrl())
            .apply(RequestOptions().placeholder(R.drawable.ic_baseline_image_24))
            .into(holder.imageView)
    }

    override fun getItemCount() = dataSet.size
}