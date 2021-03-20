package com.example.mockkguidebookandroid.interfaces

interface Navigator {

    val currentLocation:String
    fun navigateTo(newLocation: String)
}