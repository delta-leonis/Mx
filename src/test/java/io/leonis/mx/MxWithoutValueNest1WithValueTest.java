package io.leonis.mx;

import org.junit.*;

public class MxWithoutValueNest1WithValueTest {

  @Test
  public void nest1mux6WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(Mx.mux("@")
                .expand(marker -> marker + "1"))
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "@1#2#3#4#5#6#7");
  }

  @Test
  public void mux1nest1mux5WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "2"))
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1@2#3#4#5#6#7");
  }

  @Test
  public void mux2nest1mux4WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "3"))
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2@3#4#5#6#7");
  }

  @Test
  public void mux3nest1mux3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "4"))
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2#3@4#5#6#7");
  }

  @Test
  public void mux4nest1mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2#3#4@5#6#7");
  }

  @Test
  public void mux5nest1mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2#3#4#5@6#7");
  }

  @Test
  public void mux6nest1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.<String>mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2#3#4#5#6@7");
  }
}
