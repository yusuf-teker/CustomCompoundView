package com.yusufteker.myapplication.components.models

import android.view.View
import com.yusufteker.myapplication.components.customviews.formfields.FormFieldBaseView
import com.yusufteker.myapplication.components.customviews.formfields.MultiLineFormFieldView

class AddressFormFieldData2: FormFieldData{

     var  CitySelectionFormFieldData: SelectionFormFieldData? = null
     var  TownSelectionFormFieldData: SelectionFormFieldData? = null
    lateinit var  AddressMultiLineFormFieldData: EditTextFormFieldData

    constructor(

        CityFormFieldData: SelectionFormFieldData ,
        TownFormFieldData: SelectionFormFieldData,
        AddressFormFieldData: EditTextFormFieldData,
    ) : super(Title="",TooltipMessage="",ValidationMessage="",ValidationMessageInvalidChars="",ValidationMessageEmptyValue="",ValidationMessageInvalidLength="",MaxLength=-1,MinLength=-1, AcceptedChars="1234567890",GravityOption= FormFieldGravityOption.HORIZONTAL) {
        this.CitySelectionFormFieldData = CityFormFieldData
        this.TownSelectionFormFieldData = TownFormFieldData
        this.AddressMultiLineFormFieldData =  AddressFormFieldData
    }

    constructor( // Constructor with NO City And Town Selection
        AddressFormFieldData: EditTextFormFieldData,
    ): super(Title="",TooltipMessage="",ValidationMessage="",ValidationMessageInvalidChars="",ValidationMessageEmptyValue="",ValidationMessageInvalidLength="",MaxLength=-1,MinLength=-1, AcceptedChars="1234567890", GravityOption= FormFieldGravityOption.HORIZONTAL){
        this.AddressMultiLineFormFieldData =  AddressFormFieldData
    }



}
