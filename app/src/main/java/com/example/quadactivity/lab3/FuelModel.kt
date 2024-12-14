package com.example.quadactivity.lab3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FuelModel:ViewModel() {
    private var _fuel: MutableMap<String, Double> = mutableMapOf()
    private var _fuelsLive: MutableLiveData<Map<String, Double>> = MutableLiveData(_fuel)

    var fuels: LiveData<Map<String, Double>> = _fuelsLive

    fun setFuels(fuels:Map<String, Double>){
        _fuel = fuels.toMutableMap()
        _fuelsLive.postValue(_fuel)
    }

    fun addFuel(name:String, price:Double){
        _fuel[name] = price
        _fuelsLive.postValue(_fuel)
    }
}

class FuelSoldModel: ViewModel(){
    private var _sold: MutableMap<String, Double> = mutableMapOf()
    private var _soldLive: MutableLiveData<Map<String, Double>> = MutableLiveData(_sold)
    var sold: LiveData<Map<String, Double>> = _soldLive

    fun add(name:String, count:Double){
        val oldCount = _sold[name] ?: 0.0
        _sold[name] = count+oldCount
        _soldLive.postValue(_sold)
    }

    fun reset(){
        _sold = mutableMapOf()
        _soldLive.postValue(_sold)
    }
}