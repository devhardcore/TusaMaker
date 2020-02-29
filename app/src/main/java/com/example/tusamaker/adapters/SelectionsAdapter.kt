package com.example.tusamaker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tusamaker.data.Selection
import com.example.tusamaker.R
import kotlinx.android.synthetic.main.recycler_collection.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class SelectionsAdapter(
    private val selections: ArrayList<Selection>,
    private val context: Context
) :
    RecyclerView.Adapter<SelectionsAdapter.ViewHolder>(), KoinComponent {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun getItemCount() = selections.size

    override fun onCreateViewHolder(view: ViewGroup, position: Int) = ViewHolder(
        LayoutInflater.from(view.context).inflate(
            R.layout.recycler_collection,
            view,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(selections[position])
        val childLayoutManager =
            LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = SelectionAdapter(selections[position].events, context)
            setRecycledViewPool(viewPool)
            holder.itemView.setOnClickListener {
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KoinComponent {

        private val ctx: Context by inject()
        private val title: TextView = itemView.titleOfSelection
        val recyclerView: RecyclerView = itemView.rv_child
        fun bind(selections: Selection) {
            SelectionAdapter(selections.events, ctx)
            title.text = selections.author
        }
    }
}