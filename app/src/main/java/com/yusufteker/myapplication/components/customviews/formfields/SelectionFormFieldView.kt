package com.yusufteker.myapplication.components.customviews.formfields

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.*
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.customviews.adapters.SelectionFormFieldAdapter
import com.yusufteker.myapplication.components.models.EditTextFormFieldData
import com.yusufteker.myapplication.components.models.FormFieldData
import com.yusufteker.myapplication.components.models.SelectionFormFieldData
import com.yusufteker.myapplication.components.models.SpinnerOneLineModel

class SelectionFormFieldView: FormFieldBaseView<Spinner>,FormFieldBase  {

    private var data: SelectionFormFieldData? = null
    private var adapter : SelectionFormFieldAdapter? = null
    private lateinit var spinnerRootLayout: RelativeLayout
    private var selectedSpinnerOneLineModel: SpinnerOneLineModel? = null

    constructor(context : Context) : super(context)
    constructor(context : Context, data: EditTextFormFieldData?) : super(context,data)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    @Override
    override fun inflateRootLayout(){
        super.inflateRootLayout() //title ve tooltip
        viewInput = findViewById(R.id.form_field_spinner)
        //sonradan eklendi
        spinnerRootLayout = findViewById(R.id.spinnerRootLayout)
    }

    override fun setData( data: FormFieldData?){
        super.setData(data) //tilte ve tooltip değerleri ui'ya base ff'da atanıyor
        this.data = data as SelectionFormFieldData?
        if (data != null) {
            tooltipClickListener = OnClickListener {
                // tooltipListener'ın ne yapacağını burada tanımla - base FF'da bu clickListener kontrol ediliyor.
                // Eğer null ise tooltipe tıklandıgında default kodlar çalışırken
                // null değil(burada tanımlanmışsa) buradaki   onTooltipClicked fonksiyonunu calıstır
                onTooltipClicked(it)
            }



            if (this.data!!.IsSpinnerListHeader && this.data!!.Selections.isNotEmpty()){ //Spinner içinde en üstte başlık gözükmesini istiyorsak Itemların enbaşına yeni bir başlık item oluştur ve adaptera bu yeni datayı gönder
                val selections = ArrayList<SpinnerOneLineModel>()
                val headerSpinnerModel = SpinnerOneLineModel("Seçiniz","${Float.MIN_VALUE}",R.color.purple_200 )
                selections.add(headerSpinnerModel)
                for (i in data.Selections){
                    selections.add(i)
                }
                adapter = SelectionFormFieldAdapter(this.context as Activity,selections)    //Adapter Tanımlama
            }else{
                adapter = SelectionFormFieldAdapter(this.context as Activity, data.Selections)
            }

            viewInput.adapter = adapter //Spinner'a adapterı ekle

            if (!TextUtils.isEmpty(data.DefaultSelectionId)){ //Eğerki datada  spinner içinde default olarak gözükmesini istediğimiz bir değer var ise
                for (i in 0 until data.Selections.size){
                    if (data.Selections[i].getId() == data.DefaultSelectionId){
                        viewInput.setSelection( if(data.IsSpinnerListHeader) i+1 else i ) // o item'ı  seç
                    }
                }
            }

            viewInput.onItemSelectedListener = object : AdapterView.OnItemSelectedListener { //spinner üzerinde bir değer seçildiğinde
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    if (selectedSpinnerOneLineModel != null && selectedSpinnerOneLineModel!!.getId() != "${Float.MIN_VALUE}"){ //seçilen başlık değilse geçerli bir değerdir bu yüzden clear error
                        clearError()
                    }
                    if (adapter!!.getIsAnySelected()) clearError() //seçilen başlık değil veya seçilen başta gözüken default değer d eğil ise clearError

                    selectedSpinnerOneLineModel = parent.selectedItem as SpinnerOneLineModel? // seçilen spinner itemini al
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    //
                }
            }


        }



    }

    override fun clearError() {
        //viewInput.setBackgroundResource(R.drawable.custom_input)
        //sonradan eklendi
        spinnerRootLayout.setBackgroundResource(R.drawable.custom_input)
    }

    override fun showError(warningMessage: String) {
        showDialog(warningMessage,R.drawable.warning)
        //viewInput.setBackgroundResource(R.drawable.custom_wrong_input)
        //sonradan eklendi
        spinnerRootLayout.setBackgroundResource(R.drawable.custom_wrong_input)
    }

    override fun validation(): String? { //ff içinde geçerli bir input alınmış mı?
        if (!adapter?.getIsAnySelected()!! || (selectedSpinnerOneLineModel==null || selectedSpinnerOneLineModel!!.getId()=="${Float.MIN_VALUE}") && !TextUtils.isEmpty(data!!.ValidationMessageEmptyValue))
        {
            return data!!.ValidationMessageEmptyValue
        }

       return null
    }

    @Override
    override fun getLayoutResourceId(): Int {
        return R.layout.layout_formfield_selection //Custom Component XML olustur ve inflate işlemi için Base FF'e gönder
    }

    override fun onTooltipClicked(view: View) { //Burada tanımlananlar tooltipClickListener içinde çalıştırılacak
        showDialog(data!!.TooltipMessage,R.drawable.hint_button_parchment)
    }
    override fun showDialog(message: String, drawableResource: Int){
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

    fun getSelectedId(): String?{
        if (selectedSpinnerOneLineModel!=null){
            return selectedSpinnerOneLineModel!!.getId()
        }else return null
    }

/*
    fun setBackgroundWrong(){
        spinnerRootLayout.setBackgroundResource(R.drawable.custom_wrong_input)
    }
    fun setBackground(){
        spinnerRootLayout.setBackgroundResource(R.drawable.custom_input)
    }
    */

}