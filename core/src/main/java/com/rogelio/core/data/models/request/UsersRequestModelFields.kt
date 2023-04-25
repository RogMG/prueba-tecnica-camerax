package com.rogelio.core.data.models.request

data class UsersRequestModelFields(
    var nombre: String? = null,
    var apellidoPaterno: String? = null,
    var apellidoMaterno: String? = null,
    var email: String? = null,
    var fechaNac: String? = null,
    var datos: String? = null,
)
