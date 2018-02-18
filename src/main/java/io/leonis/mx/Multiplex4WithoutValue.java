package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex4WithoutValue<J0, J1, N0, N1, N2, N3> {
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;

  public <O> O demux(final J1 value, final Function4<N0, N1, N2, N3, O> demux)
      throws Exception {
    return demux.apply(
        this.firstMux.apply(value),
        this.secondMux.apply(value),
        this.thirdMux.apply(value),
        this.fourthMux.apply(value));
  }

  public <O> Function<J1, O> demux(final Function4<N0, N1, N2, N3, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(value),
        this.secondMux.apply(value),
        this.thirdMux.apply(value),
        this.fourthMux.apply(value));
  }

  public <M0> Multiplex5WithoutValue<J0, J1, N0, N1, N2, N3, M0> expand(
      final Function<J1, M0> mux) {
    return new Multiplex5WithoutValue<>(this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
        mux);
  }

  public <K0, M0> Multiplex5WithoutValue<J1, J1, N0, N1, N2, N3, M0> expand(
      final Multiplex1<J1, K0, M0> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex6WithoutValue<J1, J1, N0, N1, N2, N3, M0, M1> expand(
      final Multiplex2<J1, K0, M0, M1> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2> Multiplex7WithoutValue<J1, J1, N0, N1, N2, N3, M0, M1, M2> expand(
      final Multiplex3<J1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }
}
