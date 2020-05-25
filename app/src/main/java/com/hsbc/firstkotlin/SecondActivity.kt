package com.hsbc.firstkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extraData= intent.getStringExtra("extra_data")
        textView1.text = extraData
        button1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","Return from Second Activity")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
