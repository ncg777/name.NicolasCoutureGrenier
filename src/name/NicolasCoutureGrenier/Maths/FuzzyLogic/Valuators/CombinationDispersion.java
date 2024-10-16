package name.NicolasCoutureGrenier.Maths.FuzzyLogic.Valuators;

import com.google.common.base.Function;

import name.NicolasCoutureGrenier.Maths.FuzzyLogic.FuzzyVariable;
import name.NicolasCoutureGrenier.Maths.Objects.Combination;

public class CombinationDispersion implements Function<Combination, FuzzyVariable> {
  CompositionDispersion v;

  public CombinationDispersion() {
    v = new CompositionDispersion();
  }

  @Override
  public FuzzyVariable apply(Combination input) {
    return v.apply(input.getComposition());
  }
}
