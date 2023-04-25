package com.rogelio.core.data.mappers

import com.google.gson.Gson
import com.rogelio.core.data.models.request.UsersRequestModelFields
import com.rogelio.core.domain.mappers.MapperTransform
import com.rogelio.core.domain.models.UsersFieldsRequestDTO

class UsersRequestMapper : MapperTransform<UsersFieldsRequestDTO, UsersRequestModelFields> {

    override fun transform(entryData: UsersFieldsRequestDTO?): UsersRequestModelFields {
        return UsersRequestModelFields(
            nombre = entryData?.nombre,
            apellidoPaterno = entryData?.apellidoPaterno,
            apellidoMaterno = entryData?.apellidoMaterno,
            email = entryData?.email,
            fechaNac = entryData?.fechaNac,
            datos = Gson().toJson(entryData?.datos).toString(),
        )
    }
}
