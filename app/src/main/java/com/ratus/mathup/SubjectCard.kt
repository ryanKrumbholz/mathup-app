package com.ratus.mathup

class SubjectCard {
    //creating SubjectCard class
    private var mTitle: String
    private var mText: String
    private var mSkills: Array<String>

    constructor(mTitle: String, mText: String, mSkills: Array<String>) {
        this.mTitle = mTitle
        this.mText = mText
        this.mSkills =  mSkills
    }

    constructor(mCard: SubjectCard) {
        this.mTitle = mCard.getTitle()
        this.mText = mCard.getText()
        this.mSkills = mCard.getSkills()
    }

    constructor(mTitle: String, mText: String) {
        this.mTitle = mTitle
        this.mText = mText
        this.mSkills =  arrayOf()
    }

    fun getTitle(): String {
        return this.mTitle
    }

    fun getText(): String {
        return this.mText
    }

    fun getSkills(): Array<String> {
        return this.mSkills
    }

}