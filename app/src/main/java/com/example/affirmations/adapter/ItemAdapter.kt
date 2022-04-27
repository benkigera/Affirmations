package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list
//Create a new class for the adapter, for example, ItemAdapter.

/*Modify the ItemAdapter class to extend from the RecyclerView.Adapter
class with the custom ViewHolder class.*/

//Item adapter takes context and dataset (List etc)
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //nesting a class inside another class

    /*Create a custom ViewHolder class that represents
    a SINGLE LIST ITEM VIEW . Extend from RecyclerView.ViewHolder class.*/

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView =view.findViewById(R.id.item_image)
    }

    //Implement these methods


    //onCreateViewHolder called by RecyclerView to display the data at the specified position


    //onCreateViewHolder takes two parameters
    //parent = the view group that the new list item will be attached to which is recycler view
    //view type = use with multiple views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //obtain an instance of LayoutInflater from the provided context (context of the parent).
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        //Now adapterLayout holds a reference to the list item view
        return ItemViewHolder(adapterLayout)
    }

    /*The onBindViewHolder() method has two parameters, an ItemViewHolder previously
    created by the onCreateViewHolder() method, and an int that represents the current item */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}
