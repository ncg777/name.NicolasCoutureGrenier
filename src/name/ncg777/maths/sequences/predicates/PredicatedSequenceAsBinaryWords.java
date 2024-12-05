package name.ncg777.maths.sequences.predicates;

import java.util.Collection;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import name.ncg777.computing.Functional.StandardAndGuavaPredicate;
import name.ncg777.maths.sequences.Sequence;
import name.ncg777.maths.words.Word;

public class PredicatedSequenceAsBinaryWords implements StandardAndGuavaPredicate<Sequence> {
  final private Predicate<Word> pred;

  public PredicatedSequenceAsBinaryWords(Predicate<Word> pred) {this.pred = pred;}
  @Override
  public boolean apply(@Nonnull Sequence input) {
    Collection<Word> t = input.getBinaryWords().values();
    
    for(Word r : t) {
      if(!pred.test(r)) return false;
    }
    return true;
  }
}