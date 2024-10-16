package name.NicolasCoutureGrenier.Music.RhythmPredicates;

import javax.annotation.Nonnull;

import name.NicolasCoutureGrenier.CS.Functional.StandardAndGuavaPredicate;
import name.NicolasCoutureGrenier.Maths.FuzzyLogic.Valuators.CombinationDispersion;
import name.NicolasCoutureGrenier.Music.Rhythm;

public class HighDispersion implements StandardAndGuavaPredicate<Rhythm> {
  private CombinationDispersion cd = new CombinationDispersion();
  
  @Override
  public boolean apply(@Nonnull Rhythm arg0) {
    return cd.apply(arg0).quantize(0.65);
  }

}
