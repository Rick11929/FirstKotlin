package com.hsbc.firstkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if (resultCode == Activity.RESULT_OK){
                val returnData = data?.getStringExtra("data_return")
                Toast.makeText(this,returnData,Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener{
            val data = "Data from Main Activity"
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("extra_data",data)
            startActivityForResult(intent,1)
        }

    }
}
