package pl.pwr.adam.zmuda.catalog.mainActivity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.adam.zmuda.catalog.R
import pl.pwr.adam.zmuda.catalog.databinding.ActivityMainBinding
import pl.pwr.adam.zmuda.catalog.detailsActivity.DetailsActivity


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ListViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        binding.elementList.addItemDecoration(DividerItemDecoration(binding.elementList.context, DividerItemDecoration.VERTICAL))

        adapter = ListAdapter(viewModel)
        binding.elementList.adapter = adapter

        initializeObservers()
        initializeSwiping()
    }

    private fun initializeObservers() {
        viewModel.trains.observe(this, Observer { trains ->
            adapter.setData(trains)
        })

        viewModel.startDetailsActivityEvent.observe(this, Observer { train ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.TRAIN_ID, train.name)

            startActivity(intent)
        })
    }

    private fun onFiltersClicked() {
        val dialog = CategoryDialog()
        dialog.show(supportFragmentManager, "categories")
    }

    private fun initializeSwiping() {
        val touchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.onSwipeLeft(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.elementList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_filters -> {
                onFiltersClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}