package io.leonis.mx;

import org.junit.*;

public class MxWithoutValue {

  @Test
  public void mux7demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g)
            .apply("#"),
        "#1#2#3#4#5#6#7");
  }

  @Test
  public void mux6demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .demux((a, b, c, d, e, f) -> a + b + c + d + e + f)
            .apply("#"),
        "#1#2#3#4#5#6");
  }

  @Test
  public void mux5demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .demux((a, b, c, d, e) -> a + b + c + d + e)
            .apply("#"),
        "#1#2#3#4#5");
  }

  @Test
  public void mux4demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .demux((a, b, c, d) -> a + b + c + d)
            .apply("#"),
        "#1#2#3#4");
  }

  @Test
  public void mux3demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .demux((a, b, c) -> a + b + c)
            .apply("#"),
        "#1#2#3");
  }

  @Test
  public void mux2demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .demux((a, b) -> a + b)
            .apply("#"),
        "#1#2");
  }

  @Test
  public void mux1demux() throws Exception {
    Assert.assertEquals(
        Mx.mux()
            .expand(marker -> marker + "1")
            .demux()
            .apply("#"),
        "#1");
  }
}
