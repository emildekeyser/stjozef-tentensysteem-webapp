Story 04. Submit answer
Narrative:
As a student
I want to click a submit button on the answer page
In order to submit my answers

Acceptance Criteria:
If there are more questions to answer, the next question is shown
If there are no more questions to answer, the result is shown
The selected answer is stored
If no answer is selected, the user cannot submit

NOT in scope of this story: show result

Questions:
Does the order of the questions matter (random, per tent, ...)?
What if the user cancels the test?
And what if some questions were already answered? - Can you take an incomplete test?
What if the corresponding score is lower than the previous score, based on an answer given in a previous test?
Scenarios:
Scenario: Next question is shown if questions left
Given the student answered a question
And there is more questions left to answer
When he submits his answer
Then the answer is stored
And the next question is shown

Scenario: Result question is shown if no questions left
Given the student answered a question
And there is no more questions left to answer
When he submits his answer
Then the answer is stored
And the result is shown

Scenario: Answers cannot be left blanc
Given the student has not answered the question yet
When he tries to submit his answer
Then an error message is shown
And the question is presented again

Wireframes:




