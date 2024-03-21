package com.example.gdscsohag.data

import android.util.Log
import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.domain.entity.User
import com.example.gdscsohag.domain.repo.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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

    override suspend fun getSessions(): NetworkResponse<List<Session>> {
        var response: NetworkResponse<List<Session>> = NetworkResponse.Error("")
        db.collection("sessions").get().addOnSuccessListener {
            val list = ArrayList<Session>()
            it.documents.forEach {
                val session = Session(
                    startDate = it.get("start_date").toString(),
                    endDate = it.get("end_date").toString(),
                    sessionVideo = it.get("session").toString(),
                    tasks = it.get("tasks") as List<String>
                )
                list.add(session)
            }
            response = NetworkResponse.Success(list)
        }.addOnFailureListener {
            response = NetworkResponse.Error(it.message.toString())
        }.await()
        return response
    }

    override suspend fun getAllTasks(): List<Task> {
        return listOf()
    }

    override suspend fun getAllTrainee(): List<User> {
        return listOf()
    }

    override suspend fun getTraineeByPoints(): NetworkResponse<List<User>> {
        var response: NetworkResponse<List<User>> = NetworkResponse.Error("")
        db.collection("users").orderBy("points", Query.Direction.ASCENDING).get()
            .addOnSuccessListener {
                val list = ArrayList<User>()
                it.forEach {
                    val user = User(
                        name = it.get("name").toString(),
                        email = it.get("email").toString(),
                        points = it.get("points").toString(),
                        image = it.get("image").toString(),
                        section = it.get("section").toString(),
                        status = it.get("status").toString(),
                        phone = it.get("phone").toString()
                    )
                    list.add(user)
                }
                Log.i(TAG, list.toString())
                response = NetworkResponse.Success(list)
            }.addOnFailureListener {
                response = NetworkResponse.Error(it.message.toString())
            }.await()
        return response
    }
}