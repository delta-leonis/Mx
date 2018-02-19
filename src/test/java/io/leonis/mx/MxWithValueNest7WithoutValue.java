package io.leonis.mx;

import org.junit.*;

public class MxWithValueNest7WithoutValue {
  @Test
  public void nest7WithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .join(Mx.<String>mux()
                .add(marker -> marker + "1")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6")
                .add(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }
}
