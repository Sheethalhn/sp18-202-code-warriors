04/07/2018 Team decided the game idea to be a BlackPanther remake which would be a war style game. 
Came up with the look of the game with image for World and Image for Actor (Black Panther - hero of the game). 
Implemented the movements of the actor Black Panther.

04/14/2018 Team met today and assigned a design pattern for each member. I will be implementing State Pattern. Discussed the use-case with the team members in today's team meeting. Started self study and research to implement the pattern in our game.

04/21/2018 Created initial level for the game where BlackPanther has to build his health and weapon counts and escape from dangers. Level is functioning partially. Requires some more work which I will be working on this week. Discussed the progress in team meeting. Team also discussed about a final level, so totally there will be 3 levels in the game.

04/23/2018 Made progress on level 0. Collecting crystal heart increases health score, while colliding with fireballs decreases it. Collecting swords increases swords count. BlackPanther is given a short time within which he can build up the scores and prepare for level1. Added welcome page for next level - level 1.

04/27/2018 Added increment and decrement logic for health and sword score using extension of observer pattern used. Sword shooting will stop at sword score 0. Need to decide with team game end logic. State Pattern will be implemented accordingly. Added and changed object images as required.

04/29/2018 Implemeted State Design Pattern for Game End logic. If health is zero then players loses and game ends, If score reaches 200 then player wins and game ends.

05/02/2018 Made changes to State pattern to have restart/play game state when player loses.
