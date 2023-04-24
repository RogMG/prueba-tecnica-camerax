package com.rogelio.core.data.models.response

import com.google.gson.annotations.SerializedName


data class UsersResponseModelData (

  @SerializedName("calle"      ) var calle      : String? = null,
  @SerializedName("numero"     ) var numero     : String? = null,
  @SerializedName("colonia"    ) var colonia    : String? = null,
  @SerializedName("delegacion" ) var delegacion : String? = null,
  @SerializedName("estado"     ) var estado     : String? = null,
  @SerializedName("cp"         ) var cp         : String? = null,
  @SerializedName("imagen"     ) var imagen     : String? = null

)