package io.leonis.mx;

import org.junit.*;

public class MxTest {

  @Test
  public void simpleMux() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .demux((a, b, c, d, e, f) -> a + b + c + d + e + f),
        "#1#2#3#4#5#6");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .demux((a, b, c, d, e) -> a + b + c + d + e),
        "#1#2#3#4#5");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .demux((a, b, c, d) -> a + b + c + d),
        "#1#2#3#4");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .demux((a, b, c) -> a + b + c),
        "#1#2#3");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .demux((a, b) -> a + b),
        "#1#2");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .demux(),
        "#1");
  }

  @Test
  public void nestedSingleMuxWithoutValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "1"))
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "2"))
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "3"))
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "4"))
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(Mx.<String>mux()
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6#7");

  }

  @Test
  public void nestedSingleMuxWithValue() throws Exception {
    Assert.assertEquals(
        Mx.mux("#")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "1"))
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "@1#2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "2"))
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1@2#3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "3"))
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2@3#4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "4"))
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3@4#5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "5"))
            .expand(marker -> marker + "6")
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4@5#6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "6"))
            .expand(marker -> marker + "7")
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5@6#7");

    Assert.assertEquals(
        Mx.mux("#")
            .expand(marker -> marker + "1")
            .expand(marker -> marker + "2")
            .expand(marker -> marker + "3")
            .expand(marker -> marker + "4")
            .expand(marker -> marker + "5")
            .expand(marker -> marker + "6")
            .expand(Mx.mux("@")
                .expand(marker -> marker + "7"))
            .demux((a, b, c, d, e, f, g) -> a + b + c + d + e + f + g),
        "#1#2#3#4#5#6@7");
  }
}
