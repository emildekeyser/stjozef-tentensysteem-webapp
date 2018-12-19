Feature: Story 04. Submit answer
Narrative:
As a student
I want to click a submit button for each tent
In order to submit these answers

Acceptance Criteria:
If there are more tents to answer, the next tent is shown
If there are no more tents to answer, the result is shown
The selected answers are stored
If no answer is selected, the user cannot submit

NOT in scope of this story: show result

Questions:
Does the order of the questions matter (random, per tent, ...)?
    => tent order is not random
What if the user cancels the test?
    => the answers are stored after each completed tent. if the student wants to restart the tent, they will have
to restart And what if some questions were already answered? - Can you take an incomplete test?
  => already answered questions will have to be retaken
What if the corresponding score is lower than the previous score, based on an answer given in a previous test?

Scenario: Next tent is shown if their are tents left
Given the student answered all questions
And there are more tents left to answers
When he submits his answers
Then the answers are stored
And the next tent is shown

Scenario: Result is shown if no tents left
Given the student answered all questions
And there is not a tent left to answer
When he submits his answers
Then the answers are stored
And the total result is shown

