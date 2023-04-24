package com.rogelio.core.domain.mappers

interface MapperTransform<E, O> {
    fun transform(entryData: E?): O
}
