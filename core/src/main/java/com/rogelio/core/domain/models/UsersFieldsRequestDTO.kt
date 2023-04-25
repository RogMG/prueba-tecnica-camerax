package com.rogelio.core.domain.models


data class UsersFieldsRequestDTO(
    var nombre: String? = null,
    var apellidoPaterno: String? = null,
    var apellidoMaterno: String? = null,
    var email: String? = null,
    var fechaNac: String? = null,
    var datos: UsersDataDTO? = UsersDataDTO(),
)

