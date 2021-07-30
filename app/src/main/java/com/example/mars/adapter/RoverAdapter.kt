package com.example.mars.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mars.DetailActivity
import com.example.mars.R
import com.example.mars.model.Photo
import com.squareup.picasso.Picasso

class RoverAdapter(val context : Context, val photos: List<Photo>):
    RecyclerView.Adapter<RoverAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var roverImage = itemView.findViewById<ImageView>(R.id.roverImage)
        var tvRoverId = itemView.findViewById<TextView>(R.id.tvRoverId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rover_mini,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = photos[position]
        holder.tvRoverId.text = photo.id.toString()
        Glide.with(context).load(photo.img_src).into(holder.roverImage)
       // Picasso.get().load(photo.img_src).into(holder.roverImage)
        holder.roverImage.setOnClickListener(){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("image",photo.img_src)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return photos.size
    }


}