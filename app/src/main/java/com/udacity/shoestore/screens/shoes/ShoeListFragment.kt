package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.LayoutShoeItemBinding
import com.udacity.shoestore.models.Shoe
//import com.udacity.shoestore.screens.shoeItem.ShoeEditorFragmentArgs
import kotlinx.android.synthetic.main.fragment_shoe_editor.*
import kotlinx.android.synthetic.main.fragment_shoe_list.*
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*
import kotlinx.android.synthetic.main.layout_shoe_item.*
import timber.log.Timber


class ShoeListFragment: Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container,false)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            it?.forEach { shoe ->
                val content =   " Shoe Name: ${shoe.name}" +
                                "\n Shoe Size: ${shoe.size}" +
                                "\n Shoe Company: ${shoe.company}" +
                                "\n Shoe Description: ${shoe.description}"

                val itemBinding : LayoutShoeItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.layout_shoe_item, binding.shoesLinearLayout, false)

                //set data binding variable
                itemBinding.shoeDetails = content

                //add to linear layout
                binding.shoesLinearLayout.addView(itemBinding.root)
            }
        })

        binding.fabAdd.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionToAddShoe())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_inventory)
        return binding.root
    }
}

