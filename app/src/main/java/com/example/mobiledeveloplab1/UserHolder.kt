package com.example.firstlesson

import androidx.annotation.VisibleForTesting

object UserHolder {

    private val map = mutableMapOf<String, User>()
    private val phoneFormat = Regex("""^[+][\d]{11}""")

    fun registerUser(
        fullName: String,
        email: String,
        password: String
    ): User = User.makeUser(fullName, email = email, password = password)
        .also { user ->
            if (map.containsKey(user.login)) throw IllegalArgumentException("A user with this email already exists")
            else map[user.login] = user
        }

    fun loginUser(login: String, password: String): String? {
        val phoneLogin = cleanPhone(login)
        return if (phoneLogin.isNotEmpty()) {
            map[phoneLogin]
        } else {
            map[login.trim()]
        }?.let {
            if (it.checkPassword(password)) it.userInfo
            else null
        }
    }


   fun registerUserByPhone(fullName: String, rawPhone: String): User = User.makeUser(fullName, telephone = rawPhone)
           .also { user ->
               if (map.containsKey(user.telephone)) throw IllegalArgumentException("This telephone is already existed!")
               if (cleanPhone(rawPhone).matches("^\\+?[0-9]{3}-?[0-9]{6,12}\$".toRegex())) map[user.login] = user
               else throw IllegalArgumentException("This telephone is not correct")
            }

    fun requestAccessCode(login: String) {
        val telephone = cleanPhone(login)
        val username = map[phone];
        if (username != null) {
            val accessCode = username.generateAccessCode()
            username.passwordHash = username.encrypt(accessCode)
            username.accessCode = accessCode;
            username.sendAccessCodeToUser(telephone,accessCode)
            map[telephone] = username
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun clearHolder() {
        map.clear()
    }

    private fun cleanPhone(phone: String): String {
        return phone.replace("""[^+\d]""".toRegex(), "")
    }
}