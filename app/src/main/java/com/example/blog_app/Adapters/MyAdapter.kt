package com.example.blog_app.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blog_app.Data.BlogData
import com.example.blog_app.R

class MyAdapter(private val data: List<BlogData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(blog: BlogData){
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val description = view.findViewById<TextView>(R.id.tvDescription)

            title.text = blog.articles.title
            description.text = blog.articles.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}