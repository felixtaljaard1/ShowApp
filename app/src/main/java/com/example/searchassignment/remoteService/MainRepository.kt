package com.example.searchassignment.remoteService

import javax.inject.Inject

class MainRepository @Inject constructor(val showsInterface: ShowsInterface) {
    suspend fun getAllShowDetails(showName: String)=
        showsInterface.getShowDetails(showName)
}