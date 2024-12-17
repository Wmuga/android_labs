package com.example.quadactivity.lab4

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

interface Selector{
    fun select(person:String)
    fun deselect(person:String)
}

class ParticipantsModel : ViewModel(),Selector {
    private val dataPrefix = "Person"
    private val nPrefix = "N"

    private val _participants = ArrayList<String>()
    private val _staticSelected = mutableSetOf<String>()

    private val _all = MutableLiveData(_participants)
    private val _selected: MutableLiveData<Set<String>> = MutableLiveData(_staticSelected)

    val all: LiveData<ArrayList<String>> get() = _all
    val selected: LiveData<Set<String>> get() = _selected

    fun load(preferences: SharedPreferences){
        _participants.clear()
        val count = preferences.getInt(nPrefix,0)
        (0..<count).forEach{
            val part = preferences.getString(dataPrefix+it.toString(),"")
            if (part == null || part == "" ){
                return
            }
            _participants.add(part)
        }
        _all.postValue(_participants)
    }

    fun save(preferences: SharedPreferences){
        val edit = preferences.edit()

        edit.putInt(nPrefix,_participants.size)
        (0..<_participants.size).forEach{
            edit.putString(dataPrefix+it.toString(), _participants[it])
        }

        edit.apply()
    }

    override fun select(person:String){
        _staticSelected.add(person)
        _selected.postValue(_staticSelected)
    }

    override fun deselect(person:String){
        _staticSelected.remove(person)
        _selected.postValue(_staticSelected)
    }

    fun add(person:String){
        _staticSelected.clear()
        _selected.postValue(_staticSelected)
        _participants.add(person)
        _all.postValue(_participants)
    }

    fun removeSelected(){
        _staticSelected.forEach{
            _participants.remove(it)
        }
        _staticSelected.clear()
        _all.postValue(_participants)
        _selected.postValue(_staticSelected)
    }
}