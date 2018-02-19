package io.leonis.mx;

import org.junit.*;

public class MxNest4WithValueTest {

  @Test
  public void nest4mux3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.mux("@")
                .add(marker -> marker + "1")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4"))
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "@1@2@3@4#5#6#7");
  }

  @Test
  public void mux1nest4mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .expand(Mx.mux("@")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5"))
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1@2@3@4@5#6#7");
  }

  @Test
  public void mux2nest4mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .expand(Mx.mux("@")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6"))
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2@3@4@5@6#7");
  }

  @Test
  public void mux3nest4WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .expand(Mx.mux("@")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6")
                .add(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3@4@5@6@7");
  }
}
