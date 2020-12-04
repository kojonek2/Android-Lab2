package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import pl.pwr.adam.zmuda.catalog.R
import pl.pwr.adam.zmuda.catalog.data.FakeDatabase
import pl.pwr.adam.zmuda.catalog.databinding.ActivityDetailsBinding

class DetailsActivity : FragmentActivity() {

    companion object {
        const val TRAIN_ID = "TRAIN_ID"
    }

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val trainName = intent.getStringExtra(TRAIN_ID)!!
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        viewModel.setTrain(FakeDatabase.TRAINS.first{ train -> train.name == trainName })

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ScreenSlidePagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> resources.getString(R.string.details_tab_title_description)
                1 -> resources.getString(R.string.details_tab_title_gallery)
                2 -> resources.getString(R.string.details_tab_title_numbers)
                else -> throw UnsupportedOperationException("TabLayoutMediator tab text not defined for position!")
            }
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> DetailsDescriptionFragment()
                1 -> DetailsGalleryFragment()
                2 -> DetailsNumbersFragment()
                else -> {
                    throw UnsupportedOperationException("ScreenSlidePagerAdapter fragment not defined for position!")
                }
            }
        }
    }
}