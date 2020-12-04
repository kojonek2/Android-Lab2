package pl.pwr.adam.zmuda.catalog.detailsActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.pwr.adam.zmuda.catalog.data.Train

class DetailsViewModel : ViewModel() {
    private val _train = MutableLiveData<Train>()
    val train: LiveData<Train> get() { return _train }

    fun setTrain(train: Train) {
        _train.value = train
    }
}