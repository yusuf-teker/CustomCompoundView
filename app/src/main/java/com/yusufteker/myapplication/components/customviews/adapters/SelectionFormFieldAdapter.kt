package com.yusufteker.myapplication.components.customviews.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.yusufteker.myapplication.R
import com.yusufteker.myapplication.components.models.SpinnerOneLineModel

class SelectionFormFieldAdapter: ArrayAdapter<SpinnerOneLineModel>{

    constructor(context: Activity, list : List<SpinnerOneLineModel> ): super(context,R.layout.custom_spinner_oneline,list){
        this.context = context
        this.list = list
    }

    private var context: Activity
    private var list: List<SpinnerOneLineModel>
    private var isAnySelected = false;

    companion object{
        private class ItemRowHolder(row: View) {
              lateinit var name : TextView
              lateinit var id: String
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vh: Companion.ItemRowHolder
        val row:View
        if (convertView==null){
            val inflater = context.layoutInflater
            row = inflater.inflate(R.layout.custom_spinner_oneline,parent,false)

            vh = ItemRowHolder(row)
            vh.name = row.findViewById<TextView>(R.id.spinner_oneline_text)
            row.tag = vh
        } else {
            row = convertView
            vh = row.tag as ItemRowHolder
            vh.name = row.findViewById<TextView>(R.id.spinner_oneline_text)
        }


        vh.name.text = list[position].getName()

        if (list[position].getColor() != -1){
            vh.name.setTextColor(list[position].getColor());
        }else{
            vh.name.setTextColor(context.resources.getColor(R.color.gray));
        }



        return row
    }



    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
       var view = convertView
        if (view==null){
            val inflater = context.layoutInflater
             view = inflater.inflate(R.layout.custom_spinner_oneline,parent,false)

            val vh = ItemRowHolder(view)
            vh.name = view.findViewById(R.id.spinner_oneline_text)
            view.tag = vh
        }
        val currentModel = list[position]
        val vh = view!!.tag as ItemRowHolder
        vh.name.text = currentModel.getName()



        if (currentModel.getId() != null && currentModel.getId() == "${Float.MIN_VALUE}"){
            isAnySelected= false
            vh.name.setTextColor(context.resources.getColor(list[position].getColor()));
        }else{
            isAnySelected=true
            if(currentModel.getId() != null && currentModel.getId().equals("-1")){
                vh.name.setTextColor(context.resources.getColor(list[position].getColor()));
            }else{
                if(list[position].getColor() != -1){
                    vh.name.setTextColor(context.resources.getColor(list[position].getColor()));
                }else{
                    vh.name.setTextColor(context.resources.getColor(R.color.gray))
                }
            }
        }



        return view
    }

    fun  getIsAnySelected(): Boolean = isAnySelected

}

