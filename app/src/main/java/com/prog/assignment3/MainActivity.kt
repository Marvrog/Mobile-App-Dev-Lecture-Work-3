package com.prog.assignment3

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    private var title = "Application"
    private var spinner: Spinner? = null
    private val data = arrayOf("Card Type","Prog","King")
    private val stateData = arrayOf("State")
    private val countryData = arrayOf("Country")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(title)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        spinner = findViewById(R.id.cardType)
        val state = findViewById<Spinner>(R.id.state)
        val country = findViewById<Spinner>(R.id.country)


        spinner!!.setOnItemSelectedListener(this)
        state.setOnItemSelectedListener(this)
        country.setOnItemSelectedListener(this)

        val spinnerArray = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        spinnerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(spinnerArray)


        //State
        val spinnerStateArray = ArrayAdapter(this, android.R.layout.simple_spinner_item, stateData)
        spinnerStateArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        state!!.setAdapter(spinnerStateArray)

        //Country
        val spinnerCountryArray = ArrayAdapter(this, android.R.layout.simple_spinner_item, countryData)
        spinnerCountryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country!!.setAdapter(spinnerCountryArray)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "${data[position]}", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.next -> {
            val intent: Intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}