package com.luigidev.linkthread.core

import com.google.firebase.firestore.DocumentSnapshot
import com.luigidev.linkthread.core.models.Post
import java.text.SimpleDateFormat
import java.util.Locale

fun DocumentSnapshot.toDomain():Post = Post(
        id= this.data?.get("id").toString(),
        title = this.data?.get("title").toString(),
        author = this.data?.get("author").toString(),
        dateTime = this.data?.get("dateTime").toString().toDateTime(),
        content = this.data?.get("content").toString()
    )


fun String.toDateTime(): String {
    val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US)
    val outputFormat = SimpleDateFormat("M/d/yyyy h:mm a", Locale.US)
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}