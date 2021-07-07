package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClick {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : Adapter
    private var users = ArrayList<User>()
    private var array = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        initViews()


    }

    private fun initViews() {
        val object1 = User()
        object1.name = "Belal Khan"
        object1.address = "Ranchi Jharkhand"
        users.add(object1)

        val object2 = User()
        object2.name = "Ramiz Khan"
        object2.address = "Ranchi Jharkhand"
        users.add(object2)

        val object3 = User()
        object3.name = "Faiz Khan"
        object3.address = "Ranchi Jharkhand"
        users.add(object3)

        val object4 = User()
        object4.name = "Yashar Khan"
        object4.address = "Ranchi Jharkhand"
        users.add(object4)

        for (i in 0 until users.size) {
            Log.e("NUMBER", i.toString())
        }

        for ((x, user) in users.withIndex()){
            Log.e("User Name:",user.name + " index " + x)
            array.add(user)
        }

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        adapter = Adapter(applicationContext,array,this)
        recyclerView.adapter = adapter
    }

    override fun onListener(user: User, position: Int) {
        Log.e("User Name",user.name)
        when (user.name) {
            "Belal Khan" -> {
                Toast.makeText(applicationContext,""+user.name,Toast.LENGTH_SHORT).show()
            }
            "Ramiz Khan" -> {
                Toast.makeText(applicationContext,""+user.name,Toast.LENGTH_SHORT).show()
            }
            else -> {
                val bundle = Bundle()
                bundle.putString("input_txt", user.name)
                val fragment = DetailFragment()
                fragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit()
            }
        }
    }
}