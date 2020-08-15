package com.luciferx86.doodlecanvas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LaunchpadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchpad)
        val startDrawing: Button = findViewById(R.id.startDrawing);

        startDrawing.setOnClickListener{
            val i: Intent = Intent(this, MainActivity::class.java);
            startActivity(i);
        }
    }
}