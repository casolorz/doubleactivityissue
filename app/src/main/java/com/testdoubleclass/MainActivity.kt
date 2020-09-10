package com.testdoubleclass

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testIntent = Intent(Intent.ACTION_VIEW)
        val uri = "a-custom-scheme://nothing"
        testIntent.data = Uri.parse(uri)
        val pm: PackageManager = getPackageManager()
        val activities = pm.queryIntentActivities(testIntent, 0)
        val size = activities.size
        output.text = "Found $size activities"
    }
}