
//import classes and tools
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Date;
import java.io.*;
import java.util.Scanner;
import Plants.Plant;
import Persons.Person;
import Plants.Corn;
import Plants.Grape;
import Plants.Strawberry;

/**
 * 
 * The Sketch class represents a gardening game implemented using the Processing
 * library.
 * It extends the PApplet class and includes methods and variables to handle
 * various game functionalities.
 */
public class Sketch extends PApplet {
  // Initialize all variables, player and images
  Person P1;
  boolean end = false;
  boolean day = true;
  int screen = 0;
  int xsize = 140;
  int ysize = 38;
  int bal = 500;
  int timex = 0;
  int time = 0;
  int daynum = 0;
  int mn;
  String mousetype = "default";
  String mousecrop = "corn";
  String username;
  Plant[][] map = new Plant[10][4];
  PImage bg;
  PImage dirt;
  PImage store;
  PImage storescreen;
  PImage returnp;
  PImage inv;
  PImage watercan;
  PImage fert;
  PImage shovel;
  PImage bed;
  PImage exit;
  PImage sun;
  PImage moon;
  PImage corn0;
  PImage corn1;
  PImage corn2;
  PImage corn3;
  PImage corn4;
  PImage corn5;
  PImage sleepscreen;
  PImage cursor;
  PImage endscreen;
  PImage scores;
  PImage savebutton;
  PImage water;
  PImage sickle;
  PImage grape0;
  PImage grape1;
  PImage grape2;
  PImage grape3;
  PImage grape4;
  PImage grape5;
  PImage strawberry0;
  PImage strawberry1;
  PImage strawberry2;
  PImage strawberry3;
  String bgString = "";

  /**
   * 
   * Sets the size of the sketch window.
   */

  public void settings() {
    size(500, 500);
  }

  /**
   * 
   * Advances the game to the next day by changing the background image based on
   * the current day number.
   */
  public void nextDay() {
    // increases day number by 1
    daynum += 1;
    // If statements to see if the day is in a range of corresponding seasons
    if (daynum <= 15) {// 15
      // sets the variable to the imagepath of the background
      bgString = "Pictures/savana.jpg";
    } else if (daynum > 15 && daynum <= 30) {
      // sets the variable to the imagepath of the background
      bgString = "Pictures/desert.jpg";
    } else if (daynum > 30 && daynum <= 45) {
      // sets the variable to the imagepath of the background
      bgString = "Pictures/fall.jpg";
    } else if (daynum > 60) {
      // sets the variable to the imagepath of the background
      bgString = "Pictures/snow.jpg";
    }
    // loads the background
    bg = loadImage(bgString);
  }

  /**
   * 
   * Calculates the season based on the given day number.
   * 
   * @param daynum The current day number.
   * @return The season corresponding to the given day number.
   */
  public String seasoncalc(int daynum) {
    // similar to the above, the season is found by matching the daynum. It then
    // return's the season as a string
    if (daynum <= 15) {
      return "Spring";
    } else if (daynum > 15 && daynum <= 30) {
      return "Summer";
    } else if (daynum > 30 && daynum <= 45) {
      return "Fall";
    } else if (daynum > 45) {
      return "Winter";
    } else {
      // otherwise, return blank
      return "";
    }
  }

  /**
   * 
   * Prints the contents of a file recursively.
   * 
   * @param filePath The path to the file to be printed.
   */
  public static void printFileContents(String filePath) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("scores.txt")); // Create a new BufferedReader to read
      String line;
      while ((line = reader.readLine()) != null) { // Read each line of the file until the end
        System.out.println(line); // Print the current line
      }
      reader.close(); // Close the BufferedReader
    } catch (IOException e) {
      e.printStackTrace(); // Print the stack trace if an exception occurs while reading the file
    }
  }

  /**
   * 
   * All of the mouse interactions
   * 
   */
  public void mousePressed() {
    // If the mouse clicks the store, change the screen
    if (mouseX >= 425 && mouseX <= 490 && mouseY >= 440 && mouseY <= 480 && screen == 0) {
      screen = 1;
    }
    // Back button for the store screen
    if (mouseX >= 5 && mouseX <= 70 && mouseY >= 10 && mouseY <= 45 && screen == 1) {
      screen = 0; // sets the screen back to the main page and recalls background
      background(bg);
      ysize = 38;
    }
    // end button
    if (mouseX > 425 && mouseX < 480 && mouseY > 90 && mouseY < 110 && screen == 0) {
      // sets the end variable true, stopping the program from relooping
      end = true;
      screen = 3; // change to end screen
    }
    // sickle inventory item
    if (mouseX > 10 && mouseX < 50 && mouseY > 135 && mouseY < 170 && screen == 0) {
      mousetype = "sickle"; // changes cursor to a sickle
    }
    // corn seeds inventory item
    if (mouseX > 5 && mouseX < 50 && mouseY > 185 && mouseY < 225 && screen == 0 && P1.getInv().countCorn() == true) {
      mousetype = "corn"; // changes cursor to a corn
    }
    // strawberry seed inventory item
    if (mouseX > 5 && mouseX < 50 && mouseY > 295 && mouseY < 330 && screen == 0
        && P1.getInv().countStrawberry() == true) {
      mousetype = "strawberry";
    }
    // grape seed inventory item
    if (mouseX > 5 && mouseX < 50 && mouseY > 230 && mouseY < 270 && screen == 0 && P1.getInv().countGrape() == true) {
      mousetype = "grape";
    }
    // Sleep button
    if (mouseX > 425 && mouseX < 500 && mouseY > 315 && mouseY < 380 && screen == 0) {
      day = false; // turns day variable off
    }
    // watering can inventory item
    if (mouseX > 5 && mouseX < 40 && mouseY > 80 && mouseY < 120 && screen == 0) {
      mousetype = "water"; // changes cursor to a watering can
    }
    // default cursor
    if (mouseX > 60 && mouseX < 90 && mouseY > 225 && mouseY < 300 && screen == 0) {
      mousetype = "default"; // changes cursor back to original
    }
    // print scores button on end screen
    if (mouseX > 310 && mouseX < 410 && mouseY > 305 && mouseY < 340 && screen == 3) {
      // calls the method to recursively print the scores
      printFileContents("scores.txt");
    }
    // save score button on end screen
    if (mouseX > 115 && mouseX < 210 && mouseY > 305 && mouseY < 335 && screen == 3) {
      try {
        int profit = bal - 500; // calculates profit
        // initializes filewriter and printwriter
        FileWriter Writer = new FileWriter("scores.txt", true);
        PrintWriter PrintWriter = new PrintWriter(Writer);
        // writes into the file
        PrintWriter.print("\n" + username + "," + profit + "," + daynum);
        System.out.println("Score Saved!"); // confirmation message
        PrintWriter.close(); // closes the printwriter
      } catch (IOException ioException) { // error catchung
        System.out.println("Error: " + ioException);// prints out the error
      }
    }
    // buy corn button
    if (mouseX > 60 && mouseX < 110 && mouseY > 270 && mouseY < 300 && screen == 1 && bal > 0) {
      P1.getInv().addItem("Corn"); // adds corn to the user's inventory
      bal -= 20; // subtracts balance
      System.out.println("Corn Seed Purchased!");
    }
    // buy grape button
    if (mouseX > 205 && mouseX < 240 && mouseY > 280 && mouseY < 305 && screen == 1 && bal > 0) {
      P1.getInv().addItem("Grape"); // adds corn to the user's inventory
      bal -= 30; // subtracts balance
      System.out.println("Grape Seed Purchased!");
    }
    // buy strawberry button
    if (mouseX > 360 && mouseX < 400 && mouseY > 275 && mouseY < 305 && screen == 1 && bal > 0) {
      P1.getInv().addItem("Strawberry");
      bal -= 10;
      System.out.println("Strawberry Seed Purchased!");
    }
    // night screen
    if (screen == 2) {
      nextDay(); // adds one to the day count
      timex = 0; // resets the daily time
      screen = 0; // goes to home page
      day = true; // sets day as true and reruns background
      background(bg);
    }
    // checks if the user is holding a watering can
    if (screen == 0 && mousetype.equals("water")) {
      for (int i = 0; i < map.length; i++) { // double for loop to iterate through each plant object
        for (int j = 0; j < map[i].length; j++) {
          if (map[i][j].isClicked(mouseX, mouseY)) { // checks if it is clicked
            if (map[i][j] instanceof Corn) { // checks if it is a corn object
              Corn k = (Corn) map[i][j]; // declares the reference item as a corn
              k.water(daynum); // calls the water method with the current date
            } else if (map[i][j] instanceof Grape) {
              Grape s = (Grape) map[i][j];
              s.water(daynum);
            } else if (map[i][j] instanceof Strawberry) {
              Strawberry gh = (Strawberry) map[i][j];
              gh.water(daynum);
            }
          }
        }
      }
    }
    // checks if user is holding a sickle
    if (screen == 0 && mousetype.equals("sickle")) {
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          int xx = map[i][j].getX();// gets x coordinate of plant
          int yy = map[i][j].getY();// gets y coordinate of plant
          if (map[i][j].isClicked(mouseX, mouseY)) {
            if (map[i][j] instanceof Corn) {
              Corn jn = (Corn) map[i][j];
              if (jn.matureCheck() == true) {
                bal += 80;
                jn.harvest();
                map[i][j] = new Plant(this, xx, yy, daynum);
              }
            } else if (map[i][j] instanceof Grape) {
              Grape jn = (Grape) map[i][j];
              if (jn.matureCheck() == true) {
                bal += 15;
                jn.harvest();
                map[i][j] = new Plant(this, xx, yy, daynum);
              }
            } else if (map[i][j] instanceof Strawberry) {
              Strawberry jn = (Strawberry) map[i][j];
              if (jn.matureCheck() == true) {
                bal += 15;
                jn.harvest();
                map[i][j] = new Plant(this, xx, yy, daynum);
              }
            }
          }
        }
      }
    }
    // If the user is holding a seed
    if (screen == 0 && mousetype.equals("corn") || mousetype.equals("grape") || mousetype.equals("strawberry")) {
      // double for loop to iterate through each plant object
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          if (map[i][j].isClicked(mouseX, mouseY)) {// checks if it is clicked
            if (mousetype.equals("default")) {// checks if the user is on the cursor
              System.out.println(map[i][j].getInfo()); // prints out the plant's info
            }
            int xx = map[i][j].getX();// gets x coordinate of plant
            int yy = map[i][j].getY();// gets y coordinate of plant
            // checks if the user is holding corn seeds and that the object is not already a
            // corn
            if (mousetype.equals("corn") && map[i][j].cropCheck() == false) {
              map[i][j] = new Corn(this, xx, yy, daynum); // plants a corn at the location
              P1.getInv().minusCorn(); // subtracts 1 corn from inventory
            }
            // Grape
            if (mousetype.equals("grape") && map[i][j].cropCheck() == false) {
              map[i][j] = new Grape(this, xx, yy, daynum); // plants a grape at the location
              P1.getInv().minusGrape(); // subtracts 1 grape from inventory
            }
            if (mousetype.equals("strawberry") && map[i][j].cropCheck() == false) {
              map[i][j] = new Strawberry(this, xx, yy, daynum); // plants a strawberry at the location
              P1.getInv().minusStrawberry(); // subtracts 1 strawberry from inventory
            }
          }
        }
      }
    }
  }

  /**
   * 
   * setup method that is run once before the program
   * 
   */
  public void setup() {
    frameRate(10);// sets framerate to 10
    P1 = new Person(this); // creates a new player object
    Scanner Scanner = new Scanner(System.in); // opens scanner
    System.out.println("Enter your username: "); // gets username and stores it as a variable
    username = Scanner.nextLine();
    P1.addName(username); // adds the username to the player object
    System.out.println("Welcome to the garden, " + username);

    // loads images
    endscreen = loadImage("Pictures/endscreen.png");
    savebutton = loadImage("Pictures/savebutton.png");
    scores = loadImage("Pictures/scores.png");
    dirt = loadImage("Pictures/dirt.png");
    store = loadImage("Pictures/store.png");
    storescreen = loadImage("Pictures/storescreen.png");
    returnp = loadImage("Pictures/return.jpg");
    sickle = loadImage("Pictures/sickle.png");
    inv = loadImage("Pictures/inv.png");
    watercan = loadImage("Pictures/watercan.png");
    fert = loadImage("Pictures/fert.png");
    shovel = loadImage("Pictures/shovel.png");
    bed = loadImage("Pictures/bed.png");
    exit = loadImage("Pictures/exit.png");
    sun = loadImage("Pictures/sun.png");
    moon = loadImage("Pictures/moon.png");
    sleepscreen = loadImage("Pictures/sleepscreen.png");
    cursor = loadImage("Pictures/cursor.png");
    corn0 = loadImage("PlantPictures/corn0.png");
    corn1 = loadImage("PlantPictures/corn1.png");
    corn2 = loadImage("PlantPictures/corn2.png");
    corn3 = loadImage("PlantPictures/corn3.png");
    corn4 = loadImage("PlantPictures/corn4.png");
    corn5 = loadImage("PlantPictures/corn5.png");
    water = loadImage("PlantPictures/water.png");
    grape0 = loadImage("PlantPictures/grape0.png");
    grape1 = loadImage("PlantPictures/grape1.png");
    strawberry0 = loadImage("PlantPictures/strawberry0.png");

    // Double for loop that creates all of the plant objects at different locations
    // in a grid
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = new Plant(this, xsize, ysize, daynum);// creates new plant at each spot
        xsize += 65; // moves the next plant 65 pixels over
      }
      ysize += 45; // moves the next row down 45 pixels
      xsize = 140; // resets the columns to the beginning
    }
    ysize = 0;// resets the rows to the beginning
    bg = loadImage("Pictures/savana.jpg"); // loads background once
    background(bg);
  }

  /**
   * 
   * Draw program that loops continously, displaying all of the graphics
   * 
   */
  public void draw() {
    timex += 1; // counts once every time it is refreashed, meaning 10 times a second
    double time = timex / 10; // calculate seconds passed
    double timey = 60.0 - time; // calculates day timer
    if (mousetype.equals("water")) {// sets the cursor to watercan
      cursor(watercan);
    }
    if (mousetype.equals("default")) {// sets the cursor to default
      cursor(cursor);
    }
    if (mousetype.equals("sickle")) {// sets the cursor to sickle
      cursor(sickle);
    }
    if (mousetype.equals("corn")) {// sets the cursor to corn
      if (P1.getInv().returnCornCount() < 1) {// returns the cursor back to default if user has no corn remaining
        mousetype = "default";
      }
      cursor(corn0);// otherwise, sets the cursor to corn
    }

    if (mousetype.equals("grape")) {// sets the cursor to grape
      if (P1.getInv().returnGrapeCount() < 1) {// returns the cursor back to default if user has no grapes remaining
        mousetype = "default";
      }
      cursor(grape0);
    }

    if (mousetype.equals("strawberry")) {// sets the cursor to strawberry
      if (P1.getInv().returnStrawberryCount() < 1) {// returns the cursor back to default if user has no strawberries
                                                    // remaining
        mousetype = "default";
      }
      cursor(strawberry0);
    }

    if (daynum > 60) {// ends the game once daynum passes 60
      screen = 3;
    }
    if (timey < 0) {// forces the user to sleep once the day is passed
      screen = 2;
    }
    if (end == true) {// ends the game by stopping the draw loop
      noLoop();
    }
    String seasonx = seasoncalc(daynum); // calculates the season using the seasoncalc method
    if (screen == 1) {// Store screen
      // displays all of the items and images of the store
      image(storescreen, 0, -30);
      textSize(20);
      text("Balance: $" + bal, 320, 100);
      textSize(15);
      text("Corn Seeds", 45, 230);
      text("$20", 55, 250);
      text("Grape Seeds", 180, 230);
      text("$30", 200, 250);
      text("Strawberry Seeds", 320, 230);
      text("$10", 350, 250);
      image(strawberry0, 350, 260);
      image(returnp, 0, 0);
      image(fert, 50, 95);
      image(shovel, 75, 75);
      image(corn0, 60, 260);
      image(grape0, 200, 270);
    }
    if (screen == 2) {// Sleep screen
      // displays all of the images of the sleep screen
      image(sleepscreen, 0, 0);
      textSize(30);
      text("Click anywhere to continue...", 45, 400);
      textSize(15);
    }
    if (screen == 3) {// end game screen
      int profit = bal; // calculates profit
      // displays all of the images of the end screen
      image(endscreen, 0, 0);
      textSize(30);
      text("Thanks for playing, " + username, 100, 100);
      text("Final Balance: $" + profit, 120, 160);
      text("Day: " + daynum, 150, 220);
      image(scores, 300, 300);
      image(savebutton, 100, 290);
    }
    if (screen == 0) { // Main screen
      background(bg);// calls background
      // displays all of the images of the main screen
      text("Balance: $" + bal, 10, 20);
      text("Day: " + daynum, 130, 20);
      text("Season: " + seasonx, 210, 20);
      text("Time: " + timey, 330, 20);
      image(store, 420, 420);
      image(inv, 0, 75);
      image(watercan, 5, 75);
      image(bed, 410, 300);
      image(exit, 425, 90);
      image(cursor, 60, 220);
      image(sickle, 10, 125);
      if (day) {// if it is daytime, display the sun
        image(sun, 445, 0);
      } else if (day == false) {// otherwise, go to sleep screen
        screen = 2;
      }
      for (int i = 0; i < map.length; i++) {// double for loop to access each plant object and draws it and grows it
        for (int j = 0; j < map[i].length; j++) {
          if (map[i][j] instanceof Corn) {// checks if object is corn
            Corn p = (Corn) map[i][j];
            p.grow(daynum);// grows it with the current date
            p.draw();
          } else if (map[i][j] instanceof Grape) {
            Grape t = (Grape) map[i][j];
            t.grow(daynum);
            t.draw();
          } else if (map[i][j] instanceof Strawberry) {
            Strawberry w = (Strawberry) map[i][j];
            w.grow(daynum);
            w.draw();
          } else {
            map[i][j].draw();// otherwise, draw the dirt mount
          }
        }
      }
      P1.getInv().draw();// draws the user's inventory
    }
  }
}