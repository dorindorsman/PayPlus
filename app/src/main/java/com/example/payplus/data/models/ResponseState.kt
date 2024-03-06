package com.example.payplus.data.models

import com.example.payplus.domain.models.Headers


sealed class Response {
    data class Success(val data: Headers) : Response()
    data class Error(val error: Throwable) : Response()
}