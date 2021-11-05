package com.example.r_android_template.view.fragments.homeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.r_android_template.R
import com.example.r_android_template.databinding.HomeFragmentBinding
import com.example.r_android_template.models.ServiceModel
import com.example.r_android_template.service.Service
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var serviceModel : ServiceModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    var clicked = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //get object from json file using returnserviceObject method
        serviceModel = Service.returnServiceObject()
        binding.serviceRecyclerView.adapter = HomeAdapter(serviceModel,
            // list item onclick method
            {
            viewModel.saveID(it.id!!)
        }, requireContext())
        // data with saved estateNo
        viewModel.idLiveData.observe(viewLifecycleOwner) {
            //if button was clicked then show toast on screen
            if (clicked) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.estate_number, serviceModel[it-1].estateNo), // it-1 because id starts with 1 and array index starts with 0
                    Toast.LENGTH_SHORT
                ).show()
                clicked = false
            }

        }
        setupOnClick()
    }

    //method to setup and handle button onClick
    fun setupOnClick() {
        binding.buttonShowEstate.setOnClickListener {
            clicked = true
            viewModel.getID()

        }
    }

}