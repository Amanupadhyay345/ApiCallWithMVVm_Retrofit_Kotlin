package com.app.depandancyinjectionwithapicall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.peerpicks.core.extensions.handleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var repository: Repository

)  : ViewModel(){

    var getSkillsResponse = MutableLiveData<NetworkResult<Root>>()

    fun getSkills(){
        viewModelScope.launch(Dispatchers.IO+ repository.getExceptionHandler(getSkillsResponse)) {
            getSkillsResponse.postValue(NetworkResult.Loading())
            val response = repository.getSkills()
            handleResponse(response,getSkillsResponse)
        }
    }
}