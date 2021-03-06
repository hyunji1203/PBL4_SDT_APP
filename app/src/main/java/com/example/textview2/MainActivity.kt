package com.example.textview2

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    lateinit var btn_back : ImageView
    lateinit var btn_forward : ImageView

    lateinit var c_middle : TextView
    lateinit var c_measure : TextView

    lateinit var main_month : TextView
    lateinit var homebtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_back = findViewById(R.id.btn_back)
        btn_forward = findViewById(R.id.btn_forward)

        c_middle = findViewById(R.id.c_middle)
        c_measure = findViewById(R.id.c_measure)

        main_month = findViewById(R.id.main_month)
        homebtn = findViewById(R.id.homebtn)

        //다시 여기서부터 장학금 리스트 프래그먼트 관련 설정하기
        var n = 0
        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", "가구1").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["measure"] as Number
                    var y = document["middle"] as Number
                    c_measure.text = x.toString() + "kw"
                    c_middle.text = "평균 " + y.toString() + "KW"
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
//        setFrag(n)

        //화살표 버튼 클릭시 달별 장학금 화면을 넘겨주는 코드
        btn_forward.setOnClickListener {
            if(n == 0 || n == 1){
                n++
            }

            when (n) {
                0 -> {
                    //8월 장학금 리스트를 보여줌
                    main_month.text = "가구1"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구1").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(0)


                }
                1 -> {
                    //9월 장학금 리스트를 보여줌
                    main_month.text = "가구2"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구2").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(1)
                }
                2-> {
                    //10월 장학금 리스트를 보여줌
                    main_month.text = "가구3"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구3").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(2)
                }
            }
        }
        btn_back.setOnClickListener {
            if(n == 2 || n == 1 ){
                n--
            }


            when (n) {
                0 -> {
                    //8월 장학금 리스트를 보여줌
                    main_month.text = "가구1"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구1").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(0)
                }
                1 -> {
                    //9월 장학금 리스트를 보여줌
                    main_month.text = "가구2"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구2").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(1)
                }
                2-> {
                    //10월 장학금 리스트를 보여줌
                    main_month.text = "가구3"

                    //특정 데이터 값 갖고 오기!
                    db.collection("users").whereEqualTo("name", "가구3").get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                var x = document["measure"] as Number
                                var y = document["middle"] as Number
                                c_measure.text = x.toString() + "kw"
                                c_middle.text = "평균 " + y.toString() + "KW"
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }
                    //setFrag(2)
                }
            }
        }
        var test = 80


        for (i: Int in 1..10 step(1)){

            val Ref = db.collection("users").document("home1")

            // Set the "isCapital" field of the city 'DC'
            Ref
                .update("measure", test)
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }

            test += 5
        }



        main_month.setOnClickListener {
            var main_name = main_month.text

            var intent = Intent(this, c_detail::class.java)
            intent.putExtra("name",main_name)
            startActivity(intent)
        }

        homebtn.setOnClickListener {
            var intent = Intent(this, Realtimetest_activity::class.java)
            startActivity(intent)
        }

        /*var measure = ""

        //특정 데이터 값 갖고 오기!
        db.collection("users").whereEqualTo("name", main_name).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var x = document["measure"] as Number
                    measure = x.toString()
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }*/

        /*val db = Firebase.firestore

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        val user2 = hashMapOf(
            "first" to "Alan",
            "last" to "Turing",
            "born" to 1999
        )

        db.collection("users")
            .add(user2)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        db.collection("users").get().addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")

                user(document["born"] as Number, document["first"] as String, document["last"] as String)
                var y = document["first"] as String
                textView2.text = y
            }
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }

        db.collection("users").get().addOnSuccessListener { result ->

            for (document in result) {  // 가져온 문서들은 result에 들어감
                //val item = user(document["born"] as Int, document["first"] as String, document["last"] as String)
                var x = document["born"] as Number
                textView3.text = x.toString()
            }
        }.addOnFailureListener { exception ->
            // 실패할 경우
            Log.w(TAG, "Error getting documents.", exception)
        }*/
    }

//    //프래그먼트 넘기기
//    private fun setFrag(fragnum : Int) {
//        val ft = supportFragmentManager.beginTransaction()
//
//        when (fragnum) {
//            0 -> {
//                ft.replace(R.id.consume_frame, frag_c1()).commit()
//            }
//            1 -> {
//                ft.replace(R.id.consume_frame, frag_c2()).commit()
//            }
//            2 -> {
//                ft.replace(R.id.consume_frame, frag_c3()).commit()
//            }
//        }
//    }

}