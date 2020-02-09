package com.mini.jonghams.model

class SliderItem {
    var imageId: Int
        internal set
    var imageDrawable: Int
        internal set

    constructor(id: Int, drawable: Int) {
        this.imageId = id
        this.imageDrawable = drawable
    }
}