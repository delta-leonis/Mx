package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex5WithoutValue<J0, J1, N0, N1, N2, N3, N4> {
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;
  private final Function<J1, N4> fifthMux;

  public <O> O demux(final J0 value, final Function5<N0, N1, N2, N3, N4, O> demux)
      throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)));
  }

  public <O> Function<J0, O> demux(final Function5<N0, N1, N2, N3, N4, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)));
  }

  public <M0> Multiplex6WithoutValue<J0, J1, N0, N1, N2, N3, N4, M0> expand(
      final Function<J1, M0> mux) {
    return new Multiplex6WithoutValue<>(this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        mux);
  }

  public <K0, M0> Multiplex6WithoutValue<J1, J1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex7WithoutValue<J1, J1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithoutValue<J1, K0, M0, M1> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex6WithoutValue<J1, J1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1> Multiplex7WithoutValue<J1, J1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithValue<J1, K0, M0, M1> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
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
