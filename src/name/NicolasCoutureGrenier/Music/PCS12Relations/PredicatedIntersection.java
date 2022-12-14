package name.NicolasCoutureGrenier.Music.PCS12Relations;

import com.google.common.base.Predicate;

import name.NicolasCoutureGrenier.Maths.Relations.Relation;
import name.NicolasCoutureGrenier.Music.PCS12;

public class PredicatedIntersection implements Relation<PCS12, PCS12> {
  Predicate<PCS12> f;

  public PredicatedIntersection(Predicate<PCS12> p) {
    f = p;
  }
  @Override
  public boolean apply(PCS12 a, PCS12 b) {

    return f.apply(a.intersect(b));
  }

}
