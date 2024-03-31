package dev.whysoezzy.currencyapp.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.whysoezzy.currencyapp.R
import dev.whysoezzy.currencyapp.data.entity.ValutesDTO

class MainAdapter(
    private var mList: List<ValutesDTO>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_main_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val currency = mList[position]
        holder.currency.text = "${currency.Nominal} ${currency.CharCode}"
        holder.value.text = "${currency.Value} RUB"
    }

    override fun getItemCount(): Int = mList.size

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val value: TextView = itemView.findViewById(R.id.value)
        val currency: TextView = itemView.findViewById(R.id.currency)

    }
}