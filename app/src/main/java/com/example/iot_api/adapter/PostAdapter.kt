package com.example.iot_api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iot_api.R
import com.example.iot_api.activity.MainActivity
import com.example.iot_api.databinding.CardPostBinding
import com.example.iot_api.model.PostItem

class PostAdapter(mainActivity: MainActivity) :RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var myList= emptyList<PostItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        binding.imageView
//        binding.tvId.text=myList[position].id.toString()
//        binding.tvName.text=myList[position].name
//        binding.tvPrice.text=myList[position].price
//        binding.tvDescription.text=myList[position].description
        holder.bind(myList[position])
    }
    fun setData(newList:List<PostItem>){
        myList=newList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return myList.size
    }

    class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(postItem: PostItem){
            val image: ImageView= itemView.findViewById(R.id.imageView)
            val tvId: TextView= itemView.findViewById(R.id.tvId)
            val tvName:TextView=itemView.findViewById(R.id.tvName)
            val tvDescription:TextView=itemView.findViewById(R.id.tvDescription)
        }
    }



}

