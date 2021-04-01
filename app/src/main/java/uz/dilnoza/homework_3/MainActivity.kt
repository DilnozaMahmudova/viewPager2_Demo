package uz.dilnoza.homework_3

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PagerAdapter
    private val data = arrayListOf(
        Color.parseColor("#F43757"),
        Color.parseColor("#8A63B3"),
        Color.parseColor("#3C97E9")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = arrayListOf(R.drawable.p1, R.drawable.p2, R.drawable.p3)
        adapter = PagerAdapter(data, image, this)
        pager.adapter = adapter
        adapter.setBack { pager.currentItem = pager.currentItem - 1 }
        adapter.setNext { pager.currentItem = pager.currentItem + 1 }
        TabLayoutMediator(tabLay, pager) { tab, position ->

        }.attach()
        tabLay.selectedTabPosition
        pager.registerOnPageChangeCallback(pageChangeCallback)
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.navigationBarColor = data[position].toDarkenColor()
                window.statusBarColor = data[position].toDarkenColor()
            }
        }
    }
}
