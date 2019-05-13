package com.example.imageslider

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image_item.view.*

class ImageAdapter : PagerAdapter() {
    val imageList = arrayListOf(R.drawable.doge1, R.drawable.doge2, R.drawable.doge3, R.drawable.doge4, R.drawable.doge5)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
        println("********")

    }



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.image_item, container, false)
        val imageView = view.iv_image
        Glide.with(container.context).load(imageList[position]).into(imageView)
        container.addView(view)
        return view
    }


}