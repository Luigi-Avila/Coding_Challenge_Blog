package com.luigidev.linkthread.features.home.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.luigidev.linkthread.core.FirebaseCollections
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.core.toDomain
import javax.inject.Inject


class HomeClient @Inject constructor(private val db: FirebaseFirestore) {
    fun getPosts(dataState: (ResultAPI<List<Post>>) -> Unit) {
        val reference = db.collection(FirebaseCollections.POSTS.toString())
        reference.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                dataState.invoke(ResultAPI.Success(task.result.documents.map {
                    it.toDomain()
                }))
            } else {
                dataState.invoke(ResultAPI.Error("Something went wrong"))
            }
        }
    }


}