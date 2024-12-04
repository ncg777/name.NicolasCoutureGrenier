package name.ncg777.maths.words.relations;

import name.ncg777.maths.objects.words.BinaryWord;
import name.ncg777.maths.relations.Relation;


public class Different implements Relation<BinaryWord, BinaryWord>  {

  @Override
  public boolean apply(BinaryWord a, BinaryWord b) {
    return !a.equals(b);
  }

}
