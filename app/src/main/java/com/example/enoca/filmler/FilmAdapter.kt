package com.example.enoca.filmler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.enoca.R

class FilmAdapter(private val filmListesi : List<Film>) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

        class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val filmImageView : ImageView = itemView.findViewById(R.id.filmImageView)
            val filmImageView2 : ImageView = itemView.findViewById(R.id.filmImageView)
            val filmImageView3 : ImageView = itemView.findViewById(R.id.filmImageView)
            val filmImageView4 : ImageView = itemView.findViewById(R.id.filmImageView)

            //koyle dan image viewları alcaz
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return FilmViewHolder(view)

    }

    override fun getItemCount(): Int {
        return filmListesi.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmListesi[position]
        holder.filmImageView.setImageResource(film.filmResim)




    }

}



