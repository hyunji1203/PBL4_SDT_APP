package com.example.textview2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class c_report : AppCompatActivity() {

    lateinit var back2 : ImageView

    lateinit var week_report : TextView
    lateinit var month_report : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creport2)

        back2 = findViewById<ImageView>(R.id.back2)
        week_report = findViewById(R.id.week_report)
        month_report = findViewById(R.id.month_report)

        var name = intent.getStringExtra("name")

        val db = Firebase.firestore

        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", name).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["weekreport"] as String
                    var y = document["monthreport"] as String
                    week_report.text = x
                    month_report.text = y
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }

        //뒤로가기 버튼
        back2.setOnClickListener {
            finish()
        }
    }
}