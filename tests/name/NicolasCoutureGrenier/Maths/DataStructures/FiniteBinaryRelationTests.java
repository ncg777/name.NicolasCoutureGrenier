package name.NicolasCoutureGrenier.Maths.DataStructures;

import java.util.SortedSet;
import java.util.function.Predicate;

import junit.framework.TestCase;

public class FiniteBinaryRelationTests extends TestCase {
  FiniteBinaryRelation<String,String> r;
  FiniteBinaryRelation<String,String> s;
  FiniteBinaryRelation<String,String> rr_R;
  FiniteBinaryRelation<String,String> rr_S;
  FiniteBinaryRelation<String,String> lr_R;
  FiniteBinaryRelation<String,String> lr_S;
  
  public FiniteBinaryRelationTests(String name) {
    super(name);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    r = new FiniteBinaryRelation<>();
    r.add(null,"b");
    r.add("a",null);
    r.add("a","b");
    r.add("a","c");
    r.add("b","c");
    r.add("d","e");
    r.add("d","f");
    
    s = new FiniteBinaryRelation<>();
    s.add(null,"c");
    s.add("b",null);
    s.add("b","c");
    s.add("b","d");
    s.add("c","d");
    s.add("e","g");
    s.add("f","g");
    
    rr_R = new FiniteBinaryRelation<>();
    rr_R.add("p1","p3");
    rr_R.add("p2","p3");
    rr_S = new FiniteBinaryRelation<>();
    rr_S.add("p1","o");
    rr_S.add("p2","o");
    lr_S = new FiniteBinaryRelation<>();
    lr_S.add("o","p1");
    lr_S.add("o","p2");
    lr_R = new FiniteBinaryRelation<>();
    lr_R.add("p3","p1");
    lr_R.add("p3","p2");

  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public final void testCompose() {
    FiniteBinaryRelation<String,String> o = r.compose(s);
    assertTrue(o.apply(null, null));
    assertTrue(o.apply(null, "c"));
    assertTrue(o.apply(null, "c"));
    assertTrue(o.apply("a", null));
    assertTrue(o.apply("a", "c"));
    assertTrue(o.apply("a", "d"));
    assertTrue(o.apply("b", "d"));
    assertTrue(o.apply("d", "g"));
    assertTrue(o.size()==8);
  }

  public final void testRight_residual() {
    FiniteBinaryRelation<String,String> e = rr_R.rightResidual(rr_S);
    assertTrue(e.apply("p3", "o"));
    assertTrue(e.size()==1);
    
  }

  public final void testLeft_residual() {
    FiniteBinaryRelation<String,String> e = lr_S.leftResidual(lr_R);
    
    assertTrue(e.apply("o", "p3"));
    assertTrue(e.size()==1);
  }

  public final void testDomain() {
    SortedSet<String> d = r.domain();
    assertTrue(d.size()==4);
    d.contains(null);
    d.contains("a");
    d.contains("b");
    d.contains("d");
  }

  public final void testCodomain() {
    SortedSet<String> c = r.codomain();
    assertTrue(c.size()==5);
    c.contains(null);
    c.contains("b");
    c.contains("c");
    c.contains("e");
    c.contains("f");
  }

  public final void testConverse() {
      FiniteBinaryRelation<String, String> o = r.converse();
      assertTrue(o.apply("b", null));
      assertTrue(o.apply("c", "a"));
      assertTrue(o.apply("c", "b"));
      assertTrue(o.apply("e", "d"));
      assertTrue(o.apply("e", "d"));
      assertTrue(o.apply("f", "d"));
      assertEquals(r.size(), o.size());
  }

  public final void testRightRelata() {
      SortedSet<String> o = r.rightRelata(null);
      assertTrue(o.size() == 1);
      assertTrue(o.contains("b"));
  }

  public final void testLeftRelata() {
      SortedSet<String> o = r.leftRelata(null);
      assertTrue(o.size() == 1);
      assertTrue(o.contains("a"));
  }

  public final void testLeftRelated() {
      Predicate<String> o = r.leftRelated(null);
      assertTrue(o.test("a"));
      assertFalse(o.test("b"));
  }

  public final void testRightUnique() {
      assertTrue(!r.isRightUnique());
  }

  public final void testIsLeftUnique() {
      assertTrue(!r.isLeftUnique());
  }

  public final void testIsLeftTotal() {
      assertTrue(r.isLeftTotal(r.domain()));
  }

  public final void testIsSurjective() {
      assertTrue(r.isSurjective(r.codomain()));
  }

  public final void testIsManyToMany() {
      assertTrue(r.isManyToMany());
  }

  public final void testIsManyToOne() {
      FiniteBinaryRelation<String, String> z = new FiniteBinaryRelation<>();
      z.add("a", "b");
      z.add("c", "b");
      z.add("d", "e");
      assertTrue(z.isManyToOne());
  }

  public final void testIsOneToMany() {
      FiniteBinaryRelation<String, String> z = new FiniteBinaryRelation<>();
      z.add("a", "b");
      z.add("a", "c");
      z.add("d", "e");
      assertTrue(z.isOneToMany());
  }

  public final void testIsOneToOne() {
      FiniteBinaryRelation<String, String> z = new FiniteBinaryRelation<>();
      z.add("a", "b");
      z.add("c", "d");
      assertTrue(z.isOneToOne());
  }
}
