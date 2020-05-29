package com.kotlin.inserverview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.core.view.postDelayed

/**
 * 服务器计价器View
 *
 * @author songdehuai
 * @version 0.1
 */
class InServiceView1 : LinearLayout {

    constructor(context: Context?) : super(context) {
        initViews()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        initViews()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        initViews()
    }


    var fenceStatus = false
        set(value) {
            if (value) {
                inner()
            } else {
                outer()
            }
            field = value
        }


    private val innerView by lazy { findViewById<View>(R.id.inner_v) }
    private val outerView by lazy { findViewById<View>(R.id.outer_v) }

    private fun initViews() {
        inflate(context, R.layout.view_inservice1, this)

    }


    private fun inner() {

        val innerAnim = AnimationUtils.loadAnimation(context, R.anim.expand_up)
        innerView.animation = innerAnim
        innerView.visibility = View.VISIBLE


        val outerAnim = AnimationUtils.loadAnimation(context, R.anim.closed_down)
        outerView.animation = outerAnim
        outerView.visibility = View.GONE

    }

    private fun outer() {

        val outerAnim = AnimationUtils.loadAnimation(context, R.anim.expand_up)
        outerView.animation = outerAnim
        outerView.visibility = View.VISIBLE

        val innerAnim = AnimationUtils.loadAnimation(context, R.anim.closed_down)
        innerView.animation = innerAnim
        innerView.visibility = View.GONE

    }
}