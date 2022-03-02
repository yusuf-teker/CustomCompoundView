package com.yusufteker.myapplication.components.models

import com.yusufteker.myapplication.R

class SpinnerOneLineModel {




    private var name: String?= null
    private var id: String?=null
    private var value: String? = null
    private var color: Int = -1
    private var valueColor = R.color.gray


    constructor(name:String, id:String){
        this.name = name
        this.id = id
    }

    constructor(name:String, id:String, color:  Int){
        this.name = name
        this.id = id
        this.color = color
    }
    constructor(name:String,value: String, id:String){
        this.name = name
        this.id = id
        setValue(value)
    }

    constructor(name: String, s: String, s1: String, purple200: Int)

    private fun setValue(value: String?) {
        if (!value.isNullOrEmpty()){
            this.value = value
            this.valueColor = R.color.purple_500
        }
    }

    fun getColor(): Int = color
    fun setColor(style: Int) {
        this.color = style
    }
    fun getValueColor(): Int = valueColor
    fun setValueColor(valueColor: Int) {
        this.valueColor = valueColor
    }
    fun getName(): String? = name
    fun setName(name: String) {
        this.name = name
    }
    fun getId(): String? = id
    fun setId(id: String) {
        this.id = id
    }



}