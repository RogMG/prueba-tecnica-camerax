package com.rogelio.core.util

import android.text.InputFilter
import android.text.Spanned
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.regex.Pattern

class ValidatorFields {

    private val EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+",
    )

    fun isValidDate(date: String): Boolean {
            val pattern = "^\\d{4}-\\d{2}-\\d{2}$"
            return pattern.toRegex().matches(date)
    }

    fun isValidEmail(email: String): Boolean {
        val matcher = EMAIL_PATTERN.matcher(email)
        return matcher.matches()
    }

    companion object {
        private const val ERROR_VALIDATE = "ERROR_VALIDATION_DATE"
    }
}
