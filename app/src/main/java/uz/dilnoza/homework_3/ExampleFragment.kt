package uz.dilnoza.homework_3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.example_page.*

class ExampleFragment : Fragment(R.layout.example_page) {
    private var listenerNext: ((Int) -> Unit)? = null
    private var listenerBack: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = requireArguments()
        val color = bundle.getInt("COLOR", 0)
        image.setImageResource(bundle.getInt("IMAGE", 0))
        layoutContent.setBackgroundColor(color)
      back.setOnClickListener {
            listenerBack?.invoke(color)
        }


        next.setOnClickListener {
            listenerNext?.invoke(color)
        }

    }

    fun setNext(block: (Int) -> Unit) {
        listenerNext = block
    }

    fun setBack(block: (Int) -> Unit) {
        listenerBack = block
    }
}