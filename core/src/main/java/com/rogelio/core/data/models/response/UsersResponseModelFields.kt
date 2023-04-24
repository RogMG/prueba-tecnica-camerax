package com.rogelio.core.data.models.response

import com.google.gson.annotations.SerializedName

data class UsersResponseModelFields (
    @SerializedName("id"              ) var id              : Int?    = null,
    @SerializedName("nombre"          ) var nombre          : String? = null,
    @SerializedName("apellidoPaterno" ) var apellidoPaterno : String? = null,
    @SerializedName("apellidoMaterno" ) var apellidoMaterno : String? = null,
    @SerializedName("edad"            ) var edad            : Int?    = null,
    @SerializedName("email"           ) var email           : String? = null,
    @SerializedName("fechaNac"        ) var fechaNac        : String? = null,
    @SerializedName("datos"           ) var datos           : UsersResponseModelData?  = UsersResponseModelData()
)