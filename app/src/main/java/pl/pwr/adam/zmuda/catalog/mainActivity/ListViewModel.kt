package pl.pwr.adam.zmuda.catalog.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.pwr.adam.zmuda.catalog.data.Category
import pl.pwr.adam.zmuda.catalog.data.FakeDatabase
import pl.pwr.adam.zmuda.catalog.data.Train
import pl.pwr.adam.zmuda.catalog.utils.SingleLiveEvent
import pl.pwr.adam.zmuda.catalog.utils.TrainFavouritesSharedPreferencesUtils

class ListViewModel(application: Application) : AndroidViewModel(application), OnTrainListElementInteractions {

    private val context = application.applicationContext

    private val _trains = MutableLiveData<MutableList<Train>>()
    val trains: LiveData<MutableList<Train>> get() { return _trains }

    private val internalTrains: MutableList<Train> = FakeDatabase.TRAINS.toMutableList()

    private val _startDetailsActivityEvent = SingleLiveEvent<Train>()
    val startDetailsActivityEvent: LiveData<Train> get() { return _startDetailsActivityEvent }

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() { return _categories }

    val selectedCategories: List<Category> get() { return _selectedCategories }
    private var _selectedCategories = FakeDatabase.CATEGORIES

    init {
        val favourites = TrainFavouritesSharedPreferencesUtils.loadFavourites(context)
        internalTrains.forEach {
            if (favourites.contains(it.name))
                it.favourite = true
        }

        _categories.value = FakeDatabase.CATEGORIES

        notifyTrainObservers()
    }

    //Used to create copies of trains to allow detecting changes
    private fun notifyTrainObservers() {
        val listCopy = mutableListOf<Train>()
        internalTrains.forEach {
            if (_selectedCategories.isEmpty()) { //show favourites
                if (it.favourite)
                    listCopy.add(Train(it))
            }
            else {
                if (_selectedCategories.contains(it.category))
                    listCopy.add(Train(it))
            }
        }

        _trains.value = listCopy
    }

    override fun onFavouriteClicked(train: Train) {
        val index = internalTrains.indexOf(train)
        if (index < 0)
            return

        internalTrains[index].favourite = !internalTrains[index].favourite
        saveFavourites()

        notifyTrainObservers()
    }

    //Empty list means to show favourites
    fun setCategoriesSelected(selectedCategories: List<Category>) {
        this._selectedCategories = selectedCategories
        notifyTrainObservers()
    }

    override fun onSwipeLeft(position: Int) {
        val train = _trains.value!![position]
        internalTrains.remove(train)
        saveFavourites() //if train was in favourites then it needs to be removed 

        notifyTrainObservers()
    }

    override fun onElementClicked(train: Train) {
        _startDetailsActivityEvent.value = train
    }

    private fun saveFavourites() {
        val favourites = internalTrains.filter { t -> t.favourite }.map{t -> t.name}.toSet()
        TrainFavouritesSharedPreferencesUtils.saveFavourites(context, favourites)
    }

}