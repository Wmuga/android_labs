package com.example.quadactivity.lab4

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.quadactivity.R
import com.example.quadactivity.databinding.SelectViewBinding

class ParticipantItem(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context,attrs,defStyleAttr) {
    private val binding: SelectViewBinding
    private var selected = false

    init{
        val inflater = LayoutInflater.from(context)

        binding = SelectViewBinding.inflate(inflater)

        addView(binding.root)
    }

    fun setData(name:String, onSelect: (name:String, selected:Boolean)->Unit){
        binding.textView.text = name
        binding.textView.setOnClickListener{
            if (!selected){
                binding.textView.setBackgroundResource(R.color.green)
            } else{
                binding.textView.setBackgroundResource(0)
            }
            selected = !selected
            onSelect(name,selected)
        }
    }
}