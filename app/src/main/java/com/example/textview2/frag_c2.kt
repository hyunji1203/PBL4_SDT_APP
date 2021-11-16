package com.example.textview2

import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class frag_c2 : Fragment() {
    lateinit var c_middle2 : TextView
    lateinit var c_measure2 : TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_frag_c2, container, false)

        c_middle2 = view.findViewById(R.id.c_middle)
        c_measure2 = view.findViewById(R.id.c_measure)

        val db = Firebase.firestore

        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", "가구2").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["measure"] as Number
                    var y = document["middle"] as Number
                    c_measure2.text = x.toString() + "kw"
                    c_middle2.text = "평균 " + y.toString() + "KW"
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}