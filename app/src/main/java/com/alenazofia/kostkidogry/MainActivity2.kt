package com.alenazofia.kostkidogry

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ButtonRzucic: Button = findViewById(R.id.button2)
        val ButtonPowrot: Button = findViewById(R.id.backButton)
        ButtonPowrot.setOnClickListener {
            val kostkaIntent = Intent(this, MainActivity::class.java)
            startActivity(kostkaIntent)
        }

        val toast = Toast.makeText(this, "Kostka została rzucona!", Toast.LENGTH_SHORT)
        rzucickostki()
        ButtonRzucic.setOnClickListener {
            toast.show()
            rzucickostki()
            MediaPlayer.create(this,R.raw.kosci).start()
        }



    }


    private fun rzucickostki(){
        val kostki = Kostki(6)
        val kr = kostki.rzucic()
        val kostkaImage: ImageView = findViewById(R.id.imageKostka3)

        when (kr){
            1->kostkaImage.setImageResource(R.drawable.dice1)
            2->kostkaImage.setImageResource(R.drawable.dice2)
            3->kostkaImage.setImageResource(R.drawable.dice3)
            4->kostkaImage.setImageResource(R.drawable.dice4)
            5->kostkaImage.setImageResource(R.drawable.dice5)
            6->kostkaImage.setImageResource(R.drawable.dice6)

        }

    }

    class Kostki(val liczbaStron: Int) {
        fun rzucic(): Int {
            return(1..liczbaStron).random()

        }
    }
}

