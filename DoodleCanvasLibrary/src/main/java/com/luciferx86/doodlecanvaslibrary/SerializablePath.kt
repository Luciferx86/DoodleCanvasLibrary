package com.luciferx86.doodlecanvaslibrary

import android.graphics.Path
import java.io.Serializable
import java.util.ArrayList


class SerializablePath : Path, Serializable {
    private var pathPoints: ArrayList<FloatArray>

    constructor() : super() {
        pathPoints = ArrayList()
    }

    constructor(p: SerializablePath) : super(p) {
        pathPoints = p.pathPoints
    }

    fun addPathPoints(points: FloatArray) {
        pathPoints.add(points)
    }

    fun loadPathPointsAsQuadTo() {
        val initPoints = pathPoints.removeAt(0)
        moveTo(initPoints[0], initPoints[1])
        for (pointSet in pathPoints) {
            quadTo(pointSet[0], pointSet[1], pointSet[2], pointSet[3])
        }
    }
}