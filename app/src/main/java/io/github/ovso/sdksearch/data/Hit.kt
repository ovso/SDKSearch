package io.github.ovso.sdksearch.data

data class Hit(
    val _highlightResult: HighlightResult,
    val content: String,
    val headings: String,
    val objectID: String,
    val pageTitle: String,
    val type: String,
    val url: String
)