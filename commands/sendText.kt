// This is an example to show how you can define your commands

// The function broadcasts a text message
private fun sendText(msg: String) {
        val  intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, msg.trim())
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Send via"))
        printToConsole("Text broadcasted",OUTPUT_COLOR_SUCCESS)
}
