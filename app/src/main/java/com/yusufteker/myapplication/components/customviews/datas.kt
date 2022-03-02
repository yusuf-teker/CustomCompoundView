package com.yusufteker.myapplication.components.customviews

import com.yusufteker.myapplication.components.models.*

class datas {

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
     val data2 = EditTextFormFieldData(
        "Text Formu",
        "Lütfen @itu.edu.tr uzantılı mailinizi girin.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        15,0)
     val data3 = AmountFormFieldData(
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
        "Adres",
        "Lütfen @itu.edu.tr uzantılı mailinizi girin.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        120,0)
    val data6 = SelectionFormFieldData(
        "City",
        "ToolTipMessage.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        selectionsCity,"2",true
    )
    val data7 = SelectionFormFieldData(
        "Town",
        "ToolTipMessage.",
        "Şuan işleminizi gerçekleştiremiyoruz. Lütfen sonra tekrar deneyiniz.",
        "Lütfen özel karakter girmeyin.",
        "Lütfen formu boş bırakmayın.",
        "Lütfen en az 8 karakter girin.",
        selectionsTown,"2",true

    )


}