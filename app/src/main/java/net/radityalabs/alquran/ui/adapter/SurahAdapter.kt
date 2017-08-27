package net.radityalabs.alquran.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.radityalabs.alquran.R
import net.radityalabs.alquran.ui.adapter.viewholder.SurahViewHolder
import net.radityalabs.alquran.ui.model.SurahData

class SurahAdapter : RecyclerView.Adapter<SurahViewHolder>() {
    companion object {
        val TAG = SurahAdapter::class.java.simpleName
    }

    private var list: MutableList<SurahData> = mutableListOf()

    fun setNotifyDataChanges(newList: List<SurahData>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            SurahViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_surah, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            number.text = item.number.toString()
            arabicName.text = item.name
            englishName.text = item.englishName
        }
    }
}