package com.example.focusproject4

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.focusproject4.databinding.FragmentMenuBinding
import kotlin.time.Duration.Companion.minutes

class MenuViewModel : ViewModel() {
   var COUNT_TIMER = 59000L
    val ONE_SECOND = 1000L
    val DONE = 0L

        var minute = 0L

    var counterActive =false;

    private lateinit var binding : FragmentMenuBinding



    lateinit var timer:CountDownTimer
    val currentTime = MutableLiveData<Long>()       //used to track our current time.

    init {
        timer =  object:CountDownTimer(COUNT_TIMER, ONE_SECOND){
            override fun onTick(millisUntilFinished: Long) {

                    currentTime.value = millisUntilFinished / ONE_SECOND

            }

            override fun onFinish() {
                currentTime.value = DONE
            }

        }
        //timer.start()
    }


}
/*

public fun start_timer(view: View){
        if (counterActive == false) {
            counterActive = true
            //disable_seekbar
            //set button text to "Stop"

          var timer =  object : CountDownTimer(59000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    binding.tvDescription.text = "seconds remaining: " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                binding.tvDescription.setText("done!")
                }
            }.start()

        }//end of CountDown.timer
    }//end of start timer.
    public fun update(progress :Int){
        var minutes = progress;
        var seconds = progress % 60;
        var secondsFinal = ""
        if (seconds <=9){
            secondsFinal = "0" + seconds.toString()
        }
        else{
            secondsFinal = "" + seconds.toString()
        }
        if(seconds %60 == 0)
        {
            minutes -=1
        }
    }

 */