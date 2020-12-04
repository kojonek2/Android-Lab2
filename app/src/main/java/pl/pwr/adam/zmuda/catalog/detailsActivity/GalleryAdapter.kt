package pl.pwr.adam.zmuda.catalog.detailsActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.adam.zmuda.catalog.databinding.GalleryElementBinding

class GalleryAdapter(private val imageIds: List<Int>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    class GalleryViewHolder(private val binding: GalleryElementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pictureId: Int) {
            binding.apply {
                elementPicture.setImageResource(pictureId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GalleryElementBinding.inflate(layoutInflater, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageIds.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(imageIds[position])
    }
}