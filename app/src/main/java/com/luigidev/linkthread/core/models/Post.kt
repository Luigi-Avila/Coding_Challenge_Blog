package com.luigidev.linkthread.core.models

data class Post(
    val id: String? = null,
    val title: String = "",
    val author: String = "",
    val dateTime: String = "",
    val content: String = "",
) {
    fun matchSearchQuery(query: String): Boolean {
        val combinations = listOf(
            "${title.first()}",
            "$title $author",
            author,
            "$title$content",
            "${title.first()} ${content.first()}"
        )

        return combinations.any{
            it.contains(query, ignoreCase = true)
        }
    }
}
