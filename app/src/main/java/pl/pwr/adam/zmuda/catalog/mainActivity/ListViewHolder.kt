package pl.pwr.adam.zmuda.catalog.mainActivity

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.adam.zmuda.catalog.R
import pl.pwr.adam.zmuda.catalog.data.Train
import pl.pwr.adam.zmuda.catalog.databinding.ListElementBinding

class ListViewHolder(private val binding: ListElementBinding, private val interactionsListener: OnTrainListElementInteractions) : RecyclerView.ViewHolder(binding.root) {

    fun bind(train: Train) {
        binding.apply {
            elementPicture.setImageResource(train.picture)
            elementTitle.text = train.name
            elementCategoryImage.setImageResource(train.category.icon)

            val colorID =  if (train.favourite) R.color.favourite_enabled_colour else R.color.favourite_disabled_colour
            elementFavourite.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, colorID))

            elementFavourite.setOnClickListener { interactionsListener.onFavouriteClicked(train) }
            root.setOnClickListener { interactionsListener.onElementClicked(train) }
        }
    }
}