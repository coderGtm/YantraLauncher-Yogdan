package com.coderGtm.ylTester

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.coderGtm.ylTester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeBtn.setOnClickListener {
            val cmd = binding.cmdInput.text.toString()
            cmdHandler(cmd)
        }
    }

    private fun printToConsole(text: String, clr: String) {
        val t = TextView(this)
        t.text = text
        t.setTextColor(getOutputColor(clr))
        t.textSize = 18f
        // making the text selectable
        t.setTextIsSelectable(true)
        binding.outputView.addView(t)
        // if error then vibrate if permitted
        val vibrationPermission = true  // taking constant here
        if (clr == OUTPUT_COLOR_ERROR && vibrationPermission) {
            vibrate(context = this@MainActivity)
        }
    }

    // All commands passed are routed to this function.
    private fun cmdHandler(cmd: String) {

        printToConsole("\$root> $cmd", OUTPUT_COLOR_NORMAL)

        val args = cmd.split(" ")

        // This is how the commands are checked for and their appropriate parameters provided
        if (args[0].lowercase() == "text") {
            if (args.size > 1) sendText(cmd.removePrefix(args[0]))
            else printToConsole("Please specify the text to broadcast.", OUTPUT_COLOR_ERROR)
        }
        else if (args[0].lowercase() == "mycommand") {
            myCommand(args)
        }

        else if (cmd==""){
            // Eat 5 star. do nothing.
        }

        else {
            // COMMAND NOT DEFINED
            printToConsole("${args[0]} is not a recognized command!", OUTPUT_COLOR_ERROR)
        }
    }

    private fun sendText(msg: String) {
        val  intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, msg.trim())
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Send via"))
        printToConsole("Text broadcasted", OUTPUT_COLOR_SUCCESS)
    }


    private fun myCommand(args: List<String>) {
        printToConsole("Not Yet Implemented!", OUTPUT_COLOR_WARNING)
    }

}