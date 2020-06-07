package com.example.intentexplicandimplict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnsendMessageTwoActivity.setOnClickListener {
            val message = txtUserMessage.text.toString()
            Toast.makeText(this, message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this,SecondActivity::class.java)

            // pasando un string al otro activity
            intent.putExtra("use_message", "Este es el segundo mensaje")
            startActivity(intent)
        }

        btnShared.setOnClickListener {
            val intent = Intent()
            val message: String = "Intent Implicito"
            intent.action = Intent.ACTION_SEND

            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"compartir con"))
        }

        btnRecycler.setOnClickListener{
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }
    }
}