package com.example.searchassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchassignment.model.ShowsModel
import com.example.searchassignment.remoteService.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Hilt
 * LiveData- hold data and give to view, will observe changes of livedata
 * Coroutines
 */

@HiltViewModel
class ShowsViewModel @Inject constructor(val mainRepository: MainRepository): ViewModel(){
    val showsLiveData = MutableLiveData<ShowsModel>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchShows(userRequest: String){
        viewModelScope.launch {
            var response = mainRepository.getAllShowDetails(userRequest)
            if(response.isSuccessful){
                showsLiveData.postValue(response.body())
            }else{
                errorLiveData.postValue(response.errorBody().toString())
            }
        }
    }
}