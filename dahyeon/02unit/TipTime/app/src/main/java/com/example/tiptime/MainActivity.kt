package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        /* Views에 액세스하는 데 사용할 binding 객체 초기화*/
        setContentView(binding.root)
        /* R.layout.activity_main 대신 앱의 뷰 계층 구조 루트인 binding.root를 지정*/

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost  // 사용자가 반올림 옵션을 선택해서 값이 변경될 수 있기 때문에 val 이 아니라 var !
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)  // 숫자를 통화 형식으로 지정하는 데 사용할 수 있는 숫자 형식 지정 클래스가 제공된다
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}