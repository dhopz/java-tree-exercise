package tree.exercise;

import java.util.HashMap;

public class Tree {

  public int height;
  private int foodReserves;
  public int[] positionInForest;
  private String species;

  //Determines the height of the Tree
  private HashMap<String,Integer> treeLimits = new HashMap<String,Integer>();

  //Constructor Method for creating a Tree
  public Tree(String species, int posX, int posY) {
    this.species = species;
    this.positionInForest = new int[2];
    this.positionInForest[0] = posX;
    this.positionInForest[1] = posY;
    System.out.printf("I am a born %s tree\n", this.species);
    System.out.printf("This is my position in forest %s, %s \n\n", posX, posY);
    treeLimits.put("Pine",1);
    treeLimits.put("Cedar",2);
    treeLimits.put("Juniper",20);
    treeLimits.put("Fir",5);
    treeLimits.put("Cypress",10);
    treeLimits.put("Redwood",10);
    treeLimits.put("Sequoia",10);
    treeLimits.put("Yew",10);
    treeLimits.put("Hemlock",10);
    treeLimits.put("Oak",10);
}


  public void grow() {
    // System.out.printf("%s \n",treeLimits.get(this.species));
      // if (this.foodReserves >= treeLimits.get(this.species)) { 
      if (this.foodReserves >= 20) { 
          this.foodReserves = 0; // After growing, the excess of nutrients is lost
          this.height++;
          if(isMature()) {
            System.out.printf("I am a healthy %s tree\n", this.species);
            System.out.printf("This is my height %s \n", this.height);
            
          }
      }
  }

  public void photosynthesise() {
      this.foodReserves++;
  }

  public Boolean isMature() {
    return this.height > 20;
  }

  // Getters and Setters ommited (explained in lesson 5 Encapsulation)
}