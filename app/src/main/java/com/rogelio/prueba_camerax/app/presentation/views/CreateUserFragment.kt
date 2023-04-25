package com.rogelio.prueba_camerax.app.presentation.views

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.rogelio.core.domain.models.UsersFieldsRequestDTO
import com.rogelio.core.util.ValidatorFields
import com.rogelio.prueba_camerax.app.presentation.viewmodels.MainActivityViewModel
import com.rogelio.prueba_camerax.databinding.FragmentCreateUserBinding

class CreateUserFragment : Fragment() {

    private var _binding: FragmentCreateUserBinding? = null
    private val binding get() = _binding!!

    private val fragmentViewModel by activityViewModels<MainActivityViewModel>()
    private lateinit var validator: ValidatorFields
    private lateinit var usersData: UsersFieldsRequestDTO

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCreateUserBinding.inflate(inflater, container, false)
        usersData = UsersFieldsRequestDTO()
        validator = ValidatorFields()
        binding.takePhotoButton.setOnClickListener {
            checkCameraPermission()
        }
        return binding.root
    }

    fun validateEmailandDate(): Boolean{
        return validator.isValidEmail(binding.editTextEmail.text.toString()) &&
                validator.isValidDate(binding.editTextFechaNacimiento.text.toString())
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission()
        } else {
            if(validateEmailandDate()){
                saveData()
                goToTakePhotoFragment()
            } else {
                Toast.makeText(requireContext(), "Verifica el formato de la fecha de nacimiento o email.", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun goToTakePhotoFragment() {
        val fragment = TakePhotoFragment()
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(this.id, fragment)
        fragmentTransaction.commitAllowingStateLoss()
    }

    private fun requestCameraPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            AlertDialog.Builder(requireContext())
                .setMessage("Se necesita el permiso de la camara para tomarte una foto y almacenarla")
                .setPositiveButton("OK") { _, _ ->
                    requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
                }
                .setNegativeButton("Cancel", null)
                .show()
        } else {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if(validateEmailandDate()){
                    saveData()
                    goToTakePhotoFragment()
                } else {
                    Toast.makeText(requireContext(), "Verifica el formato de la fecha de nacimiento o email.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(requireContext(), "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveData() {
        usersData.nombre = binding.editTextNombre.text.toString()
        usersData.apellidoPaterno = binding.editTextApellidoPaterno.text.toString()
        usersData.apellidoMaterno = binding.editTextApellidoMaterno.text.toString()
        usersData.email = binding.editTextEmail.text.toString()
        usersData.fechaNac = binding.editTextFechaNacimiento.text.toString()
        usersData.datos?.calle = binding.editTextCalle.text.toString()
        usersData.datos?.numero = binding.editTextNumero.text.toString()
        usersData.datos?.colonia = binding.editTextColonia.text.toString()
        usersData.datos?.delegacion = binding.editTextDelegacion.text.toString()
        usersData.datos?.estado = binding.editTextEstado.text.toString()
        usersData.datos?.cp = binding.editTextCp.text.toString()
        fragmentViewModel.saveUserData(usersData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val CAMERA_PERMISSION_CODE = 223
    }
}
