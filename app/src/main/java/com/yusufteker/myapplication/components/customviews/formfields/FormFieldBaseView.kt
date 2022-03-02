package com.yusufteker.myapplication.components.customviews.formfields

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.annotation.LayoutRes
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.FormFieldData


abstract class FormFieldBaseView<ViewInput : View> : LinearLayout {



    private var data: FormFieldData? = null
    private lateinit var titleTextView: TextView
    private lateinit var tooltipButton: ImageButton
    protected lateinit var dialog: Dialog

    var tooltipClickListener : OnClickListener? = null


    protected lateinit var viewInput: ViewInput //her custom formfield içinde bir input var(editText-spinner vs).

    constructor(context: Context) : super(context) {
        initView(null)
    }

    constructor(context: Context, data: FormFieldData?) : super(context) { //constructor içinde data gönderilebilir
        initView(data) //oluşturulur oluşturulmaz datayı al ve gerekli yerleri düzenle
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(null)
    }

    private fun initView(data: FormFieldData?) {
        inflateRootLayout() //
        orientation = VERTICAL
        setData(data)
    }

    open fun setData(data: FormFieldData?) { //basede setdata abstract
        if (data != null) {
            this.data = data
            if (!TextUtils.isEmpty(data.Title))
                setTitleText(data.Title, data.TooltipMessage)
        }
    }

    private fun setTitleText(title: String, tooltip: String) {
        titleTextView.text = title
        if (!TextUtils.isEmpty(tooltip)) {
            tooltipButton.visibility = VISIBLE
            tooltipButton.setBackgroundResource(R.drawable.hint_button_parchment)
            tooltipButton.setOnClickListener {
                onTooltipClicked(it)
            }
        }else tooltipButton.visibility = GONE
        if (TextUtils.isEmpty(title)){
            titleTextView.visibility = GONE
        }
    }

    open fun inflateRootLayout() {
        inflate(context, getLayoutResourceId(), this)//getLayoutResourceId ile ff'ın layoutunu alıyoruz
        titleTextView = findViewById(R.id.form_field_title)  //All FormFields have a title text!
        tooltipButton = findViewById(R.id.form_field_tooltip) //All FormFields have a tooltip button!
    }

    @LayoutRes
    abstract fun getLayoutResourceId(): Int// Base ff'dan üretilen ff kendi layout res ıd'sini veriyor

    open fun onTooltipClicked(view: View) {

        if (tooltipClickListener != null){ // Base ff'dan üretilen ff tooltipClickListener tanımlamış ise tanımlanan onClick eventini calıstır
            tooltipClickListener!!.onClick(view)
        }else if (this.data != null && !TextUtils.isEmpty(this.data!!.TooltipMessage)) { // tooltipClickListener tanımlanmamış ise default dialog mesajını gönder
            showDialog(this.data!!.TooltipMessage,R.drawable.hint_button_parchment)
        }
    }

    abstract fun showError(warningMessage: String)

    abstract fun clearError()

    abstract fun validation(): String?

    open fun showDialog(message: String, drawableResource: Int){
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


}