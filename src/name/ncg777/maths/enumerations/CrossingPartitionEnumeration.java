package name.ncg777.maths.enumerations;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import name.ncg777.maths.predicates.*;

public class CrossingPartitionEnumeration implements Enumeration<int[]>  {
  private Predicate<int[]> ncp = new NonCrossingPartition();
  private Enumeration<int[]> spe;
  private int[] next;
  
  public CrossingPartitionEnumeration(int n) {
    spe = new SetPartitionEnumeration(n);
    next = spe.nextElement();
    while(ncp.test(next)) {
      if(spe.hasMoreElements()) next = spe.nextElement();
      else {next = null; break;}
    }
  }
  @Override
  public boolean hasMoreElements() {
    return next!=null;
  }

  @Override
  public int[] nextElement() {
    if(next == null) throw new NoSuchElementException();
    int[] o = next.clone();
    next = spe.nextElement();
    while(ncp.test(next)) {
      if(spe.hasMoreElements()) next = spe.nextElement();
      else {next = null; break;}
    }
    return o;
  }

}