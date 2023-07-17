//import package
package Plants;

import processing.core.PApplet;
import processing.core.PImage;

public class Plant {
  public int x; // The x-coordinate of the plant
  public int y; // The y-coordinate of the plant
  public PApplet app; // Reference to the PApplet instance
  public PImage image; // The image representing the plant
  public int startdate;// The start date of the plant
  public PImage waterimage; //Image reprenting the crop needs water

  /**
   * 
   * Constructs a new Plant object.
   * 
   * @param p      The PApplet instance
   * @param x      The x-coordinate of the plant
   * @param y      The y-coordinate of the plant
   * @param daynum The start date of the plant
   */
  public Plant(PApplet p, int x, int y, int daynum) {
    //constructs object
    this.app = p;
    this.x = x;
    this.y = y;
    this.startdate = daynum;
    this.image = app.loadImage("Pictures/dirt.png");
  }

  /**
   * 
   * Returns the x-coordinate of the plant.
   * 
   * @return The x-coordinate of the plant
   */
  public int getX() {
    return x;
  }

  /**
   * 
   * Returns the y-coordinate of the plant.
   * 
   * @return The y-coordinate of the plant
   */
  public int getY() {
    return y;
  }

  /**
   * 
   * Draws the plant on the screen.
   */
  public void draw() {
    app.image(image, x, y);
  }

  /**
   * 
   * Checks if the plant is ready to be cropped.
   * 
   * @return true if the plant is ready to be cropped, false otherwise
   */
  public boolean cropCheck() {
    return false;
  }

  /**
   * 
   * Returns information about the plant.
   * 
   * @return A string containing information about the plant
   */
  public String getInfo() {
    return "This is a dirt pile";
  }

  /**
   * 
   * Checks if the plant is clicked based on the given mouse coordinates.
   * 
   * @param mouseX The x-coordinate of the mouse
   * @param mouseY The y-coordinate of the mouse
   * @return true if the plant is clicked, false otherwise
   */
  public boolean isClicked(int mouseX, int mouseY) {
    if (mouseX > x && mouseX < x + 50 && mouseY > y && mouseY < y + 50) {
      return true;
    } else {
      return false;
    }
  }
}