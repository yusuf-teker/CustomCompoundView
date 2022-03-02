package com.yusufteker.myapplication.components.models

class EditTextFormFieldData(
    Title: String,
    TooltipMessage: String,
    ValidationMessage: String,
    ValidationMessageInvalidChars: String,
    ValidationMessageEmptyValue: String,
    ValidationMessageInvalidLength: String,
    MaxLength: Int,
    MinLength: Int,
) : FormFieldData(
    Title,
    TooltipMessage,
    ValidationMessage,
    ValidationMessageInvalidChars,
    ValidationMessageEmptyValue,
    ValidationMessageInvalidLength,
    MaxLength,
    MinLength,
    AcceptedChars="abcdefghijklmnopqrstuwxyz0123456789" ,

) {

}