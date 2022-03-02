package com.yusufteker.myapplication.components.customviews.other

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.EmailFormFieldData

class EmailLoginFormFieldView : LinearLayout{

    private var data : EmailFormFieldData? = null
    private lateinit var tipMessage : String

    private lateinit var tipImage : ImageButton
    private lateinit var titleText : TextView

    private lateinit var emailInput : EditText
    private lateinit var passwordInput : EditText




    constructor(context : Context) : super(context){
        initView(data)
    }
    constructor(context : Context,data: EmailFormFieldData?) : super(context){
        initView(data)
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initView(data)
    }

    fun initView(data: EmailFormFieldData?){
        inflateLayout()
        titleText = findViewById(R.id.form_field_title)
        tipImage = findViewById(R.id.form_field_tooltip)
        emailInput = findViewById(R.id.formfield_mail_edittext)
        passwordInput = findViewById(R.id.formfield_password_edittext)
        setData(data)
    }

    private fun inflateLayout() {
        inflate(getContext(), R.layout.layout_formfield_email_login, this);
    }

    fun setData(data : EmailFormFieldData?){
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

    fun validationInput(){

    }
}