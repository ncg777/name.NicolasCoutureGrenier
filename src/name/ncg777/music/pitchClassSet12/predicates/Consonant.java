package name.ncg777.music.pitchClassSet12.predicates;

import javax.annotation.Nonnull;

import name.ncg777.computing.Functional.StandardAndGuavaPredicate;
import name.ncg777.maths.sequences.Sequence;
import name.ncg777.music.pitchClassSet12.PitchClassSet12;

public class Consonant implements StandardAndGuavaPredicate<PitchClassSet12> {
  public boolean apply(@Nonnull PitchClassSet12 input) {
    Sequence IV = input.getIntervalVector();
    return IV.get(0) == 0 && IV.get(5)==0;
  }
}
