package com.example.entertainer.data

object SessionManager {
    private const val DEFAULT_USER_ID = 1
    private var userId: Int? = null

    init {
        // Initialize with default user ID
        userId = DEFAULT_USER_ID
    }

    fun isLoggedIn(): Boolean {
        return userId != null
    }

    fun getUserId(): Int {
        return userId ?: DEFAULT_USER_ID
    }
}