package com.example.domain.utility

data class Response<T> (
    var status: String,
    var data: T?
)