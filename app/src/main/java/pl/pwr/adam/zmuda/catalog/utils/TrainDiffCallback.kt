package pl.pwr.adam.zmuda.catalog.utils

import androidx.recyclerview.widget.DiffUtil
import pl.pwr.adam.zmuda.catalog.data.Train

class TrainDiffCallback(private val oldList: List<Train>, private val newList: List<Train>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]

        return old.favourite == new.favourite
    }
}