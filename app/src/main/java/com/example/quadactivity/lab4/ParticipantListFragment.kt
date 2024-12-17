package com.example.quadactivity.lab4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quadactivity.databinding.FragmentParticipantListBinding

class ParticipantListFragment : Fragment() {
    private lateinit var binding: FragmentParticipantListBinding
    private val model:ParticipantsModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParticipantListBinding.inflate(inflater,container,false)

        model.all.observe(viewLifecycleOwner) {
            val manager = LinearLayoutManager(requireContext())
            manager.orientation = LinearLayoutManager.VERTICAL

            binding.listPart.layoutManager = manager
            binding.listPart.adapter = Adapter(requireContext(),model,it.toTypedArray())
        }

        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())

        binding.btnAdd.setOnClickListener{
            val text = binding.editNew.text.toString()
            if (text == ""){
                return@setOnClickListener
            }
            model.add(text)
            binding.editNew.text.clear()
        }
        binding.btnRemove.setOnClickListener{model.removeSelected()}


        binding.btnSave.setOnClickListener{model.save(pref)}
        binding.btnReload.setOnClickListener{model.load(pref)}

        return binding.root
    }

   private class Adapter(private val ctx: Context,private val model:Selector ,private val ar: Array<String>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        class ViewHolder(val view: ParticipantItem) : RecyclerView.ViewHolder(view) {
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          return ViewHolder(ParticipantItem(ctx))
        }

        override fun getItemCount(): Int {
            return ar.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = ar[position]
            holder.view.setData(data,::onSelect)
        }

        private fun onSelect(name:String,selected:Boolean){
            if (selected){
                model.select(name)
                return
            }
            model.deselect(name)
        }
   }

}