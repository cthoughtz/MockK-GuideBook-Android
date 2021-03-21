package com.example.mockkguidebookandroid.interfaces

import android.provider.VoicemailContract
import com.example.mockkguidebookandroid.Status

interface Robot {

    val currentModel: String
    suspend fun move(direction: String): String
    suspend fun findHumansAsync()
    suspend fun checkStatus(): Status
}