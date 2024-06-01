package com.example.entertainer.data

/* Object to keep track of the Logged In User */
object SessionManager {
    /* For demonstration purposes, the default logged in user is ID- 1
    * Log In logic is not implemented, so to change the user, please change this ID */
    private const val DEFAULT_USER_ID = 1

    /* Keeping track of the User Id */
    private var userId: Int? = null

    init {
        userId = DEFAULT_USER_ID
    }

    /* Check if the user is logged in */
    fun isLoggedIn(): Boolean {
        return userId != null
    }

    /* Return the logged in user, or fall back to the Default user ID */
    fun getUserId(): Int {
        return userId ?: DEFAULT_USER_ID
    }
}