package ru.easycode.zerotoheroandroidtdd
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.security.Key

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val button = findViewById<Button>(R.id.removeButton)
        button.setOnClickListener { linearLayout.removeView(textView) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removeView = linearLayout.childCount == 1
        outState.putBoolean(KEY, removeView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removeView = savedInstanceState.getBoolean(KEY)
        if (removeView) linearLayout.removeView(textView)
    }

    companion object {
        const val KEY = "key"
    }
}