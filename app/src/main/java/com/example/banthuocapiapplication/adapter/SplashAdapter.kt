package com.example.banthuocapiapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.model.Splash
import kotlinx.android.synthetic.main.item_splash.view.*
import org.w3c.dom.Text

class SplashAdapter(
    private val array: ArrayList<Splash>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SplashAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.img)
        val title = itemView.findViewById<TextView>(R.id.title_tv)
        val subTitle = itemView.findViewById<TextView>(R.id.sub_title_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_splash, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val splash = array[position]
        holder.img.setImageResource(splash.img)
        holder.title.text = splash.title
        holder.subTitle.text = splash.subTitle

//        if(position == array.size - 1) {
//            viewPager2.post {
//                array.addAll(array)
//                notifyDataSetChanged()
//            }
//
//        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}