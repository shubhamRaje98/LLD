Design a Snake and Ladder game

Requirements:
#### Multiplayer Game 
#### Customizable Board in terms of snake and ladder placement and board size.
#### When the Game board Loads it should:
    A. Load the configured Board size.
    B. Load the configured snake and ladder
    C. Load the configured number of dice.
    D. Load the number of players who will play the game and all players should be at starting location.

### Points to Discuss:
- Should CurrentCell should be part of player entity?
  - Yes: here player is contextual entity in a snake and ladder game. So the entity should hold contextual info directly related to it.
  - No: If it is general entity it could be used in other games simultaneously.

- Should we create classes of Snake and Ladder or simple use a map (Trade off)
  - Snake and ladder class: they bring Object Oriented modeling but makes the code unnecessarily big, and memory heavy too, if their only function is to map one cel to another.
  - Map: If the only function is to map one cell to another can use Map, keeps things easy and resource friendly.
