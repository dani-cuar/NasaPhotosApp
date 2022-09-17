package com.cubidevs.mobiedbapp2022.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.local.LocalPhoto
import com.cubidevs.mobiedbapp2022.local.repository.LocalPhotoRepository
import com.cubidevs.mobiedbapp2022.server.model.Item
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    val localPhotoRepository = LocalPhotoRepository()

    private val _photoExist : MutableLiveData<Boolean> = MutableLiveData()
    val photoExist: LiveData<Boolean> = _photoExist

    fun addPhotoToFavorites(photo: Item) {
        val localPhoto = photo?.data?.get(0)?.nasaId?.let {
            LocalPhoto(
                id = it,
                urlPicture = photo.links?.get(0)?.href,
                title = photo?.data?.get(0)?.title,
                summary = photo?.data?.get(0)?.description)
        }

        viewModelScope.launch {
            localPhoto?.let { localPhotoRepository.savePhoto(it) }
        }
    }

    fun searchPhoto(nasaId: String?) {
        var photoExistAux = false
        viewModelScope.launch {
            val localPhoto = localPhotoRepository.searchPhoto(nasaId)
            if (localPhoto != null)
                photoExistAux = true
            _photoExist.postValue(photoExistAux)
        }
    }
}