package com.cubidevs.mobiedbapp2022.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding
    private var photoExistAux = false

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photo = args.photo

        detailViewModel.searchPhoto(photo?.data?.get(0)?.nasaId)

        detailViewModel.photoExist.observe(viewLifecycleOwner) { photoExist ->
            if (photoExist) {
                detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites_exist))
                photoExistAux = true
            }
            else {
                detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites))
                photoExistAux = false
            }
        }

        with(detailBinding){
            photoTitleTextView.text = photo?.data?.get(0)?.title
            summaryTextView.text = photo?.data?.get(0)?.description
            Picasso.get().load(photo.links?.get(0)?.href).into(posterImageView)

            favoritesImageView.setOnClickListener{
                if (photoExistAux)
                    Toast.makeText(context, "${photo?.data?.get(0)?.title} ya esta en favoritos", Toast.LENGTH_LONG).show()
                else {
                    detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites_exist))
                    photoExistAux = true
                    detailViewModel.addPhotoToFavorites(photo)
                }
            }
        }
    }
}