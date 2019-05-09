package com.example.mathup

class subjectCard {
    //creating subjectCard class
    private var mTitle: String
    private var mText: String

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