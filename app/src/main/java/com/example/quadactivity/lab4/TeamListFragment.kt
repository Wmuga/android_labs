package com.example.quadactivity.lab4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quadactivity.R
import com.example.quadactivity.databinding.FragmentTeamListBinding

class TeamListFragment : Fragment() {
    private lateinit var binding: FragmentTeamListBinding
    private val model:ParticipantsModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamListBinding.inflate(inflater,container,false)

        model.selected.observe(viewLifecycleOwner) { makeTeams(it.toTypedArray()) }

        return binding.root
    }

    private fun makeTeams(ar:Array<String>){
        ar.shuffle()
        val size = ar.size

        val team1 = ar.take(size/2).toTypedArray()
        val team2 = ar.takeLast(size-size/2).toTypedArray()


        val manager1 = LinearLayoutManager(requireContext())
        manager1.orientation = LinearLayoutManager.VERTICAL
        val manager2 = LinearLayoutManager(requireContext())
        manager2.orientation = LinearLayoutManager.VERTICAL

        binding.viewTeam1.layoutManager = manager1
        binding.viewTeam1.adapter = Adapter(requireContext(),team1)

        binding.viewTeam2.layoutManager = manager2
        binding.viewTeam2.adapter = Adapter(requireContext(),team2)
    }

    private class Adapter(private val ctx: Context, private val ar: Array<String>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val text: TextView = view.findViewById(R.id.textDropdownItem)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.dropdown_item, parent, false))
        }

        override fun getItemCount(): Int {
            return ar.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = ar[position]
            holder.text.text = data
        }
    }
}