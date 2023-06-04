package com.joel.noteapp.core.utils

enum class Actions {
    ADD,
    UPDATE,
    DELETE,
    UNDO,
    NO_ACTION,
    DELETE_ALL,
}

fun String?.toAction(): Actions {
    return if (this.isNullOrEmpty()) Actions.NO_ACTION else Actions.valueOf(this)
}