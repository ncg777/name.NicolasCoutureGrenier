package name.NicolasCoutureGrenier.Maths.Enumerations;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

import name.NicolasCoutureGrenier.Maths.DataStructures.HeterogeneousPair;

public class  HeterogeneousPairEnumeration<
  T extends Comparable<? super T>, 
  U extends Comparable<? super U>> implements Enumeration<HeterogeneousPair<T,U>> {
  
  private Iterator<T> TIterator;
  private T TCurrent;
  private Iterator<U> UIterator;
  private U UCurrent;
  private Iterable<U> UIterable;
  public HeterogeneousPairEnumeration(Iterable<T> IT, Iterable<U> IU) {
    TIterator = IT.iterator();
    TCurrent = TIterator.next();
    UIterator = IU.iterator();
    UIterable = IU;
  }
  
  @Override
  public boolean hasMoreElements() {
    if(TIterator.hasNext()) { return true;}
    if(UIterator.hasNext()) { return true;}
    return false;
  }

  @Override
  public HeterogeneousPair<T,U> nextElement() {
    if(UIterator.hasNext()) {
      UCurrent = UIterator.next();
      return HeterogeneousPair.makeHeterogeneousPair(TCurrent, UCurrent); 
    } else if(TIterator.hasNext()) {
      TCurrent = TIterator.next();
      UIterator = UIterable.iterator();
      UCurrent = UIterator.next();
      return HeterogeneousPair.makeHeterogeneousPair(TCurrent, UCurrent);
    }
    throw new NoSuchElementException("No more elements.");
  }
}