# YantraLauncher-Yogdan
This repository is for contributing code to be used in the Closed-Source Yantra Launcher for increasing Development Speed, testing pre-release builds, and finding bugs faster. 🐛🚀

## Why this name 🤔
You Probably already know the reason behind the name of Yantra Launcher. Yeah right, **Yantra**_(yan·truh)_ means Device and so this Launcher is basically a minimal Launcher for your device. 📱

Now coming to **Yogdan** _(/yogadāna/ Sanskrit योगदान)_: **Yogdan** means Your Contribution. This repo is created for contributing to the Yantra Launcher.🙌

## Back-Story 📖
First of all, thank you for all the love for Yantra Launcher. When I started this project, I didn't expect that there are people like me who really love these kind of apps. As time passed by, more and more people, including programmers, senior managers, gamers, Youtubers, etc., started using Yantra Launcher as their default Home Screen and we are still a rapidly growing family. ❤️

As the number of users increased, so did their likes and dislikes and feature requests. This is the best phase as we can get feedback and discuss the app from a wide variety of people who actually care about improving what they use daily.

But this has also led to a slightly increased load on me as a solo Developer, juggling between University, side-projects, internships, and other things. But thankfully we also have some members in the community who really love to contribute to the project using their Development Skills. That's when I decided to have ***a repo where users of the app can also help with the development of the app.***

## How to contribute? 🤝
Thank you once again for deciding to contribute to the app. I am really grateful to you all! 🙏❤️

Before we start, let's understand _how Yantra Launcher works..._

Each command you enter into the terminal is directly passed to a Command Handling function. This function is shown in [CommandHandling.kt file](CommandHandling.kt).
Every time something is printed to the terminal output, Yantra Launcher uses a custom `printToConsole` function as shown in [Output.kt file](Output.kt).

**Refer to the above 2 files before moving forward so you get an idea of how to use them in your functions.**

Moving forward, commands in Yantra Launcher are nothing but Kotlin functions. See [sendtext.kt](commands/sendText.kt) for the implementation of the `text` command in Yantra Launcher

- Now to contribute a new command from scratch, upload it in the [commands](/commands) directory like the sample command shown in [sendtext.kt](commands/sendText.kt) file.

- To improve an existing command that's available in the [commands](/commands) directory, simply open a pull request. 🛠️🔄

- To improve an existing command that's not found in the [commands](/commands) directory, open an issue and we will discuss it there if I can provide the code for the existing command.  💻🔧


## What will I get? 🌟
***Satisfaction!*** Although I can't remunerate you for your contribution, you will get recognition if your contribution is used in the Yantra Launcher. There are a couple of perks that are yet to be listed, but please do not spam for getting a Contributor Tag. Such requests will be rejected as they defy the purpose of this repository. Contribute only if you feel so, not for any perks. 🙏


## FAQs ❓
1. **💰 Why are there some paid plugins in Yantra Launcher?**

    It takes an immense amount of time, energy, and effort other than the monetary costs of developing and maintaining the application. Although the app is freely available on the Play Store, I have added some paid plugins that are not required but are there just to enhance the experience a little bit. When you buy these plugins, ***you help me cover some of the costs that I bear for the application, apart from getting the associated motivation.*** Plus, I don't want to include ads in the app like other similar apps do, as it defies the purpose of a minimal distraction-free Home Screen.

2. **📂 Why don't you open-source the application entirely?**

    I understand that it would be more intuitive to contribute if the application was completely open-source but as I said above, It takes an immense amount of time, energy, and effort other than the monetary costs of developing and maintaining the application. If I open-source it, not everyone is good enough to uphold their moral values and responsibilities. ***Some random dude, trying to look nerdy will fork it, remove all paywalls, and release it on the store.*** And due to the nature of open-source, I can't, and even don't have the time to, deny him/her. _I hope you understand!_ 🤝
