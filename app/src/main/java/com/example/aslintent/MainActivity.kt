package com.example.aslintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
            val btnMoveWithDataActivity: Button =
                findViewById(R.id.btn_move_activity_data)
            btnMoveWithDataActivity.setOnClickListener(this)
            btnMoveWithObject.setOnClickListener(this)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity_object -> {
                val person = Person("Ani", 5, "ani@gmail.com", "Bandung")
                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(
                    MoveWithObjectActivity.EXTRA_PERSON, person
                )
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity,
                    MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
        }
    }
}
