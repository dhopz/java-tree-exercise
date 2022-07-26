package tree.exercise;

public class Tree {

  private int height;
  private int foodReserves;
  private int[] positionInForest;
  private String species;


  public Tree(String species, int posX, int posY) {
    this.species = species;
    this.positionInForest = new int[2];
    this.positionInForest[0] = posX;
    this.positionInForest[1] = posY;
    System.out.printf("I am a born %s tree\n", this.species);
}

  public void grow() {
      if (this.foodReserves > GROWTHRATE[this.species]) {
          this.foodReserves = 0; // After growing, the excess of nutrients is lost
          this.height++;
          if(isMature()) {
            System.out.printf("I am a healthy %s tree\n", this.species);
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