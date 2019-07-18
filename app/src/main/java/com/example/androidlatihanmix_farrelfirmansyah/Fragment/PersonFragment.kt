package com.example.androidlatihanmix_farrelfirmansyah.Fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_person.*


class PersonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            com.example.androidlatihanmix_farrelfirmansyah.R.layout.fragment_person,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_logout.setOnClickListener {
            val builder = AlertDialog.Builder(activity!!) //Home is name of the activity
            builder.setMessage("Do you want to exit?")
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                activity!!.finish()
                val i = Intent()
                i.putExtra("finish", true)
                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // To clean up all activities
                //startActivity(i);

                val fAuth = FirebaseAuth.getInstance()
                fAuth.signOut()

                activity!!.finish()
            })

            builder.setNegativeButton("CANCEL",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

            val alert = builder.create()
            alert.show()


        }
    }
}