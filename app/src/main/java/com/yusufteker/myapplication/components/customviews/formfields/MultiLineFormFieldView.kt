package com.yusufteker.myapplication.components.customviews.formfields

import android.app.Dialog
import android.content.Context
import android.text.InputFilter
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.EditTextFormFieldData
import com.yusufteker.myapplication.components.models.FormFieldData

class MultiLineFormFieldView : FormFieldBaseView<EditText>,FormFieldBase{

    private var data: FormFieldData? = null

    //Birden fazla constructor için hepsini secondary olarak tanımladım
    constructor(context : Context) : super(context)
    constructor(context : Context, data: EditTextFormFieldData?) : super(context,data)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    @Override
    override fun inflateRootLayout(){
        super.inflateRootLayout() //title ve tooltip
        viewInput = findViewById(R.id.form_field_multiline_edittext)
    }

    override fun setData(data: FormFieldData?) {
        super.setData(data)
        this.data = data
        if (data != null) {
            if (data.MaxLength>0){
                viewInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(data.MaxLength))
            }
            viewInput.doOnTextChanged{ _, _, _, _ ->


                clearError()
            }
            tooltipClickListener = OnClickListener {
                onTooltipClicked(it)
            }
        }

        viewInput.setOnKeyListener(object : View.OnKeyListener{
            override fun onKey(view: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (event != null && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
                        return true
                return false
            }
        })


    }


    override fun getLayoutResourceId(): Int {
        return R.layout.layout_formfield_multiline
    }

    override fun onTooltipClicked(view: View) {
        super.showDialog(data!!.TooltipMessage,R.drawable.hint_button_parchment)
    }

    override fun showDialog(message: String, drawableResource: Int) {
        dialog = Dialog(context)
        dialog.setContentView(R.layout.form_field_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_bg)
        val dialogMessage = dialog.findViewById<TextView>(R.id.form_field_dialog_text)
        val dialogCloseButton = dialog.findViewById<Button>(R.id.form_field_dialog_button)
        val dialogImage = dialog.findViewById<ImageView>(R.id.form_field_dialog_image)
        dialogMessage.text = message
        dialogImage.setBackgroundResource(drawableResource)
        dialogCloseButton.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun clearError() {
        viewInput.setBackgroundResource(R.drawable.custom_input)
    }

    override fun showError(warningMessage: String) {
        showDialog(warningMessage,R.drawable.warning)
        viewInput.setBackgroundResource(R.drawable.custom_wrong_input)
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
            if (this.data!!.MinLength > 0 && !TextUtils.isEmpty(this.data!!.ValidationMessage) ){
                return this.data!!.ValidationMessageInvalidLength
            }
        }

        clearError()
        return null
    }

    fun getText():String{
        return viewInput.text.toString()
    }
}