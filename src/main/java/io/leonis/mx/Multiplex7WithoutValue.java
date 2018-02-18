package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex7WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5, N6> {
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;
  private final Function<J1, N4> fifthMux;
  private final Function<J1, N5> sixthMux;
  private final Function<J1, N6> seventhMux;

  public <O> O demux(final J0 value,
      final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)),
        this.sixthMux.apply(this.preComp.apply(value)),
        this.seventhMux.apply(this.preComp.apply(value)));
  }

  public <O> Function<J0, O> demux(final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)),
        this.sixthMux.apply(this.preComp.apply(value)),
        this.seventhMux.apply(this.preComp.apply(value)));
  }
}
