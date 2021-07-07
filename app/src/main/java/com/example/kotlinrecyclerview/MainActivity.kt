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
        object1.name = "Example 1"
        object1.address = "Example 1"
        users.add(object1)

        val object2 = User()
        object2.name = "Example 2"
        object2.address = "Example 2"
        users.add(object2)

        val object3 = User()
        object3.name = "Example 3"
        object3.address = "Example 3"
        users.add(object3)

        val object4 = User()
        object4.name = "Example 4"
        object4.address = "Example 4"
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
        val bundle = Bundle()
        bundle.putString("input_txt", user.name)
        val fragment = DetailFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit()
    }
}