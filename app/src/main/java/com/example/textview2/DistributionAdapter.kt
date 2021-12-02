package com.example.textview2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DistributionAdapter (private val context: Context): RecyclerView.Adapter<DistributionAdapter.CustomViewHolder>() {

    var send_name = ""

    private var userList = mutableListOf<Data>()

    fun setListData(data:MutableList<Data>){
        userList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistributionAdapter.CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_shape, parent, false)

        CustomViewHolder(view).apply {

            itemView.setOnClickListener {
//                val curPos : Int = adapterPosition
//                val user : Data = userList.get(curPos)
//                var name = user.name

//                var user : Data
//                var name = ""
//
//                val pos = adapterPosition
//                if (pos != RecyclerView.NO_POSITION) {
//                    user = userList[pos]
//                    name = user.name
//                }


                var intent = Intent(view.context, distributionNextpgActivity::class.java)
                intent.putExtra("name", send_name)
                view.context.startActivity(intent)
            }
        }

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: DistributionAdapter.CustomViewHolder, position: Int) {
        val user : Data = userList[position]

        holder.name.text = user.name

        send_name = user.name
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.dis_name)
    }

}