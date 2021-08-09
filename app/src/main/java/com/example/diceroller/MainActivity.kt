package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //val resultEditView: EditText = findViewById(R.id.selectSides) // to enter number of sides... makes no sense cause a dice only has 6 sides... RIGHT?! :O
        // val sides = resultEditView.text.toString()

        // Create a new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        var total = diceRoll + diceRoll2

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.dice1)
        val resultTextView2: TextView = findViewById(R.id.dice2)
        val totalView: TextView = findViewById(R.id.total)

        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()
        totalView.text = total.toString()
        
    }
}

class Dice(val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}