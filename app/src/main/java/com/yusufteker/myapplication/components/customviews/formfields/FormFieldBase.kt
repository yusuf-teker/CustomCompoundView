package com.yusufteker.myapplication.components.customviews.formfields

import com.yusufteker.myapplication.components.models.FormFieldData


interface FormFieldBase {
    fun clearError()
    fun showError(warningMessage: String)
    fun validation(): String?
    fun setData(data : FormFieldData?)



}