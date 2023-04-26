package com.example.focusproject4

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.focusproject4.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding : FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel

    var seekTimeMinValue = 10       //value for seekbar to translate into focus app.

    var activityCallback : MenuFragment.MenuListener? = null

    interface MenuListener{ //no body (no implementations.) Anything that calls it tho must implement this on click.
        fun onButtonClick(timerValue : Int, text: String)
    }
    //next code function event handler on Attach

    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        try{
            activityCallback = context as MenuListener      //explicit MenuListener "cast" will otherwise crash.
        }
        catch (e: ClassCastException)
        {
            throw ClassCastException(context.toString() + "must implement MenuListener")
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //where all is coded.



        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.seekBar2.setOnSeekBarChangeListener(this)


        binding.btnFocus.setOnClickListener {
            buttonClicked(it)   //calls function below. connected to interface.
        }
        //implement seekbar focus stuff. and timer to count down.
        binding.seekBar2.setMax(90)

        return binding.root
    }
     fun changeTextProperties(textVal: Int){
         Log.i("MenuFragment ","Value set to: " +textVal)
         seekTimeMinValue = textVal
        binding.tvTime.text = textVal.toString() + ":00"

    }
   //button clicked
    private fun buttonClicked(view : View){
        activityCallback?.onButtonClick(seekTimeMinValue, binding.tvTime.text.toString())
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel

    }
//events concerned with seekbarListener.
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

    Log.i("MenuFragment", "Progress is " + progress)
    seekTimeMinValue = progress //make progression of seekbar = our logic value.

    binding.tvTime.text = progress.toString() + ":00"  //updates as changed.

    //here is where the problem is for some reason.
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }


}