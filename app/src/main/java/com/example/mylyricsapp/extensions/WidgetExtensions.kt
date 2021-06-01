package com.example.mylyricsapp.extensions

import android.widget.ImageView

fun ImageView.animeImage() {

    this.animate()?.apply {
        duration = 1000
        rotationXBy(360f)
    }?.start()
}