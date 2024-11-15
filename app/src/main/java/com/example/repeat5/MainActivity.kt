package com.example.repeat5

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifecycle", "onCreate: Activity is created")

        val editText = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.Button)
        val txtSum = findViewById<TextView>(R.id.txtSum)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val txtExclude1 = findViewById<TextView>(R.id.txtExclude1)
        val txtOverAllTotal = findViewById<TextView>(R.id.txtOverAllTotal)
        val listView = findViewById<ListView>(R.id.listView)

        val items = mutableListOf<String>()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        var sumHolder: Double = 0.0
        var totalHolder: Double = 0.0
        var exclude1Holder: Double = 0.0
        var overAllTotalHolder: Double = 0.0

        button.setOnClickListener{
            val editTextValue = editText.text.toString().toInt()
            val editTextValue2 = editText2.text.toString().toInt()
            Log.i("TAG", "Edit Text 1: " + editTextValue.toString())
            Log.i("TAG", "Edit Text 1: " + editTextValue2.toString())


//            if(editTextValue != editTextValue2)
//            {
////                Log.i("TAG","VALUE")
////                items.add(editTextValue)
////                adapter.notifyDataSetChanged()
//
//                val sum = editTextValue.toInt() + editTextValue2.toInt()
//                items.add(sum.toString())
//                adapter.notifyDataSetChanged()
//            }

//            if(editTextValue > editTextValue2)
//            {
//                val subtract = editTextValue - editTextValue2
//                items.add(subtract.toString())
//                adapter.notifyDataSetChanged()
//            }
//
//            if(editTextValue2 > editTextValue)
//            {
//                val multiply = editTextValue * editTextValue2
//                items.add(multiply.toString())
//                adapter.notifyDataSetChanged()
//            }
//            else
//            {
//                val divide = editTextValue / editTextValue2
//                items.add(divide.toString())
//                adapter.notifyDataSetChanged()
//            }

            val sum = editTextValue + editTextValue2
            items.add(sum.toString())
            adapter.notifyDataSetChanged()

            sumHolder += sum
            txtSum.text = "Sum: $sumHolder"

            val sumTotal = (editTextValue + editTextValue2) * 0.20
            items.add(sum.toString())
            adapter.notifyDataSetChanged()

            totalHolder += sumTotal
            txtTotal.text = "20% Total of the List: $totalHolder"

            val exclude1 = "1"
            var sumExclude1: Double = 0.0

            if(!editTextValue.toString().contains(exclude1) && !editTextValue2.toString().contains(exclude1))
            {
                sumExclude1 = (editTextValue + editTextValue2).toDouble()
                items.add(sum.toString())
                adapter.notifyDataSetChanged()

                exclude1Holder += sumExclude1
                txtExclude1.text = "Total Numbers Without 1: $exclude1Holder"
            }
            else
            {
                Toast.makeText(this, "Cannot Add Numbers with \"1\"", Toast.LENGTH_SHORT).show()
            }

            var overAllTotal = sum + sumTotal + sumExclude1
            items.add(sum.toString())
            adapter.notifyDataSetChanged()

            overAllTotalHolder += overAllTotal

            if(overAllTotalHolder >= 1 && overAllTotalHolder <= 50)
            {
                txtOverAllTotal.text = "Overall Total: $overAllTotalHolder (Low)"
            }
            else if(overAllTotalHolder >= 51 && overAllTotalHolder <= 100)
            {
                txtOverAllTotal.text = "Overall Total: $overAllTotalHolder (Normal)"
            }
            else if(overAllTotalHolder >= 101 && overAllTotalHolder <= 200)
            {
                txtOverAllTotal.text = "Overall Total: $overAllTotalHolder (High)"
            }
            else
            {
                txtOverAllTotal.text = "Overall Total: $overAllTotalHolder (Out of Reach)"
            }


            Log.i("TAG", "Sum: " + sum.toString())
//            txtTotal.text =
//            txtExclude1.text =
//            txtOverAllTotal =


        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onStart: Activity has started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "onResume: Activity has resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "onPause: Activity is paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "onStop: Activity has stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "onDestroy: Activity is destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifecycle", "onRestart: Activity is restarted")
    }


}