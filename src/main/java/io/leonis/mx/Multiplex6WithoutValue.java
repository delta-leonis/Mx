package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex6WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5> {
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;
  private final Function<J1, N3> fourthMux;
  private final Function<J1, N4> fifthMux;
  private final Function<J1, N5> sixthMux;

  public <O> O demux(final J0 value, final Function6<N0, N1, N2, N3, N4, N5, O> demux)
      throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)),
        this.sixthMux.apply(this.preComp.apply(value)));
  }

  public <O> Function<J0, O> demux(final Function6<N0, N1, N2, N3, N4, N5, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)),
        this.sixthMux.apply(this.preComp.apply(value)));
  }

  public <M0> Multiplex7WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Function<J1, M0> mux) {
    return new Multiplex7WithoutValue<>(this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        this.sixthMux,
        mux);
  }

  public <K0, M0> Multiplex7WithoutValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex7WithoutValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
