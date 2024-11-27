package name.ncg777.musical.sequencePredicates;

import java.util.Collection;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import name.ncg777.computerScience.Functional.StandardAndGuavaPredicate;
import name.ncg777.mathematics.objects.Sequence;
import name.ncg777.musical.Rhythm;


public class PredicatedSeqRhythms implements StandardAndGuavaPredicate<Sequence> {
  final private Predicate<Rhythm> pred;

  public PredicatedSeqRhythms(Predicate<Rhythm> pred) {this.pred = pred;}
  @Override
  public boolean apply(@Nonnull Sequence input) {
    Collection<Rhythm> t = input.getRhythms().values();
    
    for(Rhythm r : t) {
      if(!pred.test(r)) return false;
    }
    return true;
  }

}