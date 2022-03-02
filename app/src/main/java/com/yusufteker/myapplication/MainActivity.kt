package com.yusufteker.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.yusufteker.myapplication.components.customviews.formfields.*
import com.yusufteker.myapplication.components.customviews.other.EmailRegistrationFormFieldView
import com.yusufteker.myapplication.components.models.*

class MainActivity : AppCompatActivity() {

    val data = EmailRegistrationFormFieldData(
        "Kullanıcı Kayıt Formu",
        "Lütfen Formu Doldurun.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen geçerli bir mail adresi girin.",
        "Özel karakter içermeyen bir şifre giriniz.",
        "Lütfen gerekli alanları doldurunuz.",
        "Şifre 8 ila 15 karakter arasında olmalıdır.",
        15,8,
    )
    private val data2 = EditTextFormFieldData(
        "Text Formu",
        "Lütfen @itu.edu.tr uzantılı mailinizi girin.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        15,0)
    private val data3 = AmountFormFieldData(
        "Amount Formu",
        "Lütfen @itu.edu.tr uzantılı mailinizi girin.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen geçerli bir değer girin.",
        "Lütfen en az 8 karakter girin.",
        "Girilen değer 0 ile 10.000.000 arasında olmalıdır.",10_000_000.0,0.01)


    private val spinnerOneLineModel = SpinnerOneLineModel("Seçenek1","1")
    private val spinnerOneLineModel2 = SpinnerOneLineModel("Seçenek2","2")
    private val spinnerOneLineModel3 = SpinnerOneLineModel("Seçenek3","3")
    var selections = listOf<SpinnerOneLineModel>(spinnerOneLineModel,spinnerOneLineModel2,spinnerOneLineModel3)
    private val citySpinnerItem = SpinnerOneLineModel("City1","1")
    private val citySpinnerItem2 = SpinnerOneLineModel("City2","2")
    private val citySpinnerItem3 = SpinnerOneLineModel("City3","3")
    var selectionsCity = listOf<SpinnerOneLineModel>(citySpinnerItem,citySpinnerItem2,citySpinnerItem3)
    private val townSpinnerItem = SpinnerOneLineModel("town1","1")
    private val townSpinnerItem2 = SpinnerOneLineModel("town2","2")
    private val townSpinnerItem3 = SpinnerOneLineModel("town3","3")
    var selectionsTown = listOf<SpinnerOneLineModel>(townSpinnerItem,townSpinnerItem2,townSpinnerItem3)

    val data4 = SelectionFormFieldData(
    "Selection",
    "ToolTipMessage.",
    "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
    "Lütfen özel karakter girmeyin.",
    "Lütfen formu boş bırakmayın.",
    "Lütfen en az 8 karakter girin.",
        selections,"2",true

)
    private val data5 = EditTextFormFieldData(
        "Address",
        "Lütfen adres detayınızı giriniz.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        120,0)
    val data6 = SelectionFormFieldData(
        "City",
        "Lütfen ilinzi seçiniz.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        selectionsCity,"2",true
    )
    val data7 = SelectionFormFieldData(
        "Town",
        "Lütfen ilçenizi seçiniz.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        selectionsTown,"2",true

    )
    val dataAddress = AddressFormFieldData(
        "Address",
        "Lütfen adresinizi il ilçe ve detay olacak şekilde giriniz.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        listOf(data6,data7,data5)
    )


   // private lateinit var registrationFormField: EmailRegistrationFormFieldView
    private lateinit var editTextFormField: EditTextFormFieldView
    private lateinit var amountFormField: AmountFormFieldView
    private lateinit var selectionFormField: SelectionFormFieldView
    private lateinit var multiLineFormFieldView: MultiLineFormFieldView
    //private lateinit var addressFormFieldView: AddressFormFieldView
    private lateinit var addressFormFieldView2: AddressFormFieldView2
    private lateinit var isValidButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList: ArrayList<FormFieldBase> = ArrayList<FormFieldBase>()


       // registrationFormField = findViewById(R.id.emailRegistrationFormField)
        //registrationFormField.setData(data)
        editTextFormField = findViewById(R.id.editTextFormField)
        editTextFormField.setData(data2)
        arrayList.add(editTextFormField)
        amountFormField = findViewById(R.id.amountFormField)
        amountFormField.setData(data3)
        arrayList.add(amountFormField)
        selectionFormField = findViewById(R.id.selectionFormField)
        selectionFormField.setData(data4)
        arrayList.add(selectionFormField)
        multiLineFormFieldView = findViewById(R.id.multiLineFormField)
        multiLineFormFieldView.setData(data5)
        arrayList.add(multiLineFormFieldView)

        /*
        addressFormFieldView = findViewById(R.id.addressFormField)
        addressFormFieldView.setData(dataAddress)
        arrayList.add(addressFormFieldView.citySelection)
        arrayList.add(addressFormFieldView.townSelection)
        arrayList.add(addressFormFieldView.addressMultiLine)*/


        val addressFormFieldData2 = AddressFormFieldData2(data6,data7,data5)
       // val addressFormFieldData2 = AddressFormFieldData2(data5) //without city and town
        addressFormFieldView2 = findViewById(R.id.addressFormField2)
        addressFormFieldView2.setData(addressFormFieldData2)

        isValidButton = findViewById(R.id.button)
        isValidButton.setOnClickListener(View.OnClickListener {

            addressFormFieldView2.validation()

            /*
            for (ff in arrayList){
                if ( !ff.validation().isNullOrEmpty() ){
                   ff.showError(ff.validation()!!)
                   break
                }
            }*/


            //registrationFormField.validation()

        })

    }
}