package com.udacity.shoestore.screens.shoes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val listOfShoes = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoeItem(shoe : Shoe) {
        listOfShoes.add(shoe)
        _shoeList.value = listOfShoes
        Timber.i(_shoeList.value.toString())
    }
}