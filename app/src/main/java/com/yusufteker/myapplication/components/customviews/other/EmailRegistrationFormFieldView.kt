package com.yusufteker.myapplication.components.customviews.other

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.EmailRegistrationFormFieldData

class EmailRegistrationFormFieldView : LinearLayout {
    private var data : EmailRegistrationFormFieldData? = null
    private lateinit var tipMessage : String

    private lateinit var tipImage : ImageButton
    private lateinit var titleText : TextView

    private lateinit var emailInput : EditText

    private lateinit var passwordInput : EditText
    private lateinit var passwordInput2 : EditText

    var isEmailError = true


    constructor(context : Context) : super(context){
        initView(data)
    }
    constructor(context : Context, data: EmailRegistrationFormFieldData?) : super(context){
        initView(data)
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initView(data)
    }

    fun initView(data: EmailRegistrationFormFieldData?){
        inflateLayout()
        titleText = findViewById(R.id.form_field_title)
        tipImage = findViewById(R.id.form_field_tooltip)
        emailInput= findViewById(R.id.formfield_mail_edittext)
        passwordInput = findViewById(R.id.formfield_password_edittext)
        passwordInput2 = findViewById(R.id.formfield_password_edittext2)
        setData(data)
    }

    private fun inflateLayout() {
        inflate(getContext(), R.layout.layout_formfield_email_registration, this);
    }

    fun setData(data : EmailRegistrationFormFieldData?){
        if (data!= null){
            this.data = data
            setUI(data.TipMessage,data.Title)
        }
    }

    private fun setUI(tipMessage : String, title : String) {
        titleText.text = if ( !title.isEmpty() ) title else  ""
        if (tipMessage.isNotEmpty()){
            tipImage.setImageResource(R.drawable.hint_button_parchment)
            tipImage.visibility = VISIBLE
        }//else tipImage.visibility = GONE      //default
    }

    fun validationInput(email : String, password : String, password2: String): String?{
        if (data != null){
            if (!TextUtils.isEmpty(data!!.ValidationMessageEmptyValue) && TextUtils.isEmpty(email)){
                return (data!!.ValidationMessageEmptyValue)
            }else if (!TextUtils.isEmpty(data!!.ValidationMessageInvalidEmail) && !isEmailInDatabase()){
                return data!!.ValidationMessageInvalidEmail
            }else if (!TextUtils.isEmpty(data!!.ValidationMessageInvalidPasswordLength) && data!!.MaxLength>0 && (password.length > data!!.MaxLength || password.length < data!!.MinLength ) ){
                isEmailError = false
                return data!!.ValidationMessageInvalidPasswordLength
            }
            else if (!TextUtils.isEmpty(data!!.ValidationMessageInvalidChars) && !TextUtils.isEmpty(data!!.AcceptedChars) ){
                for(i in password){
                    if (!data!!.AcceptedChars.contains(i)) return data!!.ValidationMessageInvalidChars
                }
                isEmailError = false
            }else if (password != password2){
                isEmailError = false
                return "Passwords do not match!"
            }
        }

        return null
    }

    private fun isEmailInDatabase(): Boolean {
        return false
    }

    fun validation():Boolean{
        val warningMessage = validationInput(emailInput.text.toString(), passwordInput.text.toString(), passwordInput2.text.toString())
        if (!TextUtils.isEmpty(warningMessage)){
            if (warningMessage != null) {
                showError(warningMessage)
            }
            return false
        }
        clearError()
        return true
    }

    private fun clearError() {
         emailInput.setBackgroundResource(R.drawable.custom_input)
    }

    private fun showError(errorMessage: String) {
        if (isEmailError){
            emailInput.setBackgroundResource(R.drawable.custom_wrong_input)
        }else{
            passwordInput.setBackgroundResource(R.drawable.custom_wrong_input)
            passwordInput2.setBackgroundResource(R.drawable.custom_wrong_input)
        }

    }
}