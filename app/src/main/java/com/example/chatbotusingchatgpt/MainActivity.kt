package com.example.chatbotusingchatgpt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText=findViewById<EditText>(R.id.message_edit_text)
        val btnSubmit=findViewById<ImageButton>(R.id.btn_send)
        val outputTextView=findViewById<TextView>(R.id.output_textView)

        btnSubmit.setOnClickListener {
            val prompt=editText?.text.toString().trim()

            val generativeModel = GenerativeModel(
                // The Gemini 1.5 models are versatile and work with both text-only and multimodal prompts
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyAix0kVcE9TPLt6ak2nHCdHqKmYExFGFjU"
            )

            runBlocking {
                val response = generativeModel.generateContent(prompt)
                outputTextView.text=response.text.toString()
            }

        }
    }
}