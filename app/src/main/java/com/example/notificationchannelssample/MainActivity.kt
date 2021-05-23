package com.example.notificationchannelssample

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
    }

    private fun createNotificationChannel() {

        val groupId = "my_group_01"
        val groupName = "Группа важных каналов"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            notificationManager.createNotificationChannelGroup(NotificationChannelGroup(groupId, groupName))

            val id = "importantChannel"
            val name = "Важный канал"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(id, name, importance)

            val descriptionText = "Описание важного канала. Обновление"
            channel.description = descriptionText

            channel.group = groupId

            notificationManager.createNotificationChannel(channel)

//            Открыть настройки
//            val intent = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS).apply {
//                putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
//                putExtra(Settings.EXTRA_CHANNEL_ID, channel.id)
//            }
//            startActivity(intent)

        }
    }

}