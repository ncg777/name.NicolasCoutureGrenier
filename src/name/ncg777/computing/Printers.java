package name.ncg777.computing;

import java.util.Base64;
import java.util.function.Function;
import java.util.function.IntFunction;

import com.google.common.base.Joiner;

import name.ncg777.computing.structures.HeteroPair;
import name.ncg777.computing.structures.HomoPair;
import name.ncg777.computing.structures.JaggedList;
import name.ncg777.maths.Combination;
import name.ncg777.maths.Composition;
import name.ncg777.maths.music.pcs12.Pcs12;
import name.ncg777.maths.sequences.Sequence;

import java.util.List;

public class Printers {
  public static Function<String, String> stringPrinter = (s) -> s;
  public static Function<Integer, String> integerPrinter = (i) -> Integer.toString(i);
  public static IntFunction<String> intPrinter =new IntFunction<String>() {
    @Override
    public String apply(int value) {
      return Integer.toString(value);
    }
  };
  public static Function<Double, String> doublePrinter = (d) -> Double.toString(d);
  public static Function<Object[],String> doubleArrayPrinter = arrayDecorator(doublePrinter);
  public static Function<Object[],String> integerArrayPrinter = arrayDecorator(integerPrinter);
  public static Function<Sequence, String> sequencePrinter = (s) -> s.toString();
  public static Function<Pcs12, String> PCS12Printer = (pcs) -> pcs.toForteNumberString();
  public static Function<Combination, String> combinationPrinter = (c) -> c.toBinaryString();
  public static Function<Composition, String> compositionPrinter = (c) -> c.toBinaryString();
  
  public static Function<HomoPair<Integer>, String> intPairPrinter = (p) -> {
    Sequence ss = new Sequence();
    ss.add(p.getFirst());
    ss.add(p.getSecond());
    return ss.toString();
  };

  public static<T extends Comparable<? super T>> Function<Object[],String> arrayDecorator(Function<T,String> printer){
    return (arr) -> JaggedList.<T>fromArray(arr).toJSONArrayString(printer);
  }
  public static <T> Function<List<T>,String> listPrinter(Function<T,String> printer) {
    return listPrinter(printer, " ");
  }
  public static <T> Function<List<T>,String> listPrinter(Function<T,String> printer, String separator) {
    return (l) -> Joiner.on(separator).join(l.stream().map(printer).toList());
  }
  public static <T extends Comparable<? super T>> Function<T,String> base64Decorator(Function<T,String> printer) {
    return (var x) -> new String(Base64.getEncoder().encode(printer.apply(x).getBytes()));
  }
  
  public static <T extends Comparable<? super T>> Function<JaggedList<T>,String> jaggedListDecorator(Function<T,String> printer) {
    return (JaggedList<T> x) -> {
      return x.toJSONArrayString(printer);
    };
  }
  public static <T extends Comparable<? super T>, U extends Comparable<? super U>> 
    Function<HeteroPair<T,U>, String>
      heteroPairDecorator(Function<T,String> printer1, Function<U,String> printer2) {
    return (p) -> p.toString(printer1, printer2);
  }
  public static <T extends Comparable<? super T>> 
  Function<HomoPair<T>, String>
    homoPairDecorator(Function<T,String> printer) {
    return (p) -> p.toString(printer, printer);
  }
 }