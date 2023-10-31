package com.luigidev.linkthread.features.home.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.luigidev.linkthread.core.FirebaseCollections
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post


class HomeClient {

    private val db = FirebaseFirestore.getInstance()

    fun getPosts(dataState: (ResultAPI<List<Post>>) -> Unit) {
        val reference = db.collection(FirebaseCollections.POSTS.toString())

        reference.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                dataState.invoke(ResultAPI.Success(task.result.documents.map {
                    it.toObject(Post::class.java) ?: Post()
                }))
            } else {
                dataState.invoke(ResultAPI.Error("Something went wrong"))
            }
        }
    }


}