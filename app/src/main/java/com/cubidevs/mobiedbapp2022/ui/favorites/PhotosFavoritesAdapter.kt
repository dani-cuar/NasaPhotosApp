package com.cubidevs.mobiedbapp2022.ui.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.CardViewItemPhotoBinding
import com.cubidevs.mobiedbapp2022.local.LocalPhoto
import com.squareup.picasso.Picasso

class PhotosFavoritesAdapter (
    private  val photosList: ArrayList<LocalPhoto>,
    private val onItemClicked: (LocalPhoto) -> Unit,
    private val onItemLongClicked: (LocalPhoto) -> Unit,
): RecyclerView.Adapter<PhotosFavoritesAdapter.PhotosFavoritesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosFavoritesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_photo, parent, false)
        return PhotosFavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosFavoritesViewHolder, position: Int) {
        val photo= photosList[position]
        holder.bindPhoto(photo)
        holder.itemView.setOnClickListener{ onItemClicked(photosList[position])}
        holder.itemView.setOnLongClickListener{ onItemLongClicked(photosList[position])
            true
        }
    }

    override fun getItemCount(): Int = photosList.size

    fun appendItems(newList: ArrayList<LocalPhoto>){
        photosList.clear()
        photosList.addAll(newList)
        notifyDataSetChanged()
    }

    class PhotosFavoritesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = CardViewItemPhotoBinding.bind(itemView)

        fun bindPhoto(photo: LocalPhoto){
            with(binding){
                photoTitleTextView.text = photo.title
                Picasso.get().load(photo.urlPicture).into(posterImageView)
            }
        }
    }
}