package name.NicolasCoutureGrenier.Maths.FuzzyLogic.Valuators;

import java.util.TreeMap;

import com.google.common.base.Function;

import name.NicolasCoutureGrenier.Maths.DataStructures.Interval;
import name.NicolasCoutureGrenier.Maths.DataStructures.Composition;
import name.NicolasCoutureGrenier.Maths.DataStructures.HeterogeneousPair;
import name.NicolasCoutureGrenier.Maths.DataStructures.Sequence;
import name.NicolasCoutureGrenier.Maths.FuzzyLogic.FuzzyVariable;

public class CompositionDispersion implements Function<Composition, FuzzyVariable> {

  TreeMap<HeterogeneousPair<Integer, Integer>, Interval<Integer>> minmax;

  public CompositionDispersion() {
    minmax = new TreeMap<HeterogeneousPair<Integer, Integer>, Interval<Integer>>();
  }

  /**
   * 
   * @param input
   * @return The sum of pairwise distances normalized with regard to the set of compositions with
   *         the same total and number of elements.
   */
  @Override
  public FuzzyVariable apply(Composition input) {
    Sequence t = input.asSequence();
    if (input.getK() <= 1 || input.getK() == input.getN()) {
      return FuzzyVariable.from(0.5);
    }

    int n = input.getTotal();
    int s = t.size();
    HeterogeneousPair<Integer, Integer> ns = HeterogeneousPair.makeHeterogeneousPair(n, s);

    int min = 0;
    int max = 0;

    if (!minmax.containsKey(ns)) {
      Integer[] min_arr = new Integer[s];
      Integer[] max_arr = new Integer[s];
      int r = n % s;
      int d = (n - r) / s;

      for (int i = 0; i < s; i++) {
        min_arr[i] = d;
      }
      for (int i = 0; i < r; i++) {
        min_arr[i] = min_arr[i] + 1;
      }
      for (int i = 0; i < (s - 1); i++) {
        max_arr[i] = 1;
      }
      max_arr[s - 1] = n - (s - 1);

      min = calc(min_arr);
      max = calc(max_arr);
      minmax.put(ns, Interval.makeClosedInterval(min, max));
    } else {
      min = minmax.get(ns).getMinimum();
      max = minmax.get(ns).getMaximum();
    }
    Integer[] arr = new Integer[s];
    int i = 0;
    for (Integer j : t) {
      arr[i++] = j;
    }
    if (min == max) {
      return FuzzyVariable.from(0.5);
    } else {
      return FuzzyVariable.from(1.0 - (double) ((calc(arr) - min) / (double) (max - min)));
    }
  }

  /**
   * 
   * @param arr
   * @return The sum of pairwise distances
   */
  private int calc(Integer[] arr) {
    int t = 0;

    for (int i = 0; i < (arr.length - 1); i++) {
      for (int j = i + 1; j < arr.length; j++) {
        t += Math.abs(arr[j] - arr[i]);
      }
    }
    return t;
  }

}
