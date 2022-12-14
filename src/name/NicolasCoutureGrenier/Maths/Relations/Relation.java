package name.NicolasCoutureGrenier.Maths.Relations;

import java.util.function.BiPredicate;

import com.google.common.base.Predicate;

import name.NicolasCoutureGrenier.Maths.DataStructures.HeterogeneousPair;
import name.NicolasCoutureGrenier.Maths.Predicates.BoundRelationFirst;
import name.NicolasCoutureGrenier.Maths.Predicates.BoundRelationSecond;

public interface Relation<T extends Comparable<? super T>, U extends Comparable<? super U>> extends BiPredicate<T,U>{
  public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Relation<T,U> fromBiPredicate(BiPredicate<T,U> p) {
    return new Relation<T,U>() {
      public boolean apply(T a, U b) {
        return p.test(a, b);
      }
    };
  }
  public default boolean apply(HeterogeneousPair<T,U> p) { return apply(p.getFirst(), p.getSecond()); }
  boolean apply(T a, U b);

  public default boolean test(T t, U u) {return apply(t,u); }
  
  public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Predicate<T> bindSecond(
       Relation<T, U> r1, U u) {
     return new BoundRelationSecond<T, U>(r1, u);
   }
  
   public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Predicate<U> bindFirst(
       T t, Relation<T, U> r1) {
     return new BoundRelationFirst<T, U>(t, r1);
  
   }
   
   @SafeVarargs
   public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Relation<T, U> and(
       Relation<T, U>... rels) {
     return new Relation<T,U>() {
       public boolean apply(T a, U b) {
         for(var rel : rels) {
           if(!rel.apply(a, b)) {return false;}
         }
         return true;
       }
     };
   }
   @SafeVarargs
   public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Relation<T, U> or(Relation<T, U>... rels) {
     return new Relation<T,U>() {
       public boolean apply(T a, U b) {
         for(var rel : rels) {
           if(rel.apply(a, b)) {return true;}
         }
         return false;
       }
     };
   }
  
   public static <T extends Comparable<? super T>, U extends Comparable<? super U>> Relation<T, U> not(
       Relation<T, U> r) {
     return new Relation<T,U>() {
       public boolean apply(T a, U b) {
         return !r.apply(a, b);
       }
     };
   }
}
