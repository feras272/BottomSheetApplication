package com.ferasdev.bottomsheetapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView


class ScaleItemAdapter(private var mList:ArrayList<ScaleItem>):
    RecyclerView.Adapter<ScaleItemAdapter.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scale_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.item.text = item.titleProperty

        val isVisible: Boolean = item.propertyVisibility
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
        holder.img.setOnClickListener {
//            // Create an animation instance
//            // Create an animation instance
//            val an: Animation = RotateAnimation(0.0f, 360.0f, pivotX.toFloat(), pivotY.toFloat())

//            // Set the animation's parameters
//
//            // Set the animation's parameters
//            an.duration = 1000 // duration in ms
//
//            an.repeatCount = 0 // -1 = infinite repeated
//
//            an.repeatMode = Animation.REVERSE // reverses each repeat
//
//            an.fillAfter = true // keep rotation after animation
//
//
//            // Aply animation to image view
//
//            // Aply animation to image view
//
//            it.animation = an

//            it.animate().rotationBy(360f).setDuration(3000).setInterpolator(new LinearInterpolator()).start();

            //it.animate().rotationBy(180f).setDuration(500).start()
            
            setAnimation(it, position)
            item.propertyVisibility = !item.propertyVisibility
//            it.rotation = 180f


            notifyItemChanged(position)

        }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
//            val animation: Animation =
//                AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
//            viewToAnimate.startAnimation(animation)
            viewToAnimate.animate().rotationBy(180f).setDuration(500).start()
            lastPosition = position
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val item:TextView = itemView.findViewById(R.id.actv_scale_list_item)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.cl_expandable_scale_list_item)
        val content: TextView = itemView.findViewById(R.id.tv_nested_scale_list_item)
        val img: AppCompatImageView = itemView.findViewById(R.id.acimg_scale_list_item)
    }

}