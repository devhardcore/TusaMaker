package com.example.omskalive.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omskalive.Data.Event
import com.example.omskalive.Data.Questions
import com.example.omskalive.R
import kotlinx.android.synthetic.main.card_event.view.*
import kotlinx.android.synthetic.main.question_layout.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddEventAdapter(private val questions: ArrayList<Questions>, private val context: Context) :
    RecyclerView.Adapter<AddEventAdapter.ViewHolder>(), KoinComponent {

    override fun getItemCount() = questions.size

    override fun onCreateViewHolder(view: ViewGroup, position: Int) = ViewHolder(
        LayoutInflater.from(view.context).inflate(
            R.layout.question_layout,
            view,
            false
        )
    )

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        view.bind(
            questions[position].question, questions[position].answer
        )
        view.itemView.setOnClickListener {
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KoinComponent {
        private val questionTitle: TextView? = itemView.questionName
        private val inputAnswer: EditText? = itemView.answerInputText
        private val ctx: Context by inject()

        fun bind(question: String, answer: String) {
            questionTitle?.text = question
            inputAnswer?.hint = answer

        }
    }
}