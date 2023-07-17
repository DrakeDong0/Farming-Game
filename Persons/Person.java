/**
 * The Person class represents a person in a game.
 * It stores information about the person, such as their name and inventory,
 * and provides methods to manipulate and access this information.
 */
//import package
package Persons;

import processing.core.PApplet;
import processing.core.PImage;

public class Person {
  public PApplet app;// Reference to the PApplet object for drawing
  public static int player_num = 0; // Total number of players
  public static final String DEFAULT_NAME = "USER"; //default name
  public Inv inventory; // Inventory of the person
  public String name; //name of the person
/**
     * Constructs a Person object with a default name and initializes the inventory.
     *
     * @param k The PApplet object used for drawing.
     */
  public Person(PApplet k) {
    this.name = DEFAULT_NAME;
    this.app = k;
    inventory = new Inv(k);
    player_num++;
  }
 /**
     * Override constructor that constructs a Person object with the specified name and initializes the inventory.
     *
     * @param k    The PApplet object used for drawing.
     * @param name The name of the person.
     */
  public Person(PApplet k, String name) {
    this.name = name;
    this.app = k;
    inventory = new Inv(k);
    player_num++;
  }
/**
     * Sets the name of the person.
     *
     * @param name The name to set.
     */
  public void addName(String name) {
    this.name = name;
  }
/**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
  public String getName() {
    return name;
  }
 /**
     * Returns the inventory of the person.
     *
     * @return The inventory object.
     */
  public Inv getInv() {
    return inventory;
  }
}