package com.veselove.myapplication211021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.veselove.myapplication211021.databinding.ActivityMainBinding
import com.veselove.myapplication211021.ex_001_flow.FlowActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View?) {
        when (v?.id){
            (R.id.button1) -> {
                val intent = Intent(this, FlowActivity::class.java);
                startActivity(intent)
            }

            R.id.button2 -> {
                Toast.makeText(this, "Button2", Toast.LENGTH_SHORT).show();
            }

            R.id.button3 -> {
                Toast.makeText(this, "Button3", Toast.LENGTH_SHORT).show();
            }

            R.id.button4 -> {
                Toast.makeText(this, "Button4", Toast.LENGTH_SHORT).show();
            }

            R.id.button5 -> {
                Toast.makeText(this, "Button5", Toast.LENGTH_SHORT).show();
            }

            R.id.button6 -> {
                Toast.makeText(this, "Button6", Toast.LENGTH_SHORT).show();
            }

            R.id.button7 -> {
                Toast.makeText(this, "Button7", Toast.LENGTH_SHORT).show();
            }

            R.id.button8 -> {
                Toast.makeText(this, "Button8", Toast.LENGTH_SHORT).show();
            }
        }

    }
}