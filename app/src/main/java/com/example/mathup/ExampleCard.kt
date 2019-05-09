package com.example.mathup

import android.content.Context
import android.support.v7.widget.CardView
import android.view.View

class ExampleCard {
    private var mTitle: String
    private var mText: String
    lateinit private var newView: View

    constructor(mTitle: String, mText: String) {
        this.mTitle = mTitle
        this.mText = mText
    }

    fun getTitle(): String {
        return this.mTitle
    }

    fun getText(): String {
        return this.mText
    }

}