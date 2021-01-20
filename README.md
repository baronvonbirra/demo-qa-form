# demo-qa-form

## Assignment
Create a test project using Java, JUnit, Maven and Selenium. Project should
be hosted on a git repository.
Test consist on register a list of users on a website.
List of users to be registered must be as a constant field having the following
names: “Jan van Dam”, “Chack Norris”, “Klark n Kent”, “John Daw”, “Bat
Man”, “Tim Los”, “Dave o Core”, “Pay Pal”, “Lazy Cat”, “Jack & Jones”
The first part of the name is a first name and last part is a second name (e.g
“Jan” - first name, “Dam” - second name)
Test steps:
1. Open the page https://demoqa.com/automation-practice-form and
validate that the URL is the same as we navigated to. If not - fail the test.
2. Register 5 random users from the list above (random data except First
Name and Second Name). Do not repeat the users.
3. Display in the output the given list of the users but WITHOUT already
registered users.
Hint: attention to the details

## Launching Cypress tests
- Make sure node and npm are downloaded and up to date
- Clone repo
- _npm i_
- _npx cypress run_ > for Cypress headless mode
- _npx cypress open_ > for Cypress browser mode

- Alternatively, you can watch the _registration.feature.mp4_ video for a quick visual check as well.
