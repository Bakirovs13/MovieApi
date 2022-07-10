package com.example.movieapi.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.R
import com.example.movieapi.data.model.Movie
import com.squareup.picasso.Picasso


class PopularAdapter(private val mList:MutableList<Movie>) : RecyclerView.Adapter<PopularAdapter.ViewHolder> (){

    var onItemClick: ((Movie) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular,parent,false)
        return ViewHolder(view)
    }



    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = mList[position]
        setFadeAnimation(holder.itemView)
        Picasso.get().load(mList[position].imageurl).into(holder.popularImage)
        holder.popularName.text = mList[position].name+" (${listItem.realname})"
        holder.created.text = "Created by :${mList[position].createdby}"
        holder.appearance.text = "Team : ${listItem.team}"
        holder.bio.text = listItem.bio

    }

    override fun getItemCount(): Int = mList.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mList[position])
            }
        }
        val popularImage: ImageView = itemView.findViewById<ImageView>(R.id.popularImage)
        val popularName: TextView = itemView.findViewById<TextView>(R.id.PopularName_tv)
        val appearance: TextView = itemView.findViewById<TextView>(R.id.firstapperance_tv)
        val created: TextView = itemView.findViewById<TextView>(R.id.created_tv)
        val bio = itemView.findViewById<TextView>(R.id.bio_tv)

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 3.0f)
        anim.duration = 500
        view.startAnimation(anim)
    }


}