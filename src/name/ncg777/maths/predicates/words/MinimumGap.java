package name.ncg777.maths.predicates.words;

import javax.annotation.Nonnull;

import name.ncg777.computerScience.Functional.StandardAndGuavaPredicate;
import name.ncg777.maths.objects.words.BinaryWord;

public class MinimumGap implements StandardAndGuavaPredicate<BinaryWord> {
  
  private int n = -1;
  public MinimumGap(int n) {
    this.n = n;
  }
  @Override
  public boolean apply(@Nonnull BinaryWord input) {
    return input.getComposition().asSequence().getMin() >= this.n;
  }

}