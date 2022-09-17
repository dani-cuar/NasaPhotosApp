package com.cubidevs.mobiedbapp2022.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.local.LocalPhoto
import com.cubidevs.mobiedbapp2022.local.repository.LocalPhotoRepository
import com.cubidevs.mobiedbapp2022.server.model.Item
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    var localPhotoRepository = LocalPhotoRepository()

    private val _photosLoaded: MutableLiveData<ArrayList<LocalPhoto>> = MutableLiveData()
    val photoLoaded: LiveData<ArrayList<LocalPhoto>> = _photosLoaded

    fun loadPhotos() {
        viewModelScope.launch {
            val listFavoritesPhotos = localPhotoRepository.getPhotos()
            _photosLoaded.postValue(listFavoritesPhotos as ArrayList<LocalPhoto>)
        }
    }

    fun deletePhoto(localPhoto: LocalPhoto) {
        viewModelScope.launch {
            localPhotoRepository.deleteMovie(localPhoto)
        }
    }


}