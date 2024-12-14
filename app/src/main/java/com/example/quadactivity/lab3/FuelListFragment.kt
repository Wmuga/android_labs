package com.example.quadactivity.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quadactivity.R
import com.example.quadactivity.databinding.FragmentFuelListBinding

class FuelListFragment : Fragment() {
    private lateinit var binding: FragmentFuelListBinding
    private val viewFuelModel: FuelModel by activityViewModels()
    private val viewFuelSoldModel: FuelSoldModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFuelListBinding.inflate(inflater,container,false)

        viewFuelSoldModel.sold.observe(viewLifecycleOwner){reset(it,viewFuelModel.fuels.value?: mapOf())}
        binding.buttonReset.setOnClickListener{viewFuelSoldModel.reset()}

        return binding.root
    }

    private fun reset(sold:Map<String,Double>,prices:Map<String,Double>){
        binding.layoutSold.removeAllViews()

        var total = 0.0

        sold.entries.forEach {
            val price = prices[it.key] ?: 0.0
            if (price <= 0.0) {
                return
            }

            val child = FuelSoldView(requireContext())
            child.setData(it.key,price,it.value)
            binding.layoutSold.addView(child)
            total += price*it.value
        }

        binding.textTotalTotal.text = String.format(resources.getString(R.string.fuelTotalTotal),total)
    }

}