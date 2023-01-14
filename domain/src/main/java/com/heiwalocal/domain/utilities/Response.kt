package com.heiwalocal.domain.utilities

data class Response <T>(
    val status: ResponseStatus,
    val data: T?
)
