package com.example.gdscsohag.data

import android.text.BoringLayout
import android.util.Log
import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.domain.entity.User
import com.example.gdscsohag.domain.repo.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

private const val TAG = "RepositoryImpl"

class RepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore,
    private val auth: FirebaseAuth
) : Repository {
    override suspend fun login(email: String, pass: String): NetworkResponse<Boolean> {
        var response: NetworkResponse<Boolean> = NetworkResponse.Error("")
        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener {
            response = NetworkResponse.Success(true)
        }.addOnFailureListener {
            response = NetworkResponse.Error(message = it.message.toString())
        }.await()
        return response
    }

    override suspend fun getAllProgress(): List<Progress> {
        return listOf()
    }

    override suspend fun getAllTasks(): List<Task> {
        return listOf()
    }

    override suspend fun getAllTrainee(): List<User> {
        return listOf()
    }

    override suspend fun getTraineeByPoints(): List<User> {
        val data = db.collection("users").orderBy("points", Query.Direction.DESCENDING).get()
            .addOnSuccessListener {
                it.forEach {
                    Log.i(TAG, it.data.toString())
                }
                // NetworkResponse.Success()
            }.addOnFailureListener {

            }
        return listOf()
    }
}