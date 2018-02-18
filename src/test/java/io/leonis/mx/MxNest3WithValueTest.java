package io.leonis.mx;

import org.junit.*;

public class MxNest3WithValueTest {

  @Test
  public void nest3mux4WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "1")
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3"))
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "@1@2@3#4#5#6#7");
  }

  @Test
  public void mux1nest3mux3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4"))
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1@2@3@4#5#6#7");
  }

  @Test
  public void mux2nest3mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2@3@4@5#6#7");
  }

  @Test
  public void mux3nest3mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3@4@5@6#7");
  }

  @Test
  public void mux4nest3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6")
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4@5@6@7");
  }
}
