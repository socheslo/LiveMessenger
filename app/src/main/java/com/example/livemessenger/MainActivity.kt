package com.example.livemessenger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import android.widget.Button
import com.example.livemessenger.chat.ChatActivity
import com.example.livemessenger.settings.SettingsActivity

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChatDataAdapter
    private lateinit var itemList: List<ChatData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.settingsButton)
        button.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)

        }

        // Подготовка данных
        itemList = generateDummyList()

        // Настройка RecyclerView
        recyclerView = findViewById(R.id.chats)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ChatDataAdapter(itemList, this)
        recyclerView.adapter = adapter
    }

    private fun generateDummyList(): List<ChatData> {
        return listOf(
            ChatData(R.drawable.icon_plcaeholder, R.drawable.green_circle, "Vasya", "I bougth a car"),
            ChatData(R.drawable.icon_plcaeholder, R.drawable.green_circle, "Anna", "Hi!"),
            ChatData(R.drawable.group_icon, R.drawable.green_circle, "Group 123", "Petya: Lets go party!"),
            ChatData(R.drawable.icon_plcaeholder, R.drawable.green_circle, "Joker", "Heheheh"),
            ChatData(R.drawable.icon_plcaeholder, R.drawable.green_circle, "Sasha Socheslo", "Здарова, го делать курсовую"),
            ChatData(R.drawable.icon_plcaeholder, R.drawable.green_circle, "Anna", "Hi!"),
            // Добавьте другие элементы по необходимости
        )
    }

    override fun onItemClick(id: String) {
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }
}
interface OnItemClickListener {
    fun onItemClick(id: String)
}