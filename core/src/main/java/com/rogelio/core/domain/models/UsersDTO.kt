package com.rogelio.core.domain.models

data class UsersDTO(
    val Users: MutableList<UsersFieldsDTO> = mutableListOf()
)
