package uz.dilnoza.homework_3

import android.os.Bundle
import androidx.fragment.app.Fragment

fun Fragment.putArgument(block:Bundle.()->Unit):Fragment{
    val bundle=arguments?: Bundle()
    block(bundle)
    arguments=bundle
    return this
}