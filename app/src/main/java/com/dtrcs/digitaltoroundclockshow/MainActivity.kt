package com.dtrcs.digitaltoroundclockshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dtrcs.digitaltoroundclockshow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var leftDigit = 0
    var rightDigit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClock.setOnClickListener { clockDigitToRound() }
    }

    fun clockDigitToRound(){

        rightDigit = binding.editRight.text.toString().toInt()*6
        leftDigit = binding.editLeft.text.toString().toInt()*30+(rightDigit/12).toInt()

        binding.imageView3.animate().apply {
            duration = 100
            binding.imageView3.pivotX = 25f
            binding.imageView3.pivotY = 335f
            rotationBy(rightDigit.toFloat())
        }.start()
        binding.imageView4.animate().apply {
            duration = 100
            binding.imageView4.pivotX = 34f
            binding.imageView4.pivotY = 240f
            rotationBy(leftDigit.toFloat())
        }.start()
    }
}