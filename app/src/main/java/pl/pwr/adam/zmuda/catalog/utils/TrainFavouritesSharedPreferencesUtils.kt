package pl.pwr.adam.zmuda.catalog.utils

import android.content.Context

object TrainFavouritesSharedPreferencesUtils {

    private const val SHARED_PREF_KEY = "Catalog_key"
    private const val TRAIN_FAVOURITES = "TRAIN_FAVOURITES"

    fun loadFavourites(context: Context): Set<String> {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet(TRAIN_FAVOURITES, setOf<String>()) ?: setOf()
    }

    fun saveFavourites(context: Context, set: Set<String>) {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        with (sharedPreferences.edit()) {
            putStringSet(TRAIN_FAVOURITES, set)
            apply()
        }
    }
}