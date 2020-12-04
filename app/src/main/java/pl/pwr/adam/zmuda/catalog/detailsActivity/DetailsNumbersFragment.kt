package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import pl.pwr.adam.zmuda.catalog.databinding.FragmentDetailsNumbersBinding

class DetailsNumbersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentDetailsNumbersBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(DetailsViewModel::class.java)

        binding.numberList.addItemDecoration(DividerItemDecoration(binding.numberList.context, DividerItemDecoration.VERTICAL))

        val adapter = NumbersAdapter(viewModel.train.value!!.trainNumbers)
        binding.numberList.adapter = adapter

        return binding.root
    }
}