package com.example.mathup

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SubjectCardAdapter: RecyclerView.Adapter<SubjectCardAdapter.CardViewHolder> {
    private var mSubjectList: ArrayList<SubjectCard>
    private var context: Context
    class CardViewHolder: RecyclerView.ViewHolder {
        private var context:Context
        var mTitle: TextView
        var mText: TextView

        fun switchActivity() {
            var intent: Intent = Intent(context,SkillTreeActivity::class.java)
            context.startActivity(intent)
        }

        constructor(cardView: View, context: Context) : super(cardView) {
            cardView.setOnClickListener{switchActivity()}
            mTitle = cardView.findViewById(R.id.cardTitle)
            mText = cardView.findViewById(R.id.cardText)
            this.context = context
        }
    }

    constructor(subjectList: ArrayList<SubjectCard>, context: Context) {
        mSubjectList = subjectList
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewHolder {
        //todo rename var names
        var v = LayoutInflater.from(p0.getContext()).inflate(R.layout.subject_card, p0, false)
        var evh = CardViewHolder(v,context)
        return evh
    }

    override fun getItemCount(): Int {
        return mSubjectList.size
    }

    override fun onBindViewHolder(p0: CardViewHolder, p1: Int) {
        var currentItem = mSubjectList.get(p1)
        p0.mTitle.setText(currentItem.getTitle())
        p0.mText.setText(currentItem.getText())
    }
}