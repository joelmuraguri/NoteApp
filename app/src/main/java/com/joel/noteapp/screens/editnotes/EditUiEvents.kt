package com.joel.noteapp.screens.editnotes

sealed class EditUiEvents{
    data class OnTitleChange(val title : String) : EditUiEvents()
    data class OnContentChange(val contents : String) : EditUiEvents()
    object ChangeBackgroundColor : EditUiEvents()
    object OpenBottomSheet : EditUiEvents()
    object CreateTag : EditUiEvents()
    object SaveNote : EditUiEvents()
}


data class EditInputValues(
    val title : String = "",
    val contents : String = ""
)
