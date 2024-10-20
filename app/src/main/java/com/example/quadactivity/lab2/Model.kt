package com.example.quadactivity.lab2

import java.io.Serializable

data class SelectMsg(val firstNum:Int, val random:Boolean) : Serializable;

data class ResultMsg(val countRight:Int, val countWrong:Int) : Serializable;
