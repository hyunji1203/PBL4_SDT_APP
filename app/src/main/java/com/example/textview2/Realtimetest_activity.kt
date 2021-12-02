package com.example.textview2

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Realtimetest_activity : AppCompatActivity() {

    private lateinit var adapter : DistributionAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(ListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realtimetest)

//        val database = Firebase.database
//        val myRef = database.getReference("user1").child("measure")

        adapter = DistributionAdapter(this)

        val recyclerView : RecyclerView = findViewById(R.id.recy)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observerData()

    }

    fun observerData(){
        viewModel.fetchData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })



//        //myRef.setValue("85")
//
//        //리얼타임 데이터베이스 읽기
//        myRef.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(datasnapshot: DataSnapshot) {
//
//                val value = datasnapshot?.value
//                realtime.text = value.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.w(TAG, "Failed to read value.", error.toException())
//            }
//
//        })
    }
}