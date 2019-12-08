package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.dogs.R
import com.example.dogs.model.DogApi
import com.example.dogs.model.DogBreed
import com.example.dogs.model.DogsApiService
import com.example.dogs.util.getProgressDrawable
import com.example.dogs.util.loadImage
import kotlinx.android.synthetic.main.items_dog.view.*
import java.util.ArrayList

class DogListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>(){

    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.items_dog, parent, false)
        return DogViewHolder(view)

    }

    override fun getItemCount()= dogList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

        holder.view.dogName.text = dogList[position].dogBreed
        holder.view.lifeSpan.text = dogList[position].lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailsFragment())
        }
        holder.view.imageView.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))

    }

    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view)

}