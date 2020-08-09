package io.github.ovso.sdksearch.data

data class Result(
    val exhaustiveNbHits: Boolean,
    val hits: List<Hit>,
    val hitsPerPage: Int,
    val index: String,
    val nbHits: Int,
    val nbPages: Int,
    val page: Int,
    val params: String,
    val processingTimeMS: Int,
    val query: String
)