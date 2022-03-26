package com.yusufteker.myapplication.components.models

enum class FormFieldGravityOption{
    VERTICAL,HORIZONTAL
}


open class FormFieldData (
    open val Title: String,
    open val TooltipMessage: String,
    open val ValidationMessage: String,
    open val ValidationMessageInvalidChars: String,
    open val ValidationMessageEmptyValue : String,
    open val ValidationMessageInvalidLength: String,
    open val MaxLength: Int,
    open val MinLength: Int,
    open val AcceptedChars: String,
    open val GravityOption: FormFieldGravityOption
) {

}

