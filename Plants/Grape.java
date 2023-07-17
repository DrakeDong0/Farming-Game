/**

The Grape class represents a specific type of plant called Grape.
It inherits properties and methods from the Plant class and adds additional functionality specific to Grape.
*/
//import package
package Plants;

import processing.core.PApplet;
import processing.core.PImage;

//Grape is a child class of Plant
public class Grape extends Plant {
  public static int limit = 6; // The maximum growth limit for Grape plants
  boolean growing = true; // Indicates if the grape is currently growing
  boolean watered = false; // Indicates if the crop is watered

  /**
   * 
   * Constructs a new grape object.
   * 
   * @param p         The PApplet instance
   * @param x         The x-coordinate of the grape
   * @param y         The y-coordinate of the grape
   * @param startdate The start date of the grape
   */
  public Grape(PApplet p, int x, int y, int startdate) {
    // super's the parent class's variables
    super(p, x, y, startdate);
    // sets the grape images
    this.image = app.loadImage("PlantPictures/grape1.png");
    this.waterimage = app.loadImage("PlantPictures/water.png");
  }

  /**
   * 
   * Returns information about the grape plant.
   * 
   * @return A string containing information about the grape plant
   */
  public String getInfo() {
    // returns crop data
    String str1 = Integer.toString(startdate);
    return "This crop was grown on day " + str1;
  }

  /**
   * 
   * Checks if the grape plant is grape
   * 
   * @return true if the grape plant is a grape, false otherwise
   */
  public boolean cropCheck() {
    return true;
  }

  /**
   * 
   * Checks if the grape is mature
   * 
   * @return true if the crop is ready to be harvested
   */
  public boolean matureCheck() {
    if (growing == false) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 
   * Waters the plant
   * 
   */
  public void water(int daynum) {
    watered = true;
  }

  /**
   * 
   * Draws the grape plant on the screen.
   */
  public void draw() {
    app.image(image, x + 10, y + 10);
    // draws the water icon if crop isn't watered
    if (watered == false) {
      app.image(waterimage, x + 10, y + 10);
    }
  }

  /**
   * 
   * Harvests the crop
   */
  public void harvest() {
    // harvests the crop if it has stopped growing. Replaces it with a dirt picture
    if (growing == false) {
      this.image = app.loadImage("Pictures/dirt.png");
    }
  }

  /**
   * 
   * Grows the grape plant based on the given day number.
   * 
   * @param daynum The current day number
   */
  public void grow(int daynum) {
    // daynumx is the number of days the crop has been alive for
    int daynumx = daynum - startdate;
    // number is modded by 5 to get the remainder. This is used to calculate which
    // growth stage it is on
    int n = daynumx % 6;
    // only grows if it is watered and new
    if (growing && watered) {
      // Each case displays a different growth stage image
      if (n == 0) {
        this.image = app.loadImage("PlantPictures/grape1.png");
      }
      if (n == 1) {
        this.image = app.loadImage("PlantPictures/grape2.png");
      }
      if (n == 2) {
        this.image = app.loadImage("PlantPictures/grape3.png");
      }
      if (n == 3) {
        this.image = app.loadImage("PlantPictures/grape4.png");
      }
      if (n == 4) {
        this.image = app.loadImage("PlantPictures/grape5.png");
      }
      if (n == 5) {
        // once it has reached the final stage, the image stops changing and growing is
        // turned false
        this.image = app.loadImage("PlantPictures/grape0.png");
        growing = false;
      }
    }
  }

  /**
   * 
   * Returns a string representation of the grape plant.
   * 
   * @return A string representation of the grape plant
   */
  @Override
  public String toString() {
    String old = super.toString();
    return old + "This plant is a grape";
  }
}