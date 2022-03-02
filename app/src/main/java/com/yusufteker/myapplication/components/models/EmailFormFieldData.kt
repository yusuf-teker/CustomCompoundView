package com.yusufteker.myapplication.components.models

open class EmailFormFieldData(
    open val Title: String,
    open val TipMessage: String,
    open val ValidationMessage: String,
    open val ValidationMessageInvalidEmail: String,
    open val ValidationMessageInvalidChars: String,
    open val ValidationMessageEmptyValue : String,
    open val MaxLength: Int,
    open val MinLength: Int,
    open val AcceptedChars: String,
)
