package com.joel.noteapp.utils

sealed class  AppEvents {

    data class ShowSnackBar(
        val message : String,
        val action: String ?= null
    ) : AppEvents()

    object PopBackStack : AppEvents()

}