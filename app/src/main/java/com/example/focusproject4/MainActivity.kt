package com.example.focusproject4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.focusproject4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuFragment.MenuListener {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick(timerValue: Int, text: String) {
       val textFragment = supportFragmentManager.findFragmentById(R.id.tvTime) as MenuFragment

        textFragment.changeTextProperties(timerValue)//function to be implemented.
    }       //checkout timer: CountdownTimer parameter for later use...

}
