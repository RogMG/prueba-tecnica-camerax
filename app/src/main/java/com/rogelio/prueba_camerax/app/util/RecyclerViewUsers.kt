package com.rogelio.prueba_camerax.app.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.prueba_camerax.databinding.SeeUsersCardViewBinding

class RecyclerViewUsers(val itemClicked: RecyclerViewInterface) : RecyclerView.Adapter<RecyclerViewUsers.ViewHolder>() {

    private lateinit var binding: SeeUsersCardViewBinding
    private val usersData = UsersDTO()

    fun bindData(data: UsersDTO) {
        usersData.Users.addAll(data.Users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SeeUsersCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            name.text = "${usersData.Users[position].nombre} ${usersData.Users[position].apellidoPaterno} ${usersData.Users[position].apellidoMaterno}"
            email.text = usersData.Users[position].email
            fechaNac.text = usersData.Users[position].fechaNac
            val encodedString = usersData.Users[position].datos?.imagen.toString()
            val startIndex = encodedString.indexOf(',') + 1
            val encodedImage = encodedString.substring(startIndex)
            val decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT)
            val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            Log.e("ACESSSS", usersData.Users[position].datos?.imagen.toString())
            userImage.setImageBitmap(bitmap)
        }
    }

    override fun getItemCount(): Int {
        return usersData.Users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = binding.seeNameTextView
        val email = binding.seeEmailTextView
        val fechaNac = binding.seeBirthDateTextView
        val userImage = binding.seeUserImageView
        val showInfoButton = binding.seeInformationButton


        init {
            showInfoButton.setOnClickListener {
                itemClicked.onItemClickedShow(usersData.Users[adapterPosition])
            }

        }
    }
}
