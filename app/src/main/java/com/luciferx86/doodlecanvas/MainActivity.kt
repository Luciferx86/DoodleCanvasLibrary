package com.luciferx86.doodlecanvas

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.luciferx86.doodlecanvaslibrary.DoodleCanvas

class MainActivity : AppCompatActivity() {
    lateinit var redButton: View;
    lateinit var greenButton: View;
    lateinit var yellowButton: View;
    lateinit var pinkButton: View;
    lateinit var blueButton: View;
    lateinit var slider: SeekBar;
    lateinit var canvas: DoodleCanvas;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews();

        setClickListeners();
    }

    private fun initViews(){
        canvas = findViewById(R.id.doodleCanvas);
        redButton = findViewById(R.id.redButton);
        yellowButton = findViewById(R.id.yellowButton);
        greenButton = findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);
        pinkButton = findViewById(R.id.pinkButton);
        slider = findViewById(R.id.slider);
    }

    private fun setClickListeners(){
        redButton.setOnClickListener{
            canvas.setStrokeColor(Color.parseColor("#ff0000"));
        }

        blueButton.setOnClickListener{
            canvas.setStrokeColor(Color.parseColor("#00c8ff"));
        }

        yellowButton.setOnClickListener{
            canvas.setStrokeColor(Color.parseColor("#ffff00"));
        }

        greenButton.setOnClickListener{
            canvas.setStrokeColor(Color.parseColor("#00ff99"));
        }

        pinkButton.setOnClickListener{
            canvas.setStrokeColor(Color.parseColor("#f5b0e5"));
        }

        slider.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                canvas.setStrokeWidth(progress.toFloat());
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}