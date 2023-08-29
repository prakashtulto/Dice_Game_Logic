package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicegame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private var Player1:Int =0
    private var Player2:Int =0
    private var currentPlayer:Int =1
    private var winningSCORE:Int=20




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        currentPlayer=1
        binding.Diceroll.setOnClickListener {

            val random = Random.nextInt(6) +1

               val dice =when (random){

                   1-> R.drawable.dice1
                   2-> R.drawable.dice2
                   3-> R.drawable.dice3
                   4-> R.drawable.dice4
                   5->R.drawable.dice5
                 else -> R.drawable.dice6

               }
            binding.DiceImageView.setImageResource(dice)



            if(currentPlayer==1){

                Player1 +=random

                binding.Player1Score.text=Player1.toString()
                currentPlayer=2

            }else{

                Player2 +=random

                binding.player2Score.text =Player2.toString()
                currentPlayer=1
            }
           if (Player1>=20){

               binding.result.text="Player 1 is win"
               binding.Diceroll.text="play again "
               if(binding.Diceroll.text=="Play Again"){

                   binding.Diceroll.setOnClickListener {

                       recreate()

                   }

               }

           }else if(Player2>=20){

               binding.result.text ="Player 2 is win"
               binding.Diceroll.text="play again "
               if(binding.Diceroll.text=="Play Again"){
                   binding.Diceroll.setOnClickListener {

                       recreate()

                   }
               }
           }

            binding.currentPlayer.text = "Current Player:Player $currentPlayer"
        }



    }
}