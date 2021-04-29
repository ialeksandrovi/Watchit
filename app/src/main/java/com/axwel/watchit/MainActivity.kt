package com.axwel.watchit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnButton: Button
    lateinit var tvText1: TextView
    lateinit var tvText2: TextView
    lateinit var tvText3: TextView
    lateinit var tvText4: TextView
    lateinit var tvText5: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        tvText1 = findViewById(R.id.tvText1)
        tvText2 = findViewById(R.id.tvText2)
        tvText3 = findViewById(R.id.tvText3)
        tvText4 = findViewById(R.id.tvText4)
        tvText5 = findViewById(R.id.tvText5)
        btnButton = findViewById(R.id.btnButton)

        val exampleDataClass = ExampleDataClass("String1", 1)
        val copy = exampleDataClass.copy()



        btnButton.apply {
            text = getString(R.string.button_title)
            setOnClickListener {
                tvText1.text = "${getString(R.string.line)} 1: ${exampleDataClass.valueString} ${exampleDataClass.valueInt}"
                tvText2.text = "${getString(R.string.line)} 2: ${copy.valueString} ${copy.valueInt}"
                tvText3.text = makeCycle1Text()
                tvText4.text = makeCycle2Text()
            }
        }
    }

    private fun generateList(): MutableList<ExampleDataClass> {
        val list: MutableList<ExampleDataClass> = mutableListOf()
        return list.apply {
            add(ExampleDataClass("Apple", 73))
            add(ExampleDataClass("Lemon", 2))
            add(ExampleDataClass("Orange", 999))
            add(ExampleDataClass("Banana", 24))
            add(ExampleDataClass("Potato", 3))
            add(ExampleDataClass("Tomato", 37))
        }
    }

    private fun makeCycle1Text(): String {
        val list = generateList()
        var text = "${getString(R.string.line)} 3: "
        list.forEach {
            text = "$text${it.valueString} ${it.valueInt}\n"
        }
        return text
    }

    private fun makeCycle2Text(): String {
        val list = generateList()
        var text = "${getString(R.string.line)} 4: "
        for (exampleObject in list) {
            text = "$text${exampleObject.valueString} ${exampleObject.valueInt}\n"
        }
        return text
    }
}