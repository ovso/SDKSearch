package io.github.ovso.sdksearch.data

data class Headings(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)