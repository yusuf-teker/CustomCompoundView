package com.yusufteker.myapplication.components.customviews.formfields

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.AddressFormFieldData2
import com.yusufteker.myapplication.components.models.FormFieldData

class AddressFormFieldView2:  FormFieldBaseView<View>, FormFieldBase{

    private  var data: AddressFormFieldData2? = null
    lateinit var citySelection: SelectionFormFieldView
    lateinit var townSelection: SelectionFormFieldView
    lateinit var addressMultiLine: MultiLineFormFieldView
    private var allFormFields: ArrayList<FormFieldBase> =  ArrayList()

    constructor(context : Context) : super(context) { initView(data) }
    constructor(context : Context, data: AddressFormFieldData2?) : super(context) { initView(data) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { initView(data) }


    private fun  initView(data: AddressFormFieldData2?){
        inflate(context,getLayoutResourceId(),this)
        orientation = VERTICAL
        citySelection = findViewById(R.id.citySelectionFF)
        townSelection = findViewById(R.id.townSelectionFF)
        addressMultiLine = findViewById(R.id.addressMultiLineFF)
         setData(data)

    }

     fun setData(data: AddressFormFieldData2?) {
        if (data != null) {
            this.data = data
            // FF_Views'lerin datalrını set et datas

            if (data.CitySelectionFormFieldData!=null){
                citySelection.setData(data.CitySelectionFormFieldData)
            }else citySelection.visibility = GONE
            if (data.TownSelectionFormFieldData!=null){
                townSelection.setData(data.TownSelectionFormFieldData)
            }else townSelection.visibility = GONE

            addressMultiLine.setData(data.AddressMultiLineFormFieldData)
            allFormFields.add(citySelection)
            allFormFields.add(townSelection)
            allFormFields.add(addressMultiLine)
        }



    }


    override fun validation(): String? {
        for (ff in allFormFields){
            if (ff.validation()!=null){
                ff.showError(ff.validation()!!)
                //ff.setBackgroundInCorrect()
                return ff.validation()
            }
            ff.clearError()
            //ff.setBackgroundCorrect()
        }

        return null
    }



     override fun getLayoutResourceId(): Int {
        return R.layout.layout_formfield_address2
    }



    override fun showError(warningMessage: String) {
        //
    }

    override fun clearError() {
       //
    }




}