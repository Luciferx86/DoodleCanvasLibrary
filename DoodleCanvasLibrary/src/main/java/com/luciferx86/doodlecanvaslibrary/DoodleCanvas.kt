package com.luciferx86.doodlecanvaslibrary

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


class DoodleCanvas(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private var canDraw: Boolean = true;
    private var mPaint: Paint = Paint()
    private var lastPaintStroke: Paint = Paint()
    private var mPath: SerializablePath
    private var pathList: ArrayList<PathPojo> = ArrayList()
    private var backupPathList: ArrayList<PathPojo> = ArrayList()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (path in pathList) {
            Log.d("PathVal", path.toString())
            val pathToDraw = path.path;
            mPaint.color = path.color
            mPaint.strokeWidth = path.strokeWidth
            canvas.drawPath(pathToDraw, mPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (this.canDraw) {
                    mPath = SerializablePath();

                    mPath.moveTo(event.x, event.y)
                    pathList.add(
                        PathPojo(
                            mPath,
                            mPaint.color,
                            mPaint.strokeWidth
                        )
                    )
                    invalidate()
                    return true;
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (this.canDraw) {

                    mPath.lineTo(event.x, event.y)
                    invalidate()
                    return true
                }
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return false
    }

    init {
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.strokeWidth = 10f
        mPath = SerializablePath()
    }


    fun setStrokeColor(color: Int) {
        mPaint.color = color;
    }

    fun setStrokeWidth(strokeWidth: Float) {
        mPaint.strokeWidth = strokeWidth;
    }

    fun undoMove() {
        if (pathList.size > 0) {
            pathList.removeAt(pathList.size - 1);
        } else {
            pathList.addAll(backupPathList);
        }
        invalidate();
    }

    fun enableErasing() {
        storeLastPaintStroke(mPaint);
        mPaint.color = Color.WHITE;
    }

    private fun storeLastPaintStroke(lastPaint: Paint) {
        lastPaintStroke.strokeWidth = lastPaint.strokeWidth;
        lastPaintStroke.color = lastPaint.color;
    }

    fun enablePainting() {
        mPaint = lastPaintStroke;

    }

    fun clearCanvas() {
        backupPathList.clear()
        backupPathList.addAll(pathList)
        pathList.clear();
        invalidate();
    }

    fun updateCanvas(newPathList: ArrayList<PathPojo>) {
        this.pathList.clear();
        this.pathList.addAll(newPathList);
        invalidate();
    }

    fun canUserDraw(canDraw: Boolean) {
        this.canDraw = canDraw;
    }
}