package com.example.coffee_break

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class vpAdapter(val context: Context, val list: ArrayList<guide>): RecyclerView.Adapter<vpAdapter.MyVH>() {
    class MyVH(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_guide)
        val image: ImageView = itemView.findViewById(R.id.image_guide)
    }
    override fun onCreateViewHolder (parent :ViewGroup, viewType: Int): MyVH
    {
        val root = LayoutInflater.from(context).inflate(R.layout.vp_adapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.title.text=list[position].title
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}