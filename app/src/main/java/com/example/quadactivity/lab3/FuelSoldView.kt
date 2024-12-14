package com.example.quadactivity.lab3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.quadactivity.R
import com.example.quadactivity.databinding.FuelSoldViewBinding

class FuelSoldView(context:Context, attrs:AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context,attrs,defStyleAttr) {
    private var binding: FuelSoldViewBinding

   init{
       val inflater = LayoutInflater.from(context)

       binding = FuelSoldViewBinding.inflate(inflater)

       addView(binding.root)
   }

    fun setData(name:String, price:Double, count:Double){
        binding.textFuelName.text = String.format(resources.getString(R.string.fuelName),name)
        binding.textFuelCount.text = String.format(resources.getString(R.string.fuelCount),count)
        binding.textFuelTotal.text = String.format(resources.getString(R.string.fuelTotal),price*count)
    }
}