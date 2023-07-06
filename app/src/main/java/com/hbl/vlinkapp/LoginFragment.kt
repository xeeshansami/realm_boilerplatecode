package com.hbl.vlinkapp

import android.Manifest
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import hbl.vlinkapprevame.R
import kotlinx.android.synthetic.main.fragment_login.*
import java.security.*
import java.util.*
import javax.crypto.*


class LoginFragment : Fragment(), View.OnClickListener {
    var permissions = arrayOf(
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.CALL_PHONE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.INTERNET,
        Manifest.permission.CHANGE_WIFI_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            Log.i("TestBuild", "2")
            super.onViewCreated(view, savedInstanceState)


    }

    fun validation() {
      /*  val email: String = etEmail.getText().toString().trim()
        val pwd: String = etPassword.getText().toString().trim()
        return if (TextUtils.isEmpty(email)) {
            false
        }*//* else if (!isEmailValid(email)) {
            etEmail.setError("Please enter valid UserID")
            etEmail.setFocusable(true)
            ToastUtils.normalShowToast(activity, "Please enter valid UserID")
            return false;
        }*//* else if (TextUtils.isEmpty(pwd)) {
            false
        } else {
            true
        }*/
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

        }
    }

}