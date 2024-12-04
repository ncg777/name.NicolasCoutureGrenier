package name.ncg777.maths.words.printers;


import com.google.common.base.Function;

import name.ncg777.maths.objects.WordHexa;

import java.io.PrintWriter;
import java.util.List;

public class WordHexadecimalCSVPrinter implements Function<List<WordHexa>, Void> {
  PrintWriter o;

  public WordHexadecimalCSVPrinter(PrintWriter o) {
    this.o = o;
  }

  public void close() {
    o.close();
  }

  public void flush() {
    o.flush();
  }

  @Override
  public Void apply(List<WordHexa> input) {
    int x = 0;

    for (int i = input.size() - 1; i >= 0; i--) {
      o.printf(input.get(i).toString());
      x += input.get(i).getN();
      if (i != 0) {
        o.printf(" ");
      }
    }
    o.printf(",%d,%d%n", input.size(), x);

    o.flush();

    return null;
  }
}