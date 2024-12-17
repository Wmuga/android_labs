package com.example.quadactivity.lab4

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.quadactivity.R
import com.example.quadactivity.databinding.ActivityLab4Binding

class Lab4 : AppCompatActivity() {
    private lateinit var binding: ActivityLab4Binding
    private val model: ParticipantsModel by viewModels()

    private val fragPart = ParticipantListFragment()
    private val fragTeam = TeamListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this);
        model.load(preferences)

        binding = ActivityLab4Binding.inflate(layoutInflater)

        setSelect()

        setContentView(binding.root)
    }

    private fun setSelect(){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(binding.fragmentView.id, fragPart)
        trans.commit()

        binding.btnFrag.text = getString(R.string.btnTeam)
        binding.btnFrag.setOnClickListener{setTeam()}
    }

    private fun setTeam(){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(binding.fragmentView.id, fragTeam)
        trans.commit()

        binding.btnFrag.text = getString(R.string.btnSelect)
        binding.btnFrag.setOnClickListener{setSelect()}
    }
}