package name.ncg777.musical.rhythmPredicates;

import javax.annotation.Nonnull;

import name.ncg777.computerScience.Functional.StandardAndGuavaPredicate;
import name.ncg777.mathematics.fuzzy.valuationFunctions.CombinationDispersion;
import name.ncg777.musical.Rhythm;

public class LowDispersion implements StandardAndGuavaPredicate<Rhythm> {
  private CombinationDispersion cd = new CombinationDispersion();
  
  @Override
  public boolean apply(@Nonnull Rhythm arg0) {
    return cd.apply(arg0).not().quantize(0.8);
  }

}