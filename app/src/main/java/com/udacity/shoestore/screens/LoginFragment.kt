package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

            binding.buttonLogin.setOnClickListener {
                val inputUsername = binding.username.text.toString()
                val inputPassword = binding.password.text.toString()

                if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(context,"Username or password fields cannot be empty", Toast.LENGTH_SHORT).show()
                } else {
                    NavHostFragment.findNavController(this).navigate(LoginFragmentDirections.actionLoginToWelcome())
                }
            }

            binding.buttonRegister.setOnClickListener {
                val inputUsername = binding.username.text.toString()
                val inputPassword = binding.password.text.toString()

                if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(context,"Username or password fields cannot be empty", Toast.LENGTH_SHORT).show()
                } else {
                    NavHostFragment.findNavController(this).navigate(LoginFragmentDirections.actionLoginToWelcome())
                }
            }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login)
        setHasOptionsMenu(true)
        return binding.root
    }
}