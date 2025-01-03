package name.ncg777.maths;

import java.util.ArrayList;
import java.util.List;

public class HadamardMatrix extends MatrixOfIntegers {

  private static Integer[][] h1_arr = {{1,1},{1,-1}};
  private static List<HadamardMatrix> mats = new ArrayList<>();
  
  static {
    mats.add(new HadamardMatrix());
  }
  
  public HadamardMatrix expand() {
    return new HadamardMatrix((new HadamardMatrix()).kronecker(this));
  }
  
  public static HadamardMatrix getMatrix(int order) {
   if(order < 1) throw new IllegalArgumentException();
   int currentSize = mats.size(); 
   while(currentSize < order) {
     mats.add(new HadamardMatrix(mats.get(0).kronecker(mats.get(mats.size()-1))));
     currentSize++;
   }
   return mats.get(order-1);
  };
  
  public int getOrder() {
    return (int)Math.round(Math.log(this.n)/Math.log(2.0));
  }
  
  private HadamardMatrix() {
    super(h1_arr);
  }
  
  private HadamardMatrix(Matrix<Integer> mat) {
    super(mat);
  }
}
