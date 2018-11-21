package com.boot.ads.ui.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Page Not Found")
class NotFound: RuntimeException()

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad Request")
class BadRequest: RuntimeException()

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
class InternalServerError: RuntimeException()
