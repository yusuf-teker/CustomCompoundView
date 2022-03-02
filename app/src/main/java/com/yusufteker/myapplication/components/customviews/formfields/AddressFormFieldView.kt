package com.yusufteker.myapplication.components.customviews.formfields

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.AddressFormFieldData
import com.yusufteker.myapplication.components.models.EditTextFormFieldData
import com.yusufteker.myapplication.components.models.FormFieldData

class AddressFormFieldView: FormFieldBaseView<EditText>,FormFieldBase  {

    private var data: AddressFormFieldData? = null
     lateinit var citySelection: SelectionFormFieldView
     lateinit var townSelection: SelectionFormFieldView
     lateinit var addressMultiLine: MultiLineFormFieldView
     val list = listOf(citySelection,townSelection,addressMultiLine)

    constructor(context : Context) : super(context)
    constructor(context : Context, data: AddressFormFieldData?) : super(context,data)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun getLayoutResourceId(): Int {
        return R.layout.layout_formfield_address
    }

    @Override
    override fun inflateRootLayout(){
        super.inflateRootLayout() //title ve tooltip
        citySelection = findViewById(R.id.citySelectionFF)
        townSelection = findViewById(R.id.townSelectionFF)
        addressMultiLine = findViewById(R.id.addressMultiLineFF)
    }


    override fun setData(data: FormFieldData?) {
        super.setData(data)
        this.data = data as AddressFormFieldData?
        if (data != null) {

            // FF_Views'lerin datalrını set et datas
            citySelection.setData(data.FormFields[0])
            townSelection.setData(data.FormFields[1])
            addressMultiLine.setData(data.FormFields[2])


            tooltipClickListener = OnClickListener {
                onTooltipClicked(it)
            }
        }



    }

    fun getCityCode():String?{
        return citySelection.getSelectedId()
    }
    fun getTownCode():String?{
        return townSelection.getSelectedId()
    }
    fun getAddressText():String{
        return addressMultiLine.getText()
    }



    override fun showError(warningMessage: String) {
       //
    }

    override fun clearError() {
        //
    }

    override fun validation(): String? {
        //Burada tek tek validationlar bakılacak
        for (ff in list){
            ff as FormFieldBaseView<*>
            if (ff.validation() != null){
                return ff.validation()
            }
        }/////////
        return null
    }
    override fun onTooltipClicked(view: View) { //Burada tanımlananlar tooltipClickListener içinde çalıştırılacak
        showDialog(data!!.TooltipMessage,R.drawable.hint_button_parchment)
    }

}