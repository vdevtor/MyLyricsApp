package com.example.mylyricsapp.extensions

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Build
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController


fun ImageView.animateImage(action: Int) {

    this.animate()?.apply {
        duration = 1000
        rotationXBy(360f)

    }?.withEndAction {
        findNavController().navigateWithAnimations(action)

    }
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

fun ImageView.moveBackFoward() {

    val animator = ObjectAnimator.ofFloat(this, "translationX", 0f, 100f)

    animator.apply {
        duration = 3000
        repeatMode = ValueAnimator.REVERSE
        repeatCount = ValueAnimator.INFINITE
        interpolator = BounceInterpolator()
        start()
    }
}

fun ImageView.moveDownUp() {
    val animator = ObjectAnimator.ofFloat(this, "translationY", 0f, 50f)

    animator.apply {
        duration = 3000
        repeatMode = ValueAnimator.REVERSE
        interpolator = BounceInterpolator()
        repeatCount = ValueAnimator.INFINITE
        start()
    }
}

fun ImageView.coinRotate() {
    val animator = ObjectAnimator.ofFloat(this, "rotationY", 180f)
    animator.apply {
        duration = 3000
        repeatMode = ValueAnimator.REVERSE
        repeatCount = ValueAnimator.INFINITE
        start()
    }

}


fun ImageView.slideUp(action: Int) {

    this.animate().apply {
        duration = 1200
        translationX(600f)
        rotationYBy(180f)
    }.withEndAction {
        findNavController().navigateWithAnimations(action)
    }
}