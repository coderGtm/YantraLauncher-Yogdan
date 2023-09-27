// This file shows how commands are handled in Yantra Launcher
// so that you can design features accordingly.
// This file is not meant to be run on your machine as it is incomplete.
// It is provided only as a reference to understand how Yantra Launcher handles commands.


// All commands passed are routed to this function.
// It takes 2 values: the command string and an isAlias Boolean, defaulting to false.
// The isAlias is set to true when the input command passed is detected as an alias key
private fun cmdHandler(cmd: String, isAlias: Boolean = false) {
    // isSleeping is a global variable that indicates whether the effect of 'sleep' command is ongoing.
    if (isSleeping) {
        // commandQueue is another global var used to maintain the queue of commands when prevoius synchronous commands have not finished execution or the Launcher is in sleep state.
        commandQueue.add(cmd)
        return
    }
    
    if (!isAlias) {
        // if not an alias then print the command
        printToConsole(getUserNamePrefix()+getUserName()+"> $cmd", 1)
        if (cmd!="") {
            // cmdHistory is another global var used to maintain the queue of command inputs for the session. Used for arrow keys functionality
            cmdHistory.add(cmd)
        }
    }
    val args = cmd.split(" ")

    // aliasList is also a Global variable used to store the alias key-value pairs
    for (alias in aliasList) {
        if (args[0] == alias[0]) {
            // if the entered command matches an alias key exactly, then call the cmdHandler again with the value of the alias replaced and isAlias set to true
            val newCmd = cmd.replaceFirst(args[0], alias[1])
            cmdHandler(newCmd, true)
            // exit this function block
            return
        }
    }

    // This is how the commands are checked for and their appropriate parameters provided
    if (args[0].lowercase() == "open") {
        if (args.size > 1) openApp(cmd.removePrefix(args[0]))
        else printToConsole("Please specify an app to open", 5)
    }
    else if (args[0].lowercase() == "list") {
        listCmd(args)
    }
    ...
    else if (cmd==""){
        // Eat 5 star. do nothing.
    }
    else {
        // find most similar command and recommend
        val candidates = mutableListOf<Double>()
        val allCmds = Constants().primarySuggestions
        for (commandName in allCmds) {
            val score = findSimilarity(cmd, commandName)
            candidates.add(score)
        }
        val maxIndex = candidates.indexOf(candidates.max())
        val mostSimilarCmd = allCmds[maxIndex]
        printToConsole("${args[0]} is not a recognized command or alias. Did you mean $mostSimilarCmd?",5)
    }
}
