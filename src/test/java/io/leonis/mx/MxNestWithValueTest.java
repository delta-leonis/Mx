package io.leonis.mx;

import org.junit.*;

public class MxNestWithValueTest {

  @Test
  public void nest1mux6WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.mux("@")
                .add(marker -> marker + "1"))
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "@1#2#3#4#5#6#7");
  }

  @Test
  public void mux1nest1mux5WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .expand(Mx.mux("@")
                .add(marker -> marker + "2"))
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1@2#3#4#5#6#7");
  }

  @Test
  public void mux2nest1mux4WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .expand(Mx.mux("@")
                .add(marker -> marker + "3"))
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2@3#4#5#6#7");
  }

  @Test
  public void mux3nest1mux3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .expand(Mx.mux("@")
                .add(marker -> marker + "4"))
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3@4#5#6#7");
  }

  @Test
  public void mux4nest1mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .expand(Mx.mux("@")
                .add(marker -> marker + "5"))
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4@5#6#7");
  }

  @Test
  public void mux5nest1mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .expand(Mx.mux("@")
                .add(marker -> marker + "6"))
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5@6#7");
  }

  @Test
  public void mux6nest1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .expand(Mx.mux("@")
                .add(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6@7");
  }
}
