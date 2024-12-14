package com.example.quadactivity.lab3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quadactivity.databinding.ActivityLab3P2Binding

class Lab3P2 : AppCompatActivity() {
    private lateinit var binding: ActivityLab3P2Binding

    private val viewFuelModel: FuelModel by viewModels()

    private val fragAdd = FuelAddFragment()
    private val fragList = FuelListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLab3P2Binding.inflate(layoutInflater)

        viewFuelModel.setFuels(fuel)
        setFragment(fragAdd)

        binding.buttonViewAdd.setOnClickListener{setFragment(fragAdd)}
        binding.buttonViewList.setOnClickListener{setFragment(fragList)}

        setContentView(binding.root)
    }

    private fun setFragment(frag:Fragment){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(binding.fragmentView.id,frag)
        trans.commit()
    }

    private val fuel = mapOf("Аи-95" to 56.27, "Аи-92" to 51.01, "Газ" to 32.50)
}