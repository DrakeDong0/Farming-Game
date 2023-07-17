/**
 * The Inv class represents an inventory for a game.
 * It stores information about the items in the inventory,
 * such as the count of each item and provides methods to
 * manipulate the inventory.
 */

//import package and PApplet tools
package Persons;

import processing.core.PApplet;
import processing.core.PImage;

public class Inv {
  public PApplet app; // Reference to the PApplet object for drawing
  public PImage image; // Image representing the corns
  public PImage image2;// Image representing the grapes
  public PImage image3;
  public static int count = 1;
  public static int count1 = 1;
  public static int count2 = 1;
  public int corncount = 0; // Count of corn items in the inventory
  public int grapecount = 0; // Count of grape items in the inventory
  public int strawberrycount = 0;

  /**
   * Constructs an inventory object.
   *
   * @param p The PApplet object used for drawing.
   */
  public Inv(PApplet p) {
    this.app = p;// constructs the images
    this.image = app.loadImage("PlantPictures/corn0.png");
    this.image2 = app.loadImage("PlantPictures/grape0.png");
    this.image3 = app.loadImage("PlantPictures/strawberry0.png");
  }

  /**
   * Decreases the count of the current item in the inventory by 1.
   * If the count is already 0, nothing happens.
   */
  public void minusCorn() {
    if (corncount > 0) {// subtracts the corn if the user has any remaining
      corncount -= 1;
      count -= 1;// removes it from the inventory
    }
  }

  /**
   * Decreases the count of the current item in the inventory by 1.
   * If the count is already 0, nothing happens.
   */
  public void minusGrape() {
    if (grapecount > 0) {// subtracts the grape if the user has any remaining
      grapecount -= 1;
      count1 -= 1;// removes it from the inventory
    }
  }

  /**
   * Decreases the count of the current item in the inventory by 1.
   * If the count is already 0, nothing happens.
   */
  public void minusStrawberry() {
    if (strawberrycount > 0) {// subtracts the strawberry if the user has any remaining
      strawberrycount -= 1;
      count2 -= 1;// removes it from the inventory
    }
  }

  /**
   * Draws the inventory image and the count of the current item.
   */
  public void draw() {
    // draws the inventory and item count
    app.image(image, 2, 180);
    app.image(image2, 7, 240);
    app.image(image3, 2, 280);
    app.textSize(15);
    app.text("" + corncount, 35, 225);
    app.text("" + grapecount, 35, 280);
    app.text("" + strawberrycount, 35, 330);
  }

  /**
   * Returns the count of the corn item in the inventory.
   *
   * @return The count of the current item.
   */
  public int returnCornCount() {
    return corncount;// returns the number of corn
  }

  /**
   * Returns the count of the grape item in the inventory.
   *
   * @return The count of the current item.
   */
  public int returnGrapeCount() {
    return grapecount;// returns the number of grape
  }

  /**
   * Returns the count of the strawberries n the inventory.
   *
   * @return The count of the current item.
   */
  public int returnStrawberryCount() {
    return strawberrycount;// returns the number of strawberry
  }

  /**
   * Checks if the inventory contains any corn.
   *
   * @return True if the inventory contains at least one item, false otherwise.
   */
  public boolean countCorn() {
    if (corncount > 0) {// returns true if there are still corn remaining
      return true;
    }
    return false;
  }

  /**
   * Checks if the inventory contains any grapes.
   *
   * @return True if the inventory contains at least one item, false otherwise.
   */
  public boolean countGrape() {
    if (grapecount > 0) {// returns true if there are still corn remaining
      return true;
    }
    return false;
  }

  /**
   * Checks if the inventory contains any strwaberries.
   *
   * @return True if the inventory contains at least one item, false otherwise.
   */
  public boolean countStrawberry() {
    if (strawberrycount > 0) {// returns true if there are still corn remaining
      return true;
    }
    return false;
  }

  /**
   * Adds a new item to the inventory.
   *
   * @param item The name of the item to be added.
   */
  public void addItem(String item) {
    if (item.equals("Corn")) {
      String[] items = new String[count];// inits a new array to store number of items
      items[items.length - 1] = "Corn";// adds a corn each time this method is called
      corncount = items.length; // changes the array size to the number of items
      count++;// increases the array size by one to store the next item
    } else if (item.equals("Grape")) {
      String[] items1 = new String[count1];// inits a new array to store number of items
      items1[items1.length - 1] = "Grape";// adds a corn each time this method is called
      grapecount = items1.length; // changes the array size to the number of items
      count1++;// increases the array size by one to store the next item
    } else if (item.equals("Strawberry")) {
      String[] items2 = new String[count2];// inits a new array to store number of items
      items2[items2.length - 1] = "Strawberry";// adds a corn each time this method is called
      strawberrycount = items2.length; // changes the array size to the number of items
      count2++;// increases the array size by one to store the next item
    }

  }

}