package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex5WithValue<J0, J1, N0, N1, N2, N3, N4> {
  private final J0 value;
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;
  private final Function<J1, N4> fifthMux;

  public <O> Function<J1, O> demux(final Function5<N0, N1, N2, N3, N4, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(value),
        this.secondMux.apply(value),
        this.thirdMux.apply(value),
        this.fourthMux.apply(value),
        this.fifthMux.apply(value));
  }

  public <M0> Multiplex6WithValue<J0, J1, N0, N1, N2, N3, N4, M0> expand(
      final Function<J1, M0> mux) {
    return new Multiplex6WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        mux);
  }

  public <K0, M0> Multiplex6WithValue<J1, J1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex7WithValue<J1, J1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithoutValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex6WithValue<J1, J1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1> Multiplex7WithValue<J1, J1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
