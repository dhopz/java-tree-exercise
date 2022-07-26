package tree.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreeTest {

  @Test
  public void isMatureisFalseWhenInitialised()  {
    Tree tree = new Tree("Pine", 12, 15);
    assertFalse(tree.isMature());
  }

  @Test
  public void isMatureisTrueWhenOver20Height() {
    Tree tree = new Tree("Pine", 12, 15);
    for(int i = 0; i < (11 * 21); i++) {
      tree.photosynthesise();
      tree.grow();
    }
    assertTrue(tree.isMature());
  }
  
}
