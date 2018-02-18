package io.leonis.mx;

import org.junit.*;

public class MxNest4WithoutValueTest {
  @Test
  public void nest4mux3WithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "1")
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4"))
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }

  @Test
  public void mux1nest4mux2WithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }

  @Test
  public void mux2nest4mux1WithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }

  @Test
  public void mux3nest4WithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6")
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }
}
