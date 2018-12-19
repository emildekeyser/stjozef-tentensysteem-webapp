Feature: Story 02. Show questions with their Answers
Narrative:
As a student
I want to see all answers for each question per tent
In order to choose an appropriate answer

Acceptance Criteria:
For every tent, the following is shown:
The tent the questions belong to
All the questions from that tent
The possible answers for each question
The possible answers are shown in a random order

Scenario Outline: Show questions with their answers per tent
Given I can see <tent>
Then the questions are shown
And its answers are shown
  Examples:
    | tent            |
    | Problem Solving |
    | Perseverance    |
    | Team Spirit     |



