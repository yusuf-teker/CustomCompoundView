

package com.yusufteker.myapplication.components.customviews.formfields

import android.content.Context
import android.text.*
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.AmountFormFieldData
import com.yusufteker.myapplication.components.models.FormFieldData


class AmountFormFieldView : FormFieldBaseView<EditText>,FormFieldBase  {

    private var data: AmountFormFieldData? = null

    constructor(context : Context) : super(context)
    constructor(context : Context,data: AmountFormFieldData?) : super(context,data)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    @Override
    override fun inflateRootLayout(){
        super.inflateRootLayout()
        viewInput = findViewById(R.id.form_field_edittext)
        viewInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()){
                    if (!s.contains('.') && s.length>data!!.MaxLength){
                        val newString = s.toString().substring(0..(data!!.MaxLength-1))
                        viewInput.setText(newString)
                    }
                    else if ( s[s.length-1] == '.' ){
                        viewInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(s.length+2))
                    } else if (s.length>3 && s[s.length-3] == '.'){
                        viewInput.setGravity(Gravity.RIGHT);
                    } else if (s.length == data!!.MaxLength){
                        viewInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(data!!.MaxLength+3))
                        viewInput.setText(s.toString()+".00")
                    }
                    else viewInput.setGravity(Gravity.CENTER_HORIZONTAL);
                }
            }
        })
    }

    @Override
    override fun getLayoutResourceId(): Int {
        return R.layout.layout_formfield_amount
    }

    override fun showError(warningMessage: String) {
        showDialog(warningMessage,R.drawable.warning)
        viewInput.setBackgroundResource(R.drawable.custom_wrong_input)
    }

     override fun setData( data: FormFieldData?){
         super.setData(data)
         this.data = data as AmountFormFieldData?
         if (data != null) {
             if (data.MaxLength>0){
                 viewInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(data.MaxLength))
             }
             viewInput.doOnTextChanged{ _, _, _, _ ->
                 clearError()
             }
             tooltipClickListener = OnClickListener {
                 //.. tooltip dialog mesajı burada yapılır //baseden kaldır
                 onTooltipClicked(it)
             }
         }
    }


    override fun validation(): String? {
        if(this.data != null){
            if (!TextUtils.isEmpty(this.data!!.ValidationMessageEmptyValue) && TextUtils.isEmpty(viewInput.text)) {
                return this.data!!.ValidationMessageEmptyValue
            }
            if (!TextUtils.isEmpty(this.data!!.ValidationMessageInvalidChars)){
                for (char in viewInput.text.toString()){
                    if (! data!!.AcceptedChars.contains(char)){ return this.data!!.ValidationMessageInvalidChars }
                }
            }
            if (data!!.MinAmount> 0 && !TextUtils.isEmpty(data!!.ValidationMessageInvalidAmount)  && viewInput.text.toString().toDouble() < 0.0){
                return this.data!!.ValidationMessageInvalidAmount
            }
        }


        return null
    }

    override fun clearError() {
        viewInput.setBackgroundResource(R.drawable.custom_input)
    }
    override fun onTooltipClicked(view: View) {
        super.showDialog(data!!.TooltipMessage,R.drawable.hint_button_parchment)
    }
}

