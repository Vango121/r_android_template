package com.example.r_android_template.view.fragments.homeFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.r_android_template.R
import com.example.r_android_template.databinding.ServiceItemBinding
import com.example.r_android_template.models.ServiceModel
import com.example.r_android_template.models.ServiceModelItem
import dagger.hilt.android.qualifiers.ApplicationContext

class HomeAdapter(
    private val serviceModels: ServiceModel,
    private val onClick: (ServiceModelItem) -> Unit,
    @ApplicationContext private val context: Context
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            //set OnCLickListener and send data with function
            binding.root.setOnClickListener {
                onClick(serviceModels[adapterPosition])
            }
        }

        private val textViewEstateNumber = binding.textViewEstateNumber
        private val textViewLand = binding.textViewLand
        private val textViewArea = binding.textViewArea
        private val textViewdistrict = binding.textViewdistrict
        fun bind() {
            val res = context.resources
            textViewEstateNumber.text = res.getString(
                R.string.estate_number,
                serviceModels[adapterPosition].estateNo
            )
            textViewLand.text = res.getString(
                R.string.land,
                serviceModels[adapterPosition].land
            )
            textViewArea.text = res.getString(
                R.string.area,
                serviceModels[adapterPosition].area
            )
            textViewdistrict.text = serviceModels[adapterPosition].district
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ServiceItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = serviceModels.size
}
