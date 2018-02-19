package io.leonis.mx;

import org.junit.*;

public class MxFirst {
  @Test
  public void muxFirst() throws Exception {
    Assert.assertEquals(
        Mx.muxFirst("#", hashbang -> hashbang + "#")
            .add(marker -> marker + "1")
            .demux(),
        "##1");
  }

  @Test
  public void first() throws Exception {
    Assert.assertEquals(
        Mx.first(hashbang -> hashbang + "#")
            .add(marker -> marker + "1")
            .demux()
            .apply("#"),
        "##1");
  }
}
