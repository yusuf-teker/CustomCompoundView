package com.yusufteker.myapplication.components.models

import android.view.View
import com.yusufteker.myapplication.components.customviews.formfields.FormFieldBaseView

class AddressFormFieldData :FormFieldData {
    lateinit var FormFields: List<FormFieldData>

    constructor(
        Title: String,
        TooltipMessage: String,
        ValidationMessage: String,
        ValidationMessageInvalidChars: String,
        ValidationMessageEmptyValue: String,
        ValidationMessageInvalidLength: String,
        FormFields: List<FormFieldData> ,
        GravityOption: FormFieldGravityOption
        ): super(Title,TooltipMessage,ValidationMessage,ValidationMessageInvalidChars,ValidationMessageEmptyValue,ValidationMessageInvalidLength,MaxLength=8,MinLength=1, AcceptedChars="1234567890",GravityOption = FormFieldGravityOption.HORIZONTAL){

            this.FormFields = FormFields

    }


}