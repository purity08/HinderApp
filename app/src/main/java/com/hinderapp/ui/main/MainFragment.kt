package com.hinderapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hinderapp.R
import com.hinderapp.data.model.User

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var viewModel: UserViewModel? = null
    private var tvUsers: TextView? = null
    private var btnAddUser: Button? = null
    private var btnDeleteUser: Button? = null
    private var btnUpdateUser: Button? = null

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[UserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        tvUsers = view.findViewById(R.id.all_users_text)
        btnAddUser = view.findViewById(R.id.add_user_button)
        btnDeleteUser = view.findViewById(R.id.delete_user_button)
        btnUpdateUser = view.findViewById(R.id.update_user)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel?.user?.observe(viewLifecycleOwner) { user ->
            this.user = user
            if (user != null) {
                Log.d("user: ", user.toString())
            }
            tvUsers?.text = this.user?.toString()
        }

        btnAddUser?.setOnClickListener {
            viewModel?.addUser(getUser())
        }

        btnUpdateUser?.setOnClickListener {
            user?.email = "updated_email"
            user?.let { it1 -> viewModel?.updateUser(it1) }
        }

        btnDeleteUser?.setOnClickListener {
           viewModel?.clear()
        }
    }

    private fun getUser(): User = User((0..10).random().toString(), "Name", "LastName", "standard_email")
}