package com.example.picsum.internal

object Version {
    val version_code: Int
        get() = (System.currentTimeMillis() / 60000).toInt()
    val version_name: String
        get() = "$major.$minor.$patch"
    val production_version_name: String
        get() =
            """\d+.\d+.\d+""".toRegex()
                .find(version_name)
                ?.value
                ?: "0.0.0"

    private const val major = 1
    private const val minor = 0
    private const val patch = 0
}
