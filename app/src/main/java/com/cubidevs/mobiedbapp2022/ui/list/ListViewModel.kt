package com.cubidevs.mobiedbapp2022.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.server.model.Item
import com.cubidevs.mobiedbapp2022.server.model.NasaList
import com.cubidevs.mobiedbapp2022.server.nasarepository.NasaRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val nasaRepository = NasaRepository()

    private val _photosLoaded: MutableLiveData<ArrayList<Item>> = MutableLiveData()
    val photoLoaded: LiveData<ArrayList<Item>> = _photosLoaded

    fun getPhotos() {
        viewModelScope.launch {
            val photosList: NasaList = nasaRepository.getPhotos()
            _photosLoaded.postValue(photosList.collection?.items as ArrayList<Item>)  //como sacar las fotos y verlas?
        }
    }
}