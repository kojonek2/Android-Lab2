package pl.pwr.adam.zmuda.catalog.mainActivity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.core.view.size
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import pl.pwr.adam.zmuda.catalog.R
import pl.pwr.adam.zmuda.catalog.data.Category

class CategoryDialog : DialogFragment() {

    private lateinit var categories : List<Category>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

            categories = viewModel.categories.value ?: throw IllegalStateException("Categories can't be null")
            val items = categories.map { c -> c.name }.toMutableList()
            items.add(resources.getString(R.string.favourites_name))

            builder.setTitle(resources.getString(R.string.filters_title))
            .setMultiChoiceItems(items.toTypedArray(), null,
                DialogInterface.OnMultiChoiceClickListener { _, which, isChecked ->
                    if (isChecked) {
                        if (which >= categories.size) { //favourite
                            setCategories(false)
                        }
                        else
                            setFavourite(false)
                    } else {
                        if (which >= categories.size) //favourite
                        {
                            setCategories(true)
                        }
                        else
                        {
                            if (selectedCategories().size <= 0)
                                setFavourite(true)
                        }

                    }
                })
            .setPositiveButton(resources.getString(R.string.filters_dialog_ok),
                DialogInterface.OnClickListener { _, _ ->
                    viewModel.setCategoriesSelected(selectedCategories())
                })
            .setNegativeButton(resources.getString(R.string.filters_dialog_cancel), DialogInterface.OnClickListener { _, _ -> })

             builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onStart() {
        super.onStart()

        val dialog = requireDialog() as AlertDialog
        val viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

        //set categories
        for (i in viewModel.categories.value!!.indices)
            dialog.listView.setItemChecked(i, viewModel.selectedCategories.contains(viewModel.categories.value!![i]))

        //set favourites
        dialog.listView.setItemChecked(viewModel.categories.value!!.size, viewModel.selectedCategories.isEmpty())
    }

    private fun selectedCategories() : MutableList<Category> {
        val result = mutableListOf<Category>()
        val alertDialog = requireDialog()  as AlertDialog

        for (i in categories.indices) {
            if (alertDialog.listView.isItemChecked(i))
                result.add(categories[i])
        }

        return result
    }

    private fun setFavourite(boolean: Boolean) {
        val alertDialog = requireDialog()  as AlertDialog
        alertDialog.listView.setItemChecked(alertDialog.listView.size - 1, boolean)
    }

    private fun setCategories(boolean: Boolean) {
        val alertDialog = requireDialog() as AlertDialog
        for (i in 0..alertDialog.listView.size - 2) //last one is favourites
            alertDialog.listView.setItemChecked(i, boolean)
    }
}