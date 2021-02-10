package com.udacity.shoestore.screens.shoeItem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeEditorBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoes.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_editor.*
import kotlinx.android.synthetic.main.layout_shoe_item.*
import timber.log.Timber
import java.lang.Integer.parseInt

class ShoeEditorFragment : Fragment() {

    private lateinit var binding: FragmentShoeEditorBinding
    private val shoeViewModel : ShoeViewModel by activityViewModels()
    private var shoe : Shoe = Shoe("", 0, "", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_editor, container, false)
        binding.shoe = shoe


        // add onclick functionality to the cancel and add shoe buttons
        binding.buttonCancel.setOnClickListener {v : View ->
            v.findNavController().navigate(R.id.actionReturnToList)
        }
        binding.buttonAdd.setOnClickListener {

            val etName = binding.editTextShoeName.text.toString()
            val etSize = binding.editTextShoeSize.text.toString()
            val etCompany = binding.editTextShoeCompany.text.toString()
            val etDescription = binding.editTextShoeDescription.text.toString()

            if (etName.isNullOrBlank() || etSize.isNullOrBlank() || etCompany.isNullOrBlank() || etDescription.isNullOrBlank()) {
                Toast.makeText(context,"Please fill in all the boxes", Toast.LENGTH_SHORT).show()
            } else {
                shoeViewModel.addShoeItem(shoe)
                findNavController().navigate( ShoeEditorFragmentDirections.actionReturnToList())
            }
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.add_new_shoe)
        return binding.root
    }
}