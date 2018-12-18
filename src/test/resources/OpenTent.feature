Story 02. Open tent
Narrative:
As a student
I want to click a tent
In order to see all my questions in this tent

Acceptance Criteria:
-    I can select do do a test on 1 tent
-    I can select do do a test on all tents
-    I can select do do a test on some tents

Scenarios:
Scenario: Select one tent
Given the tents 'Problem Solving', 'Perseverance' and 'Team Spirit' are registered in the app
When the student clicks on 'Perseverance'
Then all questions of the tent 'Perseverance'  are shown one by one

Scenario: Select all tents
Given the tents 'Problem Solving', 'Perseverance' and 'Team Spirit' are registered in the app
When the student clicks on 'Full test'
Then all questions of all tents are shown one by one

Scenario: Select some tents
Given the tents 'Problem Solving', 'Perseverance' and 'Team Spirit' are registered in the app
When the student clicks on 'Problem Solving'' and 'Team Spirit'
Then all questions of 'Problem Solving'' and 'Team Spirit' are shown one by one

Wireframes:




