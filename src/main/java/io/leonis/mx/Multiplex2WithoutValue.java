package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex2WithoutValue<J0, J1, N0, N1> {
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;

  public <O> Function<J0, O> demux(final BiFunction<N0, N1, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)));
  }

  public <O> O demux(final J0 value, final BiFunction<N0, N1, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)));
  }

  public <M0> Multiplex3WithoutValue<J0, J1, N0, N1, M0> expand(
      final Function<J1, M0> mux) {
    return new Multiplex3WithoutValue<>(this.preComp, this.firstMux, this.secondMux, mux);
  }

  public <K0, M0> Multiplex3WithoutValue<J1, J1, N0, N1, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex4WithoutValue<J1, J1, N0, N1, M0, M1> expand(
      final Multiplex2WithoutValue<J1, K0, M0, M1> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2> Multiplex5WithoutValue<J1, J1, N0, N1, M0, M1, M2> expand(
      final Multiplex3WithoutValue<J1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3> Multiplex6WithoutValue<J1, J1, N0, N1, M0, M1, M2, M3> expand(
      final Multiplex4WithoutValue<J1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3, M4> Multiplex7WithoutValue<J1, J1, N0, N1, M0, M1, M2, M3, M4> expand(
      final Multiplex5WithoutValue<J1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex3WithoutValue<J1, J1, N0, N1, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1> Multiplex4WithoutValue<J1, J1, N0, N1, M0, M1> expand(
      final Multiplex2WithValue<J1, K0, M0, M1> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2> Multiplex5WithoutValue<J1, J1, N0, N1, M0, M1, M2> expand(
      final Multiplex3WithValue<J1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3> Multiplex6WithoutValue<J1, J1, N0, N1, M0, M1, M2, M3> expand(
      final Multiplex4WithValue<J1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3, M4> Multiplex7WithoutValue<J1, J1, N0, N1, M0, M1, M2, M3, M4> expand(
      final Multiplex5WithValue<J1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
