package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.pwr.adam.zmuda.catalog.databinding.FragmentDetailsGalleryBinding

class DetailsGalleryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentDetailsGalleryBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(DetailsViewModel::class.java)

        val adapter = GalleryAdapter(viewModel.train.value!!.galleryPictures)
        binding.imageList.adapter = adapter

        return binding.root
    }
}