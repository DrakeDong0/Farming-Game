/**

The Corn class represents a specific type of plant called Corn.
It inherits properties and methods from the Plant class and adds additional functionality specific to Corn.
*/
//import package
package Plants;
 
import processing.core.PApplet;
import processing.core.PImage;

//Corn is a child class of Plant
public class Corn extends Plant {
  public static int limit = 6; // The maximum growth limit for Corn plants
  boolean growing = true; // Indicates if the Corn is currently growing
  boolean watered = false; //Indicates if the crop is watered

  /**
   * 
   * Constructs a new Corn object.
   * 
   * @param p         The PApplet instance
   * @param x         The x-coordinate of the Corn
   * @param y         The y-coordinate of the Corn
   * @param startdate The start date of the Corn
   */
  public Corn(PApplet p, int x, int y, int startdate) {
    //super's the parent class's variables
    super(p, x, y, startdate);
    //sets the corn images
    this.image = app.loadImage("PlantPictures/corn1.png");
    this.waterimage = app.loadImage("PlantPictures/water.png");
  }

  /**
   * 
   * Returns information about the Corn plant.
   * 
   * @return A string containing information about the Corn plant
   */
  public String getInfo() {
    //returns crop data
    String str1 = Integer.toString(startdate);
    return "This crop was grown on day " + str1;
  }

  /**
   * 
   * Checks if the Corn plant is corn
   * 
   * @return true if the Corn plant is a corn, false otherwise
   */
  public boolean cropCheck() {
    return true;
  }
   /**
   * 
   * Checks if the corn is mature
   * @return true if the crop is ready to be harvested
   */
  public boolean matureCheck(){
    if (growing == false){
      return true;
    }
    else{
      return false;
      }
  }
 /**
   * 
   * Waters the plant
   * 
   */
  public void water(int daynum){
    watered = true;
  }
  /**
   * 
   * Draws the Corn plant on the screen.
   */
  public void draw() {
    app.image(image, x, y);
    //draws the water icon if crop isn't watered
    if (watered == false){
      app.image(waterimage,x+10,y+10);
    }
  }
  /**
   * 
   * Harvests the crop
   */
  public void harvest(){
    System.out.println("x");
    //harvests the crop if it has stopped growing. Replaces it with a dirt picture
    if (growing == false){
      this.image = app.loadImage("Pictures/dirt.png");
    }
  }
  /**
   * 
   * Grows the Corn plant based on the given day number.
   * 
   * @param daynum The current day number
   */
  public void grow(int daynum) {
    //daynumx is the number of days the crop has been alive for
    int daynumx = daynum - startdate;
    //number is modded by 5 to get the remainder. This is used to calculate which growth stage it is on
    int n = daynumx % 5;
    //only grows if it is watered and new
    if (growing && watered) {
      //Each case displays a different growth stage image
      if (n == 0) {
        this.image = app.loadImage("PlantPictures/corn1.png");
      }
      if (n == 1) {
        this.image = app.loadImage("PlantPictures/corn2.png");
      }
      if (n == 2) {
        this.image = app.loadImage("PlantPictures/corn3.png");
      }
      if (n == 3) {
        this.image = app.loadImage("PlantPictures/corn4.png");
      }
      if (n == 4) {
        //once it has reached the final stage, the image stops changing and growing is turned false
        this.image = app.loadImage("PlantPictures/corn5.png");
        growing = false;
      }
    }
  }

  /**
   * 
   * Returns a string representation of the Corn plant.
   * 
   * @return A string representation of the Corn plant
   */
  @Override
  public String toString() {
    String old = super.toString();
    return old + "This plant is a corn";
  }
}