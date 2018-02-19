package io.leonis.mx;

import org.junit.*;

public class MxWithoutValueNest7WithValue {
  @Test
  public void nest7WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .join(Mx.mux("@")
                .add(marker -> marker + "1")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6")
                .add(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "@1@2@3@4@5@6@7");
  }
}
