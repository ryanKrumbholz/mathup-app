package com.example.mathup

import android.content.Context
import android.content.Intent
import android.support.v7.widget.ActivityChooserView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ExampleAdapter: RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private var mExampleList: ArrayList<ExampleCard>
    lateinit private var context:Context
    class ExampleViewHolder: RecyclerView.ViewHolder {
        lateinit private var context:Context
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

    constructor(exampleList: ArrayList<ExampleCard>, context: Context) {
        mExampleList = exampleList
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ExampleViewHolder {
        var v = LayoutInflater.from(p0.getContext()).inflate(R.layout.example_card, p0, false)
        var evh = ExampleViewHolder(v,context)
        return evh
    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }

    override fun onBindViewHolder(p0: ExampleViewHolder, p1: Int) {
        var currentItem = mExampleList.get(p1)
        p0.mTitle.setText(currentItem.getTitle())
        p0.mText.setText(currentItem.getText())
    }
}