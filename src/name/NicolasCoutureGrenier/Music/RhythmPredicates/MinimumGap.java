package name.NicolasCoutureGrenier.Music.RhythmPredicates;

import javax.annotation.Nonnull;

import name.NicolasCoutureGrenier.CS.Functional.StandardAndGuavaPredicate;
import name.NicolasCoutureGrenier.Music.Rhythm;

public class MinimumGap implements StandardAndGuavaPredicate<Rhythm> {
  
  private int n = -1;
  public MinimumGap(int n) {
    this.n = n;
  }
  @Override
  public boolean apply(@Nonnull Rhythm input) {
    return input.getComposition().asSequence().getMin() >= this.n;
  }

}
