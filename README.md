# TextAdventureGame
## A Text-Based Adventure Game
An interesting game built using Java and Data Structures is where the player follows the commands given to them.  

The game has a central character called the "Adventurer", i.e., the player. The role of the adventurer is to type the commands, which consist of one or two words.

### Item class:

Purpose: Represents items that can be found in the game world.
Functionality: Contains two properties, name and description, to store the item's name and description.

### Room class:

Purpose: Represents locations or rooms within the game world.
Functionality:
- Contains properties for name, description, a list of items present in the room, and a map of exits to other rooms.
- The addExit method is used to add a connection (exit) from the current room to another room in a specific direction.
- The addItem method is used to add items to the room.

### Adventurer class:

Purpose: Represents the player's character within the game.
Functionality:
- Contains properties for the currentRoom, which keeps track of the room the adventurer is in, and an inventory to store collected items.
- The go method allows the adventurer to move to another room in a specified direction.
- The look method displays the current room's description and any items present.
- The take method lets the adventurer pick up items from the current room and add them to their inventory.
- The inventory method displays the contents of the adventurer's inventory.

### TextAdventureGame class:

Purpose: Serves as the main class for the game.
Functionality:
- Creates instances of rooms, items, and the adventurer.
- Sets up the game world by defining room connections and item placements.
- Initiates the game loop, where the player can input commands.
- Handles player input, such as "Go," "Look," "Take," "Inventory," and "Quit."
- Prints messages and updates the game state accordingly.
