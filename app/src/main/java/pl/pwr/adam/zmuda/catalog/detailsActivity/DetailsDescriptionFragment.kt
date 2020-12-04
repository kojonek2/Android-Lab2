package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pl.pwr.adam.zmuda.catalog.databinding.FragmentDetailsDescriptionBinding

class DetailsDescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentDetailsDescriptionBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(DetailsViewModel::class.java)

        viewModel.train.observe(viewLifecycleOwner, Observer { train ->
            binding.textView.text = resources.getString(train.description)
        })

        return binding.root
    }

}