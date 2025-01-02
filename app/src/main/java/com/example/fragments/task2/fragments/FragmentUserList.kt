package com.example.fragments.task2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.fragments.R
import com.example.fragments.task2.adapters.UserAdapter
import com.example.fragments.task2.viewmodels.UserViewModel

class FragmentUserList : Fragment() {
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = UserAdapter(emptyList()) { user ->
            val bundle = Bundle().apply {
                putInt("userId", user.id)
                putString("firstName", user.firstName)
                putString("lastName", user.lastName)
                putString("phone", user.phone)
                putInt("photo", user.photo)
            }
            findNavController().navigate(R.id.action_userList_to_editUser, bundle)
        }
        recyclerView.adapter = adapter

        userViewModel.users.observe(viewLifecycleOwner) { updatedUsers ->
            adapter.users = updatedUsers
        }

        parentFragmentManager.setFragmentResultListener("editUserResult", viewLifecycleOwner) { _, result ->
            val userId = result.getInt("userId", -1)
            val updatedFirstName = result.getString("updatedFirstName", "")
            val updatedLastName = result.getString("updatedLastName", "")
            val updatedPhone = result.getString("updatedPhone", "")

            val (currentUser, userIndex) = userViewModel.getUserAndIndex(userId)

            if (currentUser != null && userIndex != null && userIndex != -1) {
                val updatedUser = currentUser.copy(
                    firstName = updatedFirstName,
                    lastName = updatedLastName,
                    phone = updatedPhone
                )

                userViewModel.updateUser(userId, updatedUser)

                adapter.notifyItemChanged(userIndex)
            }
        }
    }
}
