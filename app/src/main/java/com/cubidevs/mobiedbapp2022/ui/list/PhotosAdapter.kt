package com.cubidevs.mobiedbapp2022.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.CardViewItemPhotoBinding
import com.cubidevs.mobiedbapp2022.server.model.Data
import com.cubidevs.mobiedbapp2022.server.model.Item
import com.cubidevs.mobiedbapp2022.server.model.Link
import com.squareup.picasso.Picasso

class PhotosAdapter (
    private  val photosList: ArrayList<Item>,
    private val onItemClicked: (Item) -> Unit
        ): RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_photo, parent, false)
        return PhotoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo= photosList[position]
        holder.bindPhoto(photo)
        holder.itemView.setOnClickListener{ onItemClicked(photosList[position])}
    }

    override fun getItemCount(): Int = photosList.size

    fun appendItems(newList: ArrayList<Item>){
        photosList.clear()
        photosList.addAll(newList)
        notifyDataSetChanged()
    }

    class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = CardViewItemPhotoBinding.bind(itemView)

        fun bindPhoto(photo: Item){
            with(binding){
                photoTitleTextView.text = photo?.data?.get(0)?.title
                Picasso.get().load(photo.links?.get(0)?.href).into(posterImageView)

            }
        }
    }
}