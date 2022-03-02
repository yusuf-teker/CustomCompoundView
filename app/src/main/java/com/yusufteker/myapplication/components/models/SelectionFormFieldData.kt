package com.yusufteker.myapplication.components.models


class SelectionFormFieldData: FormFieldData{
    lateinit var Selections: List<SpinnerOneLineModel>
    lateinit var  DefaultSelectionId: String
    var IsSpinnerListHeader: Boolean = false

    constructor(
        Title: String,
        TooltipMessage: String,
        ValidationMessage: String,
        ValidationMessageInvalidChars: String,
        ValidationMessageEmptyValue: String,
        ValidationMessageInvalidLength: String,
        Selections: List<SpinnerOneLineModel> ,

        ): super(Title,TooltipMessage,ValidationMessage,ValidationMessageInvalidChars,ValidationMessageEmptyValue,ValidationMessageInvalidLength,MaxLength=8,MinLength=1, AcceptedChars="1234567890"){

        this.Selections = Selections

    }

    constructor(
        Title: String,
        TooltipMessage: String,
        ValidationMessage: String,
        ValidationMessageInvalidChars: String,
        ValidationMessageEmptyValue: String,
        ValidationMessageInvalidLength: String,
        Selections: List<SpinnerOneLineModel> ,
        DefaultSelectionId: String,
        IsSpinnerListHeader:Boolean

        ):super(Title,TooltipMessage,ValidationMessage,ValidationMessageInvalidChars,ValidationMessageEmptyValue,ValidationMessageInvalidLength,MaxLength=8,MinLength=1, AcceptedChars="1234567890"){
        this.Selections = Selections
        this.DefaultSelectionId = DefaultSelectionId
    this.IsSpinnerListHeader =IsSpinnerListHeader
    }
}