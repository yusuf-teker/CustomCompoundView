package com.yusufteker.myapplication.components.models

import android.icu.text.CaseMap

class AmountFormFieldData : FormFieldData {

    val ValidationMessageInvalidAmount: String
    val MaxAmount: Double
    val MinAmount: Double

    constructor(
        Title: String,
        TooltipMessage: String,
        ValidationMessage: String,
        ValidationMessageInvalidChars: String,
        ValidationMessageEmptyValue: String,
        ValidationMessageInvalidLength: String,
        ValidationMessageInvalidAmount: String,
        MaxAmount: Double,
        MimAmount: Double,

    ): super(Title,TooltipMessage,ValidationMessage,ValidationMessageInvalidChars,ValidationMessageEmptyValue,ValidationMessageInvalidLength,MaxLength=8,MinLength=1, AcceptedChars=".1234567890"){
        this.ValidationMessageInvalidAmount = ValidationMessageInvalidAmount
        this.MaxAmount = MaxAmount
        this.MinAmount = MimAmount
    }
}
