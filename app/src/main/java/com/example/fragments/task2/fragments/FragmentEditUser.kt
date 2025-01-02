package com.example.fragments.task2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fragments.R
import com.example.fragments.task2.models.User
import com.example.fragments.task2.viewmodels.UserViewModel

class FragmentEditUser : Fragment() {
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userPhoto: ImageView = view.findViewById(R.id.userEditPhoto)
        val firstNameEdit: EditText = view.findViewById(R.id.editFirstName)
        val lastNameEdit: EditText = view.findViewById(R.id.editLastName)
        val phoneEdit: EditText = view.findViewById(R.id.editPhone)
        val saveButton: Button = view.findViewById(R.id.buttonSave)

        val userId = arguments?.getInt("userId") ?: return

        val user = userViewModel.users.value?.find { it.id == userId }
        user?.let {
            userPhoto.setImageResource(it.photo)
            firstNameEdit.setText(it.firstName)
            lastNameEdit.setText(it.lastName)
            phoneEdit.setText(it.phone)
        }

        saveButton.setOnClickListener {
            val currentUser = userViewModel.users.value?.find { it.id == userId }

            if (currentUser == null) {
                Toast.makeText(requireContext(), getString(R.string.user_not_found), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedUser = User(
                id = userId,
                photo = currentUser.photo,
                firstName = firstNameEdit.text.toString(),
                lastName = lastNameEdit.text.toString(),
                phone = phoneEdit.text.toString()
            )

            userViewModel.updateUser(userId, updatedUser)

            parentFragmentManager.popBackStack()
        }
    }
}
