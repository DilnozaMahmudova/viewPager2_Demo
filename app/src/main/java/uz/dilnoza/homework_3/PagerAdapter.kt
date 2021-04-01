package uz.dilnoza.homework_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(
    private val data: List<Int>,
    private val image: List<Int>,
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {
    private var listenerNext:((Int)->Unit)?=null
    private var listenerBack:((Int)->Unit)?=null
    override fun getItemCount() = data.size

    override fun createFragment(position: Int): Fragment = ExampleFragment()
        .apply {
        listenerBack?.let { this.setBack(it)}
        listenerNext?.let { this.setNext(it) }
    }.putArgument {
        putInt("COLOR", data[position])
        putInt("IMAGE", image[position])
    }
    fun setNext(block:(Int)->Unit){
        listenerNext=block
    }
    fun setBack(block:(Int)->Unit){
        listenerBack=block
    }

}