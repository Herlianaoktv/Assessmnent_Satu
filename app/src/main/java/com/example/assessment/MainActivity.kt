package com.example.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assessment.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDouble()
        val selectId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectId) {
            R.id.option_ten_percent ->0.1
            R.id.option_seven_percent ->0.07
            else -> 0.05
        }
        var tip = cost*tipPercentage
        val roundUp = binding.roundTip.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        val localeID = Locale("in", "ID")
        val currencyTip = NumberFormat.getCurrencyInstance(localeID).format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, currencyTip)
    }
}
