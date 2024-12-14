package com.example.quadactivity.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.quadactivity.R
import com.example.quadactivity.databinding.FragmentFuelAddBinding

class FuelAddFragment : Fragment() {
    private lateinit var binding: FragmentFuelAddBinding
    private val viewFuelModel: FuelModel by activityViewModels()
    private val viewFuelSoldModel: FuelSoldModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFuelAddBinding.inflate(inflater,container,false)

        viewFuelModel.fuels.observe(viewLifecycleOwner){setFuels(it.keys)}

        binding.buttonAdd.setOnClickListener{addSold()}
        binding.editFuelCount.setOnClickListener{clear()}

        return binding.root
    }

    private fun setFuels(names:Set<String>){
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,names.toTypedArray())
        binding.spinnerFuel.adapter = adapter
    }

    private fun addSold(){
        try{
            val count = binding.editFuelCount.text.toString().toDouble()
            val name = binding.spinnerFuel.selectedItem.toString()

            viewFuelSoldModel.add(name,count)

            binding.textStatus.text = resources.getString(R.string.added)
            binding.textStatus.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }
        catch (e: Exception){
            binding.textStatus.text = resources.getString(R.string.testError)
            binding.textStatus.setTextColor(ContextCompat.getColor(requireContext(),R.color.red))
        }
        finally {
            binding.editFuelCount.setText("")
        }
    }

    private fun clear(){
        binding.textStatus.text = ""
    }
}