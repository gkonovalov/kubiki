## Kubiki Game

Kubiki is a timeless puzzle game where players must manage falling pieces called "shapes." The primary goal is to create complete horizontal lines of blocks to clear them from the game field. As lines are cleared, blocks above them fall down, and the player continues to work towards achieving the highest score possible.

The game is a compact 17.7KB and can be run on any PC with Java Runtime Environment (JRE) installed.

<p align="center">
  <img src="https://raw.githubusercontent.com/gkonovalov/kubiki/master/gameplay.gif" />
</p>

## Game Features
- **Shapes**: The game features different geometric shapes made up of four blocks each. These shapes fall from the top of the play field.
- **Movement and Rotation**: Players can move shapes laterally and rotate them to fit them into place. The falling speed of the pieces cannot be slowed down, but in most versions, players can accelerate their descent.
- **Objective**: The main objective is to arrange the shapes to form complete horizontal lines. When a line is completed, it disappears, causing any blocks above to fall down a rank.
- **Score Tracking**: Tracks the player’s score.
- **Speed Adjustment**: Increases game speed as lines are cleared.

### Controls
- **Enter**: To start the game.
- **↑**: Rotate shape.
- **←**: Move shape to the left.
- **→**: Move shape to the right.
- **↓**: Drop shape
- **Esc**: Exit the game.

## Running the Game
If you have the JAR file for the Kubiki game, you can launch it using the following steps:

1. **Download the JAR File**: Ensure you have the Kubiki JAR file. If you don’t have it, you can build it from the source code provided in this repository.
2. **Open a Terminal or Command Prompt**: Navigate to the directory where the JAR file is located.
3. **Run the JAR File**: Use the `java -jar` command to launch the game. For example:

   ```bash
   java -jar kubiki.jar

## Requirements
**JDK 8** or later.
**Swing** used for GUI components.

## Download
To clone the repository, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the directory where you want to clone the repository.
3. Run the following command:

   ```bash
   git clone https://github.com/gkonovalov/kubiki.git

------------
Georgiy Konovalov 2024 (c) [GNU GPLv3 License](https://opensource.org/license/gpl-3-0)