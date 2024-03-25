package com.example.gdscsohag.data

import android.util.Log
import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.domain.entity.User
import com.example.gdscsohag.domain.repo.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
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
        try {
            auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener {
                response = NetworkResponse.Success(true)
            }.addOnFailureListener {
                response = NetworkResponse.Error(message = it.message.toString())
            }.await()
        } catch (e: Exception) {
            response = NetworkResponse.Error(message = e.message.toString())
        }
        return response
    }

    override suspend fun getAllProgress(): NetworkResponse<List<Progress>> {
        val progress = db.collection("info").document("progress").get().await()
        val data = progress.data?.map {
            Progress(
                title = it.key.toString(),
                progressCount = it.value.toString().toInt()
            )
        }
        return if (data?.isNotEmpty() == true) NetworkResponse.Success(data) else NetworkResponse.Error(
            "Something wrong"
        )
    }

    override suspend fun getSessions(): NetworkResponse<List<Session>> {
        val data = db.collection("sessions").get().await()
        val sessions = data.documents.map {
            val t = db.collection("sessions").document(it.id).collection("tasks").get().await()
            val tasks = t.documents.map {
                Session.Task(
                    content = it.get("content").toString(),
                    points = it.get("points").toString().toInt()
                )
            }
            Session(
                startDate = it.get("start_date").toString(),
                endDate = it.get("end_date").toString(),
                sessionVideo = it.get("session").toString(),
                tasks = tasks
            )
        }

        return if (sessions.isNotEmpty()) NetworkResponse.Success(sessions) else
            NetworkResponse.Error("Something wrong")
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