package com.rogelio.prueba_camerax.app.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.rogelio.core.domain.models.UsersDataDTO
import com.rogelio.prueba_camerax.databinding.SeeUserInfoDialogFragmentBinding

class DialogFragmentInfoUsers: DialogFragment() {

    private lateinit var binding: SeeUserInfoDialogFragmentBinding

    companion object {
        private const val ARG_USERS_DATA = "usersData"

        fun newInstance(usersData: UsersDataDTO): DialogFragmentInfoUsers {
            val fragment = DialogFragmentInfoUsers()
            val args = Bundle().apply {
                putParcelable(ARG_USERS_DATA, usersData)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SeeUserInfoDialogFragmentBinding.inflate(inflater, container, false)

        val usersData = arguments?.getParcelable<UsersDataDTO>(ARG_USERS_DATA)
        usersData?.let {
            // Set the values of the views in the dialog fragment based on the usersData object
            binding.seeStreetTextView.text = it.calle
            binding.seeNumberTextView.text = it.numero
            binding.seeColonyTextView.text = it.colonia
            binding.seeTownTextView.text = it.delegacion
            binding.seeStateTextView.text = it.estado
            binding.seeCpTextView.text = it.cp
            // Use Glide or another library to load the image from the `imagen` URL into the `imagenImageView`
        }

        binding.seeCloseInfoButton.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

}