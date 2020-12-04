package pl.pwr.adam.zmuda.catalog.mainActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.adam.zmuda.catalog.data.Train
import pl.pwr.adam.zmuda.catalog.databinding.ListElementBinding
import pl.pwr.adam.zmuda.catalog.utils.TrainDiffCallback

class ListAdapter(private val interactionsListener: OnTrainListElementInteractions) : RecyclerView.Adapter<ListViewHolder>() {

    private var trains: List<Train> = emptyList()

    fun setData(data: List<Train>) {
        val diffResult = DiffUtil.calculateDiff(TrainDiffCallback(trains, data))
        trains = data
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListElementBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding, interactionsListener)
    }

    override fun getItemCount(): Int {
        return trains.count()
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(trains[position])
    }
}