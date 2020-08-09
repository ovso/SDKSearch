package io.github.ovso.sdksearch.data

data class Type(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)