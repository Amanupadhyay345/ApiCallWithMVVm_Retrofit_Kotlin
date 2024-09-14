package app.peerpicks.core.extensions

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.app.depandancyinjectionwithapicall.NetworkResult

import com.google.android.material.snackbar.Snackbar

import org.json.JSONObject
import retrofit2.Response


fun <T> handleResponse(
    response: Response<T>? = null,
    responseList: MutableLiveData<NetworkResult<T>>? = null
) {
    try {
        if (response!!.code() == 200 || response.code() == 201) {
            val responseBody = response.body()!!
            responseList!!.postValue(NetworkResult.Success(responseBody))
            Log.e("response", "$responseBody")
        } else if (response.errorBody() != null) {
            val errorobj = JSONObject(response.errorBody()!!.charStream().readText())
            responseList!!.postValue(NetworkResult.Error(errorobj.getString("message")))

            val message = errorobj.getString("message")
            Log.e("errorresponse", "$errorobj")
            Log.e("errorrmessage", "$message")
        } else {
            responseList!!.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    } catch (ex: Exception) {
        responseList!!.postValue(NetworkResult.Error(ex.message))
        ex.printStackTrace()
    }
}
