package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex6WithValue<J0, J1, N0, N1, N2, N3, N4, N5> {
  private final J0 value;
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;
  private final Function<J1, N4> fifthMux;
  private final Function<J1, N5> sixthMux;

  public <O> O demux(final Function6<N0, N1, N2, N3, N4, N5, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(this.value)),
        this.secondMux.apply(this.preComp.apply(this.value)),
        this.thirdMux.apply(this.preComp.apply(this.value)),
        this.fourthMux.apply(this.preComp.apply(this.value)),
        this.fifthMux.apply(this.preComp.apply(this.value)),
        this.sixthMux.apply(this.preComp.apply(this.value)));
  }

  public <M0> Multiplex7WithValue<J0, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Function<J1, M0> mux
  ) {
    return new Multiplex7WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        this.sixthMux,
        mux);
  }

  public <K0, M0> Multiplex7WithValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex7WithValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
