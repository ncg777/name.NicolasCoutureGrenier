package name.ncg.Music.RhythmPredicates;

import name.ncg.CS.Functional.StandardAndGuavaPredicate;
import name.ncg.Maths.FuzzyLogic.Valuators.CombinationDispersion;
import name.ncg.Music.Rhythm;

public class EntropicDispersion implements StandardAndGuavaPredicate<Rhythm> {
  private CombinationDispersion cd = new CombinationDispersion();
  
  @Override
  public boolean apply(Rhythm arg0) {
    return cd.apply(arg0).isEntropic(0.025);
  }

}
