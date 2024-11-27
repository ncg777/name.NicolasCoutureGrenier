package name.ncg777.musical.pitchClassSet12Predicates;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Nonnull;

import name.ncg777.computerScience.Functional.StandardAndGuavaPredicate;
import name.ncg777.musical.pitchClassSet12;

public class OrderNotIn implements StandardAndGuavaPredicate<pitchClassSet12> {
  Set<Integer> s;

  public OrderNotIn(Set<Integer> p_s) {
    s = p_s;
  }

  public OrderNotIn(Integer p_s) {

    s = new TreeSet<Integer>();
    s.add(p_s);
  }

  public boolean apply(@Nonnull pitchClassSet12 o) {
    return !s.contains(o.getOrder());
  }
}