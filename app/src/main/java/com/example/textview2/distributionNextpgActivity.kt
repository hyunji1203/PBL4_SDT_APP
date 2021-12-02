package com.example.textview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.eazegraph.lib.charts.BarChart
import org.eazegraph.lib.models.BarModel

class distributionNextpgActivity : AppCompatActivity() {
    lateinit var cancelBtn : Button
    lateinit var page_name : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distribution_nextpg)

        cancelBtn = findViewById(R.id.cancelBtn)
        page_name = findViewById(R.id.page_name)

        var name = intent.getStringExtra("name")

        page_name.text = name

        var chart2: BarChart

        chart2=findViewById(R.id.bar)

        chart2.clearChart()

        chart2.addBar(BarModel("월",71f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("화",50f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("수",64f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("목",80f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("금",20f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("토",43f,0xFFE6E6A6.toInt()))
        chart2.addBar(BarModel("일",100f,0xFFE6E6A6.toInt()))

        chart2.startAnimation()

//        button.setOnClickListener{
//            val intent = Intent(this, drag::class.java)
//            startActivity(intent)
//            Toast.makeText(getApplicationContext(),w.getText(), Toast.LENGTH_SHORT).show();
//        }

        cancelBtn.setOnClickListener{
            finish()
        }
    }
}