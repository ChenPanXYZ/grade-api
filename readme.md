# Lab 3: Grade API program

**Please try to work through Tasks 0 and 1 ahead of your lab time on Monday.
Your team and TA can help you during the lab if you had any trouble,
so don't worry if you don't get through Task 1 before lab. There will also
be some time to do this as your TA helps everyone get into teams.**


## Task 0: Fork and clone this repo

1. As with the previous lab activities, start by making a fork of this repo and cloning it.

## Task 1: Your API Token (token)

In order to use the Grade API, you will need to sign up an account, and use the `token`..
To sign up an account, we are going to make a simple request to the Grade API.

1. Go to https://hoppscotch.io. This is a tool like Postman, which can be used to quickly interact with APIs.
2. Beside the word GET, replace https://echo.hoppscotch.io/ with http://vm003.teach.cs.toronto.edu:20112/signUp.

Next, we need to specify the username which we want to sign up with. To do this, we add a parameter.

3. In the Parameters tab, choose `+ Add new` and set the parameter name to `username`.
4. For its value, choose whatever username you want to use. Make note of the name you choose, as you'll use it during the lab. (Don't worry, you can repeat this process with a new username if you need to later!)
5. Press the `Send` button to make the request. You may receive an error that the request didn't go through. Scroll down and select `proxy` as the middleware and press `Send` again. You should now see the result of the request.
6. If the username had been used before, you will see a response indicating that. Choose a new username and send the request again.
7. When you successfully sign up an account, you will get a field called `environment_variables`, which you should copy and paste into Intellij's environment variables, for the rest of the activity.

You can also refer to `apiDocuments/signUp.md` in this repo for the documentation of this API request.

***

Alternative to the above: Enter `http://vm003.teach.cs.toronto.edu:20112/signUp?username=USERNAME` in any web browser
with `USERNAME` replaced with the username you want to use.

***

7. Create a new file called `username.txt` in the root directory of your project and record your
   `token` in that file. This file is indicated in the `.gitignore` for your project, so
   its name will appear yellow in IntelliJ to indicate that git will ignore the file (it won't be version
   controlled). This can be useful to ensure that you don't accidentally share private information
   (like personal api tokens) or configurations specific to your local environment when working on a
   team project.

Now that you have your api token, the last step is to get your program to use it. To do so, we
are going to set an environment variable in the run configuration.

Note: at this point you should be able to run the program, but it is possible that the Maven
project didn't automatically build. If you have errors which won't let you run the code in the
next step, you may need to reload the Maven project. You can do this by right-clicking on the
`pom.xml` file in your project. In the context menu, choose `Maven -> reload project`. This should
resolve any errors.

8. Try running the main application (`src/main/java/app/gui/Application`). When you start the program,
you will see that it says `your token is null` (since we didn't set it yet).
Stop the program and go to `Run -> Edit Configurations...`.

9. Open the Run Configuration for `Application` and find the `Environment Variables:`
field.
    - Note: If you don't see this Run Configuration listed:
      - create a new Run Configuration of type `Application` (use the +
      in the top left corner of the window).
      - where it says "Main class", type `app.gui.Application`.

10. In that field, type the text you copied from `environment_variables` when you sign up an account. Your `token` should also be variable in `username.txt`.
Example: `token=6SgDAt8XpnQYTDPt4vHcPCCKJ2ppLg1C`.
11. Click `Apply` and then `OK`.
12. Now, rerun the program and you should see your `token` displayed.
13. Enter a valid grade for `207` in the `Log a Grade` menu. You should see a popup
telling you that your grade was successfully entered. You can then check your grade
by using the `Get a Grade` menu and specifying your username and `207` for the course.

You are now ready to use the program! The following task will be completed with your
team during the lab. First, make sure everyone has successfully completed the steps above.

## Task 2: Forming a team

As a team-building exercise, you will now work together to form a team using
this application. Team members in this program are able to view the grades of other
team members.

1. Choose a team name. Make it something unique to your team, as other teams will also
be picking team names and duplicate names aren't allowed.

2. Have one member of your team form a team with the name your team chose.

3. Each other member of the team should then join the team. Make sure you see the popup
confirming that you successfully joined the team.

4. Try looking up the grade another team member entered for `207` using the `Get a Grade` menu.

Now that you are all on the team, there is one coding task for your team to work on today!

***

Note: If your team finds it convenient to work on parts of this lab on a common machine,
you can create different run configurations (copy an existing one) which each use a different
`token` environment variable. Then you can run multiple instances of the program and
enter requests as different users.

***

## Task 3: Coding a new feature

While this program has some useful core functionality which is provided by the Grade API,
there are certain things which the Grade API can't currently do.

1. As a team, brainstorm some potential additional features which this program could have.
Aim to come up with one feature per team member.

2. For each feature, think about whether it is possible to implement, given the current functionality
provided by the Grade API. If it isn't possible, identify what new capabilities would need to be added.
And if it is possible, think about what the steps would need to be taken to implement the
feature in the program.

3. You may have noticed that the functionality for `My Team -> Get Average Grade` isn't actually
implemented yet (see the TODOs in the code). As a team, work to implement this feature and confirm
that it works.

Note: Your team can choose how you want to work on this part, but below is our suggestions.

Suggested logistics: One of you should invite the others to collaborate on their fork of the
original repo on GitHub. You can do this in your repo on GitHub under `Settings -> Collaborators`.
This will allow you to push branches to a common repo and then use pull requests to contribute
your code and review.

## Task 4 Bonus

If your team finishes the above task and has extra time, we encourage you to go through
the code base in more detail and think critically about the structure of the code. What
strikes you as being good design? What feels like it could be improved or restructured to
make the code better? How easy would it be to implement new functionality into the program?

In lecture this week, we will finish our initial tour of Clean Architecture with a full
example designed with Clean Architecture in mind. You might find it useful to revisit this
code base after to see what parts align with Clean Architecture and which parts do not.

## Tips
1. Use this API `info` if you want to access all the information you can access (your team and all your teammates' grades).
2. All responses are in `json` format. 
3. We are using a very simple authedication method, by passing `token` in the request headers. When you use some real-world APIs, you will see some more sophisticated authedication approches.
4. You can run the testing to check if your `GetAverageGradeUseCase` is implementated correctly, before you finish implmenting the API caller.