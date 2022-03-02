package com.yusufteker.myapplication.components.models

class EmailRegistrationFormFieldData(
    override val Title: String,
    override val TipMessage: String,
    override val  ValidationMessage: String,
    override val ValidationMessageInvalidEmail: String,
    override val ValidationMessageInvalidChars: String,
    override val ValidationMessageEmptyValue: String,
    val ValidationMessageInvalidPasswordLength : String,
    override val MaxLength: Int,
    override val MinLength: Int,
    override val AcceptedChars:String = "abcdefghijklmnopqrstuwxyz0123456789",

) : EmailFormFieldData(
    Title,
    TipMessage,
    ValidationMessage,
    ValidationMessageInvalidEmail,
    ValidationMessageInvalidChars,
    ValidationMessageEmptyValue,
    MaxLength,
    MinLength,
    AcceptedChars,
)
