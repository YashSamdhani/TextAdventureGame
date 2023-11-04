import java.util.*;

// Item class to represent items in the game
class Item 
{
    String name;
    String description;

    public Item(String name, String description) 
    {
        this.name = name;
        this.description = description;
    }
}

// Room class to represent game locations
class Room 
{
    String name;
    String description;
    List<Item> items = new ArrayList<>();
    Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description) 
    {
        this.name = name;
        this.description = description;
    }

    public void addExit(String direction, Room room) 
    {
        exits.put(direction, room);
    }

    public void addItem(Item item) 
    {
        items.add(item);
    }
}

// Player character class
class Adventurer 
{
    Room currentRoom;
    List<Item> inventory = new ArrayList<>();

    public Adventurer(Room startingRoom) 
    {
        currentRoom = startingRoom;
    }

    public void go(String direction) 
    {
        Room nextRoom = currentRoom.exits.get(direction);
        if (nextRoom != null) 
        {
            currentRoom = nextRoom;
            System.out.println("You go " + direction + " to the " + nextRoom.name);
            look();
        } 
        else
            System.out.println("You can't go that way.");
    }

    public void look() 
    {
        System.out.println(currentRoom.description);

        if (!currentRoom.items.isEmpty()) 
        {
            System.out.println("You see the following items:");
            for (Item item : currentRoom.items) 
            {
                System.out.println("- " + item.name + ": " + item.description);
            }
        }
    }

    public void take(String itemName) {
        for (Item item : currentRoom.items) {
            if (item.name.equalsIgnoreCase(itemName)) 
            {
                currentRoom.items.remove(item);
                inventory.add(item);
                System.out.println("You take the " + item.name);
                return;
            }
        }
        System.out.println("You can't find that item here.");
    }

    public void inventory() 
    {
        if (inventory.isEmpty()) 
        {
            System.out.println("Your inventory is empty.");
        } else 
        {
            System.out.println("Your inventory contains:");
            for (Item item : inventory) {
                System.out.println("- " + item.name + ": " + item.description);
            }
        }
    }
}

public class TextAdventureGame 
{
    public static void main(String[] args) 
    {
        // Create rooms and items
        Room start = new Room("Start", "You are in a starting room.");
        Room middle = new Room("Middle", "You are in the middle of the game.");
        Room end = new Room("End", "You have reached the end of the game.");
        
        Item sword = new Item("Sword", "A sharp, shiny sword.");
        Item key = new Item("Key", "An old, rusty key.");

        start.addExit("north", middle);
        middle.addExit("south", start);
        middle.addExit("east", end);
        middle.addItem(sword);
        middle.addItem(key);
        
        // Initialize the game
        Adventurer player = new Adventurer(start);

        // Game loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Text Adventure Game!");
        player.look();

        while (true) 
        {
            System.out.print("Enter a command (Go/Look/Take/Inventory/Quit): ");
            String command = scanner.nextLine().toLowerCase();

            if (command.startsWith("go ")) 
            {
                String direction = command.substring(3);
                player.go(direction);
            } else if (command.equals("look")) 
            {
                player.look();
            } else if (command.startsWith("take ")) 
            {
                String itemName = command.substring(5);
                player.take(itemName);
            } else if (command.equals("inventory")) 
            {
                player.inventory();
            } else if (command.equals("quit")) 
            {
                System.out.println("Thanks for playing!");
                break;
            } else 
            {
                System.out.println("Invalid command. Try again.");
            }
        }
        
        scanner.close();
    }
}
