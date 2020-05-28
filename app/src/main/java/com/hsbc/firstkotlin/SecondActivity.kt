package com.hsbc.firstkotlin

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {


    @RequiresApi(VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //send Data back to MainActivity
        val extraData= intent.getStringExtra("extra_data")
        textView1.text = extraData
        button1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","Return from Second Activity")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        //send Notification
        val intent = Intent(this,NotificationActivity::class.java)
        val pi = PendingIntent.getActivities(this,0, arrayOf(intent),0)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        button2.setOnClickListener {
            val notification = NotificationCompat.Builder(this,"normal")
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.large_icon))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
            manager.notify(1,notification)
        }

    }
}
