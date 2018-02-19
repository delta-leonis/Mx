package io.leonis.mx;

import org.junit.*;

public class MxWithoutValueNest5WithValueTest {

  @Test
  public void nest5mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(Mx.mux("@")
                .expand(marker -> marker + "1")
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "@1@2@3@4@5#6#7");
  }

  @Test
  public void mux1nest5mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "2")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1@2@3@4@5@6#7");
  }

  @Test
  public void mux2nest5WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "3")
                .expand(marker -> marker + "4")
                .expand(marker -> marker + "5")
                .expand(marker -> marker + "6")
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2@3@4@5@6@7");
  }
}
