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
class InServiceView : LinearLayout {

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


    private val innerExpandView by lazy { findViewById<View>(R.id.inner_expand_v) }
    private val innerClosedView by lazy { findViewById<View>(R.id.inner_closed_v) }
    private val outerExpandView by lazy { findViewById<View>(R.id.outer_expand_v) }
    private val outerClosedView by lazy { findViewById<View>(R.id.outer_closed_v) }

    private fun initViews() {
        inflate(context, R.layout.view_inservice, this)

    }


    private fun inner() {

        val innerExpandAnim = AnimationUtils.loadAnimation(context, R.anim.expand_up)
        innerExpandView.animation = innerExpandAnim
        innerExpandView.visibility = View.VISIBLE

        val outerClosedAnim = AnimationUtils.loadAnimation(context, R.anim.expand_down)
        outerClosedView.animation = outerClosedAnim
        outerClosedView.visibility = View.VISIBLE


        val innerClosedAnim = AnimationUtils.loadAnimation(context, R.anim.closed_down)
        innerClosedView.animation = innerClosedAnim
        innerClosedView.visibility = View.GONE


        val outerExpandAnim = AnimationUtils.loadAnimation(context, R.anim.closed_up)
        outerExpandView.animation = outerExpandAnim
        outerExpandView.visibility = View.GONE
    }

    private fun outer() {
        val innerExpandAmin = AnimationUtils.loadAnimation(context, R.anim.closed_up)
        innerExpandView.animation = innerExpandAmin
        innerExpandView.visibility = View.GONE

        val innerClosedAnim = AnimationUtils.loadAnimation(context, R.anim.expand_up)
        innerClosedView.animation = innerClosedAnim
        innerClosedView.visibility = View.VISIBLE

        val outerExpandAnim = AnimationUtils.loadAnimation(context, R.anim.expand_down)
        outerExpandView.animation = outerExpandAnim
        outerExpandView.visibility = View.VISIBLE

        val outerClosedAmin = AnimationUtils.loadAnimation(context, R.anim.closed_down)
        outerClosedView.animation = outerClosedAmin
        outerClosedView.visibility = View.GONE
    }
}