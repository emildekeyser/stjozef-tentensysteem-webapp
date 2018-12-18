Story 03. Show question
Narrative:
As a student
I want to see all answers for each question on the questions page
In order to choose an appropriate answer

Acceptance Criteria:
If a question is opened, the following is shown:
The question
The possible answers
The tent the question belongs to
How many questions have been answered yet
How many more questions are left to answer
The possible answers are shown in a random order

Scenarios:
Scenario: Show question
Given there is a question to answer
When the question is opened
Then the question itself is shown with the tent it belongs to
And the possible answers are shown in a random order

Scenario: Show test progress
Given the test consist of 10 questions
When question <questionNumber> is shown
Then it is shown that <answeredQuestions> questions have been answered
And it is shown that <toAnswerQuestions> more questions need to be answered
Examples
questionNumber
answeredQuestions
toAnswerQuestions
7
6
4
10
9
1
1
0
10

Wireframes:




