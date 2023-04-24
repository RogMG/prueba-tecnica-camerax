package com.rogelio.prueba_camerax.app.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogelio.core.domain.models.UsersFieldsDTO
import com.rogelio.prueba_camerax.app.presentation.viewmodels.MainActivityViewModel
import com.rogelio.prueba_camerax.app.util.RecyclerViewInterface
import com.rogelio.prueba_camerax.app.util.RecyclerViewUsers
import com.rogelio.prueba_camerax.databinding.FragmentSeeUsersBinding

class SeeUsersFragment : Fragment(), RecyclerViewInterface {

    private var _binding: FragmentSeeUsersBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RecyclerViewUsers

    private val fragmentViewModel by activityViewModels<MainActivityViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSeeUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        adapter = RecyclerViewUsers(this)
        binding.usersRecyclerView.adapter = adapter
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        fragmentViewModel.getUsersData()
    }

    fun setObservers() {
        fragmentViewModel.usersData.observe(viewLifecycleOwner) {
            adapter.bindData(it)
        }
        fragmentViewModel.exception.observe(viewLifecycleOwner) {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClickedShow(data: UsersFieldsDTO) {
        data.datos?.let {
            val dialogFragment = DialogFragmentInfoUsers.newInstance(it)
            dialogFragment.show(parentFragmentManager, "DIALOG_FRAGMENT_INFO")

        }
    }
}
