package com.example.mylyricsapp.extensions

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController


fun ImageView.animateImage(action: Int) {

    this.animate()?.apply {
        duration = 1000
        rotationXBy(360f)

    }?.withEndAction {
        findNavController().navigateWithAnimations(action)

    }?.start()
}

fun TextView.blinking() {
    val anim: Animation = AlphaAnimation(0.0f, 1.0f)

    anim.apply {
        duration = 500
        startOffset = 20
        repeatMode = Animation.REVERSE
        repeatCount = Animation.INFINITE
    }
    this.startAnimation(anim)
}

fun ImageView.duplicateSize() {

    this.layoutParams.height = this.height * 2
    this.layoutParams.width = this.width * 2
    this.requestLayout()
}

fun TextView.gone() {
    this.visibility = View.GONE
    this.requestLayout()
}