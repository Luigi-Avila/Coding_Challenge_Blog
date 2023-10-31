package com.luigidev.linkthread.features.post.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.luigidev.linkthread.core.FirebaseCollections
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post

class PostClient {

    private val db = FirebaseFirestore.getInstance()

    fun uploadPost(post: Post, uploadState: (ResultAPI<String>) -> Unit) {
        val reference = db.collection(FirebaseCollections.POSTS.toString())
        reference.add(post).addOnSuccessListener { documentData ->
            reference.document(documentData.id).update(mapOf("id" to documentData.id))
                .addOnSuccessListener {
                    uploadState.invoke(ResultAPI.Success("Success"))
                }.addOnFailureListener {
                    uploadState.invoke(ResultAPI.Error(it.message.toString()))
                }
        }.addOnFailureListener {
            uploadState.invoke(ResultAPI.Error(it.message.toString()))
        }
    }
}