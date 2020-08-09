package io.github.ovso.sdksearch.data

data class HighlightResult(
    val content: Content,
    val headings: Headings,
    val type: Type,
    val url: Url
)