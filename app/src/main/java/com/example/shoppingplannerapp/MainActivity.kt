package com.example.shoppingplannerapp

import ShoppingItem
import ShoppingListAdapter
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var items: MutableList<ShoppingItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = mutableListOf(
            ShoppingItem("牛奶", 2, 10.0),
            ShoppingItem("麵包", 1, 5.5),
            ShoppingItem("蘋果", 3, 3.0)
        )

        val adapter = ShoppingListAdapter(items)
        recyclerView.adapter = adapter
    }
    fun addItem(view: View) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_item)

        val etName = dialog.findViewById<EditText>(R.id.et_item_name)
        val etQuantity = dialog.findViewById<EditText>(R.id.et_item_quantity)
        val etPrice = dialog.findViewById<EditText>(R.id.et_item_price)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)
        val btnAdd = dialog.findViewById<Button>(R.id.btn_add_item)

        btnCancel.setOnClickListener { dialog.dismiss() }
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val quantity = etQuantity.text.toString().toInt()
            val price = etPrice.text.toString().toDouble()
            val item = ShoppingItem(name, quantity, price)
            items.add(item)
            (recyclerView.adapter as ShoppingListAdapter).notifyItemInserted(items.size - 1)
            dialog.dismiss()
        }

        dialog.show()
    }

}