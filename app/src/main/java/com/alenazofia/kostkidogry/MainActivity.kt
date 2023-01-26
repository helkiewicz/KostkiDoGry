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

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ButtonRzucic: Button = findViewById(R.id.button)


        val ButtonDrugiEkran: Button = findViewById(R.id.drugiekran)
        ButtonDrugiEkran.setOnClickListener {
            val kostkaIntent = Intent(this, MainActivity2::class.java)
        startActivity(kostkaIntent)
        }


        val toast = Toast.makeText(this, "Kostki zostały rzucone!", Toast.LENGTH_SHORT)
        rzucickostki()
        ButtonRzucic.setOnClickListener {
            toast.show()
            rzucickostki()
            MediaPlayer.create(this,R.raw.kosci).start()
        }



    }


    private fun rzucickostki(){
       val kostki = Kostki(6)
        val kostki2 = Kostki(6)
        val kr = kostki.rzucic()
        val kr2 = kostki2.rzucic()
        val kostkaImage:ImageView = findViewById(R.id.imageKostka)
        val kostkaImage2:ImageView = findViewById(R.id.imageKostka2)

        when (kr){
            1->kostkaImage.setImageResource(R.drawable.dice1)
            2->kostkaImage.setImageResource(R.drawable.dice2)
            3->kostkaImage.setImageResource(R.drawable.dice3)
            4->kostkaImage.setImageResource(R.drawable.dice4)
            5->kostkaImage.setImageResource(R.drawable.dice5)
            6->kostkaImage.setImageResource(R.drawable.dice6)

        }
        when (kr2){
            1->kostkaImage2.setImageResource(R.drawable.dice1)
            2->kostkaImage2.setImageResource(R.drawable.dice2)
            3->kostkaImage2.setImageResource(R.drawable.dice3)
            4->kostkaImage2.setImageResource(R.drawable.dice4)
            5->kostkaImage2.setImageResource(R.drawable.dice5)
            6->kostkaImage2.setImageResource(R.drawable.dice6)

        }
    }

    class Kostki(val liczbaStron: Int) {
        fun rzucic(): Int {
            return(1..liczbaStron).random()

        }
    }
}

