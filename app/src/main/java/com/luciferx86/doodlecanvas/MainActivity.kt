package com.luciferx86.doodlecanvas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luciferx86.doodlecanvaslibrary.DoodleCanvas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val canvas: DoodleCanvas = findViewById(R.id.doodleCanvas);
        canvas.setStrokeColor(Color.parseColor("#00ffbf"));
    }
}