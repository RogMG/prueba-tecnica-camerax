package com.rogelio.core.domain.models

data class UsersFieldsDTO(
    var id: Int? = null,
    var nombre: String? = null,
    var apellidoPaterno: String? = null,
    var apellidoMaterno: String? = null,
    var edad: Int? = null,
    var email: String? = null,
    var fechaNac: String? = null,
    var datos: UsersDataDTO? = UsersDataDTO(),
)
