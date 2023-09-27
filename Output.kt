// This file shows how to output text to the Yantra Launcher Terminal
// so that you can use it to design your functions
// This file is not meant to be run on your machine as it is incomplete.
// It is provided only as a reference to understand how Yantra Launcher handles commands.



// printToConsole function is used to add a TextView to the terminal output.
// It takes 3 parameters
// 1) The text to be printed
// 2) The color code ( 4: normal, 5: error, 6: success, 7: warning)
// 3) The style integer (for eg. Typeface.BOLD) from the Android System. It is null by default
private fun printToConsole(text: String, clr: Int, style: Int? = null) {
        val t = TextView(this)
        t.text = text
        // getTextColorFromCode is an abstracted function that gets the actual hex code for the provided Yantra code
        t.setTextColor(getTextColorFromCode(clr))
        // fontsize is a global variable
        t.textSize = fontSize.toFloat()
        // cliTypeface is also a global variable which holds unstyled font
        if (style != null) {
            t.setTypeface(cliTypeface, style)
        }
        else {
            t.typeface = cliTypeface
        }
        // making the text selectable
        t.setTextIsSelectable(true)
        runOnUiThread {
            // outputViev is the Layoutholding all terminal outputs
            binding.outputViev.addView(t)
        }
        // if error then vibrate if permitted
        val vibrationPermission = isVibrationPermitted()
        if (clr == 5 && vibrationPermission) {
            vibrate()
        }
}
