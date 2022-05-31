package com.firebase.gsbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var database = FirebaseDatabase.getInstance().reference

        button8.setOnClickListener {
            var pseudo = editTextTextPersonName40.text.toString()
            var deplacement = editTextTextPersonName41.text.toString().toInt()
            var hotellerie = editTextTextPersonName42.text.toString().toInt()
            var restauration = editTextTextPersonName43.text.toString().toInt()
            var imprevu = editTextTextPersonName44.text.toString().toInt()


            database.child(pseudo.toString())
                .setValue(Employee(pseudo, deplacement, hotellerie, restauration, imprevu))

        }


        var getdata = object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }


        override fun onDataChange (p0: DataSnapshot) {
            var sb = StringBuilder()
            for (i in p0.children) {
                var deplacement1 = i.child( "deplacement") .getValue()
                var hotellerie1 = i.child( "hotellerie") .getValue()
                var restauration1 = i.child( "restauration") .getValue()
                var imprevu1 = i.child( "imprevu") .getValue()
                sb.append("${i.key} -$deplacement1 -$hotellerie1 -$restauration1 -$imprevu1.\n")
                     }
                textView.setText (sb)
                  }
               }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

            }
        }







