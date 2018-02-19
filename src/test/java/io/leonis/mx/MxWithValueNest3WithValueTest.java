package io.leonis.mx;

import org.junit.*;

public class MxWithValueNest3WithValueTest {

  @Test
  public void nest3mux4WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .join(Mx.mux("@")
                .add(marker -> marker + "1")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3"))
            .add(marker -> marker + "4")
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "@1@2@3#4#5#6#7");
  }

  @Test
  public void mux1nest3mux3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .join(Mx.mux("@")
                .add(marker -> marker + "2")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4"))
            .add(marker -> marker + "5")
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1@2@3@4#5#6#7");
  }

  @Test
  public void mux2nest3mux2WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .join(Mx.mux("@")
                .add(marker -> marker + "3")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5"))
            .add(marker -> marker + "6")
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2@3@4@5#6#7");
  }

  @Test
  public void mux3nest3mux1WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .join(Mx.mux("@")
                .add(marker -> marker + "4")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6"))
            .add(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3@4@5@6#7");
  }

  @Test
  public void mux4nest3WithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .add(marker -> marker + "1")
            .add(marker -> marker + "2")
            .add(marker -> marker + "3")
            .add(marker -> marker + "4")
            .join(Mx.mux("@")
                .add(marker -> marker + "5")
                .add(marker -> marker + "6")
                .add(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4@5@6@7");
  }
}
