package com.example.shoppingplannerapp

import ShoppingItem
import ShoppingListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            ShoppingItem("牛奶", 2, 10.0),
            ShoppingItem("麵包", 1, 5.5),
            ShoppingItem("蘋果", 3, 3.0)
        )

        val adapter = ShoppingListAdapter(items)
        recyclerView.adapter = adapter
    }
}
