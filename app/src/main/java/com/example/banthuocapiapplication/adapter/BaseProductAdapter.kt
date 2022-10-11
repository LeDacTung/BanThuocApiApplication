package com.example.banthuocapiapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.model.Product
import com.example.banthuocapiapplication.util.ImageUtils
import com.makeramen.roundedimageview.RoundedImageView

class BaseProductAdapter(
    val mContext: Context
) : RecyclerView.Adapter<BaseProductAdapter.ViewHolder>() {

    var mProducts : MutableList<Product> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImgIv = itemView.findViewById<RoundedImageView>(R.id.img_iv)
        val mTitleTv = itemView.findViewById<TextView>(R.id.title_tv)
        val mDescriptionTv = itemView.findViewById<TextView>(R.id.description_tv)
        val mAmountTv = itemView.findViewById<TextView>(R.id.amount_tv)

    }

    fun addProducts(products: MutableList<Product>){
        mProducts.addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_base_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = mProducts[position]
        ImageUtils.loadImage(holder.mImgIv, product.getImage(), mContext)
        holder.mTitleTv.text = product.getName()
        holder.mDescriptionTv.text = product.getDescription()
        holder.mAmountTv.text = product.getAmount().toString() + " vnđ"
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }
}