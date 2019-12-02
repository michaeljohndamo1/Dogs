package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.model.DogBreed
import kotlinx.android.synthetic.main.items_dog.view.*

class DogListAdapter(val doglist: ArrayList<DogBreed>) : RecyclerView.Adapter<DogListAdapter.DogViewHolder>(){

    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.items_dog, parent, false )
        return DogViewHolder(view)
    }

    override fun getItemCount() = doglist.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dogName.text = doglist[position].dogBreed
        holder.view.lifeSpan.text = doglist[position].lifeSpan
    }


    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view){}
}