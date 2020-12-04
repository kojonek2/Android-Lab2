package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.adam.zmuda.catalog.data.TrainNumber
import pl.pwr.adam.zmuda.catalog.databinding.NumbersElementBinding

class NumbersAdapter(private val trainNumbers: List<TrainNumber>) : RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {

    class NumbersViewHolder(private val binding: NumbersElementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trainNumber: TrainNumber) {
            binding.apply {
                numberTV.text = trainNumber.number
                uicIdTV.text = trainNumber.UICIdentification
                carrierTV.text = trainNumber.carrier
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NumbersElementBinding.inflate(layoutInflater, parent, false)
        return NumbersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return trainNumbers.size
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bind(trainNumbers[position])
    }
}