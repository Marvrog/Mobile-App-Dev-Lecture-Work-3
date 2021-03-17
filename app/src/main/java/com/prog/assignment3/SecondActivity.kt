package com.prog.assignment3

import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    var title = "Portrait v Landscape"

    private var toMonthly: Boolean? = null
    private var toYearly: Boolean? = null

    private var input: EditText? = null

    private var userInput: Editable? = null

    private var result: Double? = null

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setTitle(title)


        input = findViewById(R.id.editTextNumberSigned)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val button = findViewById<Button>(R.id.button)
         textView = findViewById(R.id.textView10)

        button.setOnClickListener {
            validation()
        }

        userInput = input!!.editableText

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.radioButton -> {
                    toMonthly = true
                    toYearly = false
                }
                R.id.radioButton2 -> {
                    toYearly = true
                    toMonthly = false
                }
                else -> {
                    toMonthly = false
                    toYearly = false
                }
            }
        }

    }

    private fun validation(){
        if(userInput!!.isEmpty()){
            getError("Input is Empty")
            input!!.requestFocus()
        }
        else{
            if(toMonthly == null && toYearly == null){
                getError("Select Conversion Mode")
            }
            else {
                val resultToDouble = userInput.toString().toDouble()
                if (toMonthly == true) {
                    result = resultToDouble / 12.0
                    textView!!.text = "Converted Rate is $result"
                } else if (toYearly == true) {
                    result = (resultToDouble * 12.0)
                    textView!!.setText("Converted Rate is $result")
                }
            }
        }

    }

    private fun getError(msg: String){
        Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
    }

}