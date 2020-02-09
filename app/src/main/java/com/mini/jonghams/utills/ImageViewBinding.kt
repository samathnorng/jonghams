package com.mini.jonghams.utills

import android.widget.ImageView
import com.mini.jonghams.R
import com.squareup.picasso.Picasso

fun ImageView.loadSrc(url: String) {
    if (url.isEmpty()) return

    Picasso.get().load(url).fit().centerCrop()
        .placeholder(R.drawable.ic_no_image)
        .into(this)
}