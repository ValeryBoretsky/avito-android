package com.avito.buildontarget

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.Serializable

sealed class GitAccess(open val url: String) : Serializable {

    data class HttpAccess(
        override val url: String,
        val user: String,
        val password: String
    ) : GitAccess(
        url.toHttpUrl()
            .newBuilder()
            .username(user)
            .password(password)
            .build()
            .toString()
    )

    data class SshAccess(override val url: String) : GitAccess(url)
}
