package pl.pwr.adam.zmuda.catalog.mainActivity

import pl.pwr.adam.zmuda.catalog.data.Train

interface OnTrainListElementInteractions {

    fun onFavouriteClicked(train: Train)

    fun onSwipeLeft(position: Int)

    fun onElementClicked(train: Train)

}