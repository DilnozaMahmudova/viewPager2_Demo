package uz.dilnoza.homework_3

import android.graphics.Color

fun Int.toDarkenColor():Int{
    val hsv=FloatArray(3)
    Color.colorToHSV(this,hsv)
    hsv[2]*=0.8f
    return Color.HSVToColor(hsv)
}