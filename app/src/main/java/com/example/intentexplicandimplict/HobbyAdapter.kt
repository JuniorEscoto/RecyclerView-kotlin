package com.example.intentexplicandimplict

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class HobbyAdapter(
    val context: Context,
    val hobbies: List<Hooby>
) : RecyclerView.Adapter<HobbyAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var currentHooby: Hooby? = null
        var currentPosition:Int = 0

        // click en cada item
        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHooby!!.tile + "cliked " + currentPosition, Toast.LENGTH_SHORT).show()
            }

            itemView.imgShare.setOnClickListener {
                val intent = Intent()
                val message: String = "my hobby is "+ currentHooby!!.tile
                intent.action = Intent.ACTION_SEND

                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent,"compartir con"))
            }
        }

        fun setData(hobby: Hooby?, pos:Int){
            itemView.txvTitle.text = hobby!!.tile
            this.currentHooby = hobby
            this.currentPosition = pos
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false)
        return  MyViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}