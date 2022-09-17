package com.cubidevs.mobiedbapp2022.ui.favorites

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.FragmentFavoritesBinding
import com.cubidevs.mobiedbapp2022.local.LocalPhoto

class FavoritesFragment : Fragment() {

    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var photosFavoritesAdapter: PhotosFavoritesAdapter
    private var photosList: ArrayList<LocalPhoto> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoritesViewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)

        favoritesViewModel.loadPhotos()

        photosFavoritesAdapter = PhotosFavoritesAdapter(photosList,
            onItemClicked = {onItemClicked(it)},
        onItemLongClicked = {onItemLongClicked(it)})

        favoritesBinding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FavoritesFragment.context)
            adapter = photosFavoritesAdapter
            setHasFixedSize(false)
        }

        favoritesViewModel.photoLoaded.observe(viewLifecycleOwner,{photosFavoritesAdapter.appendItems(it)})

        val root: View = favoritesBinding.root
        return root
    }

    private fun onItemLongClicked(localPhoto: LocalPhoto) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage("¿Desea eliminar ${localPhoto.title} de sus favoritos?")
                setPositiveButton(R.string.accept) { dialog, id ->
                    favoritesViewModel.deletePhoto(localPhoto)
                    favoritesViewModel.loadPhotos()
                }
                setNegativeButton(R.string.Cancel) { dialog, id ->
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }

    private fun onItemClicked(localPhoto: LocalPhoto) {

    }
}