package name.NicolasCoutureGrenier.Music.RhythmPredicates;

import javax.annotation.Nonnull;

import name.NicolasCoutureGrenier.CS.Functional.StandardAndGuavaPredicate;
import name.NicolasCoutureGrenier.Maths.Objects.Sequence;
import name.NicolasCoutureGrenier.Music.Rhythm;

public class Oddity implements StandardAndGuavaPredicate<Rhythm>  {

  @Override
  public boolean apply(@Nonnull Rhythm arg0) {
    int n = arg0.getN();
    if(n%2==1){return true;}
    
    Sequence spectrum = Rhythm.calcSpectrum(arg0);
    return spectrum.get(spectrum.size()-1) == 0;
  }

}
