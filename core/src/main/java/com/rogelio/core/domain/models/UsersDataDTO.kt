package com.rogelio.core.domain.models

import android.os.Parcel
import android.os.Parcelable

data class UsersDataDTO(
    var calle: String? = null,
    var numero: String? = null,
    var colonia: String? = null,
    var delegacion: String? = null,
    var estado: String? = null,
    var cp: String? = null,
    var imagen: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(calle)
        parcel.writeString(numero)
        parcel.writeString(colonia)
        parcel.writeString(delegacion)
        parcel.writeString(estado)
        parcel.writeString(cp)
        parcel.writeString(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersDataDTO> {
        override fun createFromParcel(parcel: Parcel): UsersDataDTO {
            return UsersDataDTO(parcel)
        }

        override fun newArray(size: Int): Array<UsersDataDTO?> {
            return arrayOfNulls(size)
        }
    }
}
