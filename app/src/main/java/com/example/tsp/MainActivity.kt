package com.example.tsp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var spnMiastoStart : Spinner
    lateinit var spnMiastoKoniec: Spinner
    lateinit var edtDystans : EditText
    lateinit var bttDystans : Button
    lateinit var bttKomi    : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spnMiastoStart = findViewById(R.id.spnStartingCity)
        spnMiastoKoniec= findViewById(R.id.spnEndCity)
        edtDystans = findViewById(R.id.edtDistance)
        bttDystans = findViewById(R.id.bttDistAcc)
        bttKomi = findViewById(R.id.bttTSP)

        val lstMiasta = List<MutableList<Int>>(8) {
            MutableList<Int>(8) { 0 }
        }
            for (i in 0..7){
                for (j in i+1 .. 7){
                    val randed = (10..120).random()
                    lstMiasta[i][j] = randed
                    lstMiasta[j][i] = randed
                }
            }

            ArrayAdapter.createFromResource(
                this,
                R.array.arrCitiesNames,
                android.R.layout.simple_spinner_item
            ).also { adapt ->
                adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spnMiastoStart.adapter = adapt
                spnMiastoStart.adapter = adapt
            }

        fun odleglosc() {
            edtDystans.setText(lstMiasta[spnMiastoStart.selectedItemId.toInt()][spnMiastoKoniec.selectedItemId.toInt()].toString())
        }

        //listenery vvv
        spnMiastoStart.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                odleglosc()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spnMiastoKoniec.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                odleglosc()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        bttDystans.setOnClickListener {
            val startSpnId = spnMiastoStart.selectedItemId.toInt()
            val koniecSpnId= spnMiastoKoniec.selectedItemId.toInt()

            if(!edtDystans.text.isNullOrEmpty()){
                if(startSpnId != koniecSpnId){
                    lstMiasta[startSpnId][koniecSpnId] = edtDystans.text.toString().toInt()
                    lstMiasta[koniecSpnId][startSpnId] = edtDystans.text.toString().toInt()
                }else{
                    val toastText = "Dystans do tego samego miasta zawsze jest 0"
                    val toast = Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }else{
                val toastText = "Pole Dystans nie może być puste"
                val toast = Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT)
                toast.show()
            }
        }

    }//onCreate
}//MainActivity