package com.kotlin.inserverview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout

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

        innerExpandView.visibility = View.VISIBLE
        innerClosedView.visibility = View.GONE

        outerExpandView.visibility = View.GONE
        outerClosedView.visibility = View.VISIBLE

    }

    private fun outer() {
        innerExpandView.visibility = View.GONE
        innerClosedView.visibility = View.VISIBLE

        outerExpandView.visibility = View.VISIBLE
        outerClosedView.visibility = View.GONE
    }
}