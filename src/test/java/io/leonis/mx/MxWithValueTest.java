package io.leonis.mx;

import org.junit.*;

public class MxWithValueTest {

  @Test
  public void mux7demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");
  }

  @Test
  public void mux6demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .demux((a, b, c, d, e, f) -> a + b + c + d + e + f),
        "#1#2#3#4#5#6");
  }

  @Test
  public void mux5demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .demux((a, b, c, d, e) -> a + b + c + d + e),
        "#1#2#3#4#5");
  }

  @Test
  public void mux4demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .demux((a, b, c, d) -> a + b + c + d),
        "#1#2#3#4");
  }

  @Test
  public void mux3demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .demux((a, b, c) -> a + b + c),
        "#1#2#3");
  }

  @Test
  public void mux2demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .demux((a, b) -> a + b),
        "#1#2");
  }

  @Test
  public void mux1demux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .demux(),
        "#1");
  }
}
