package com.example.livemessenger.chat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livemessenger.R


class ChatActivity : AppCompatActivity() {

    private lateinit var chatAdapter: ChatAdapter
    private val messageList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)

        messageList.add(Message("Hello!",false))
        messageList.add(Message("Hello!",true))
        messageList.add(Message("Hello!",false))

        // Настройка Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        // Настройка иконки и имени пользователя
        val userIcon = findViewById<ImageView>(R.id.user_icon)
        val userName = findViewById<TextView>(R.id.user_name)
        userIcon.setImageResource(R.drawable.user) // Установите ресурс иконки
        userName.text = "Username" // Установите имя пользователя

        chatAdapter = ChatAdapter(messageList)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view);
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatAdapter
        }

        val buttonSend = findViewById<Button>(R.id.button_send)
        buttonSend.setOnClickListener {
            val edit_text = findViewById<EditText>(R.id.edit_text)
            val messageText = edit_text.text.toString()
            if (messageText.isNotEmpty()) {
                val message = Message(messageText, true) // true для отправленных сообщений
                messageList.add(message)
                chatAdapter.notifyItemInserted(messageList.size - 1)
                recyclerView.scrollToPosition(messageList.size - 1)
                edit_text.setText("")
            }
        }
    }
}