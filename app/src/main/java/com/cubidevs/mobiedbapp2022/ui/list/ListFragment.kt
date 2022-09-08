package com.cubidevs.mobiedbapp2022.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.databinding.FragmentListBinding
import com.cubidevs.mobiedbapp2022.server.model.Item

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var photosList: ArrayList<Item> = ArrayList()
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photosAdapter = PhotosAdapter(photosList, onItemClicked = {onPhotoItemClicked(it)})

        listBinding.photosRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = photosAdapter
            setHasFixedSize(false)
        }

        listViewModel.photoLoaded.observe(viewLifecycleOwner){ result ->
            onPhotosLoadedSubscribe(result)
        }

        listViewModel.getPhotos()
    }

    private fun onPhotoItemClicked(photo: Item) {
        findNavController().navigate(ListFragmentDirections.actionNavigationListToDetailFragment(photo))
    }

    private fun onPhotosLoadedSubscribe(item: ArrayList<Item>?) {
        item?.let { itemList ->
            photosAdapter.appendItems(itemList)
        }
    }


}