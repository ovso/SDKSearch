package io.github.ovso.sdksearch.data

data class Url(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)