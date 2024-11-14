package com.example.repeat5

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.Button)
        val listView = findViewById<ListView>(R.id.listView)

        val items = mutableListOf<String>()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter



        button.setOnClickListener{
            val editTextValue = editText.text.toString().toInt()
            val editTextValue2 = editText2.text.toString().toInt()
            Log.i("TAG", editTextValue.toString())
            Log.i("TAG", editTextValue2.toString())
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

            if(editTextValue > editTextValue2)
            {
                val subtract = editTextValue - editTextValue2
                items.add(subtract.toString())
                adapter.notifyDataSetChanged()
            }

            if(editTextValue2 > editTextValue)
            {
                val multiply = editTextValue * editTextValue2
                items.add(multiply.toString())
                adapter.notifyDataSetChanged()
            }
            else
            {
                val divide = editTextValue / editTextValue2
                items.add(divide.toString())
                adapter.notifyDataSetChanged()
            }

        }

    }
}