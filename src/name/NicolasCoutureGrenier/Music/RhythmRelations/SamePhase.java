package name.NicolasCoutureGrenier.Music.RhythmRelations;


import name.NicolasCoutureGrenier.Maths.Relations.Relation;
import name.NicolasCoutureGrenier.Music.Rhythm;


public class SamePhase implements 
Relation<Rhythm, Rhythm>   {
 
  @Override
  public boolean apply(Rhythm a, Rhythm b) {
    int na = a.nextSetBit(0);
    int nb = b.nextSetBit(0);
    
    if(na == -1 || nb == -1) return false;
    
    return na == nb;
  }
}