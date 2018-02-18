package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.Value;

@Value
public class Multiplex1WithValue<J0, J1, N0> {
  private final J0 value;
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> mux;

  public N0 demux() throws Exception {
    return this.mux.apply(this.preComp.apply(this.value));
  }

  public <M1> Multiplex2WithValue<J0, J1, N0, M1> expand(final Function<J1, M1> mux) {
    return new Multiplex2WithValue<>(this.value, this.preComp, this.mux, mux);
  }

  public <K0, M0> Multiplex2WithValue<J1, J1, N0, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex3WithValue<J1, J1, N0, M0, M1> expand(
      final Multiplex2WithoutValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2> Multiplex4WithValue<J1, J1, N0, M0, M1, M2> expand(
      final Multiplex3WithoutValue<J1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3> Multiplex5WithValue<J1, J1, N0, M0, M1, M2, M3> expand(
      final Multiplex4WithoutValue<J1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3, M4> Multiplex6WithValue<J1, J1, N0, M0, M1, M2, M3, M4> expand(
      final Multiplex5WithoutValue<J1, K0, M0, M1, M2, M3, M4> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithValue<J1, J1, N0, M0, M1, M2, M3, M4, M5> expand(
      final Multiplex6WithoutValue<J1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex2WithValue<J1, J1, N0, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1> Multiplex3WithValue<J1, J1, N0, M0, M1> expand(
      final Multiplex2WithValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2> Multiplex4WithValue<J1, J1, N0, M0, M1, M2> expand(
      final Multiplex3WithValue<J1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3> Multiplex5WithValue<J1, J1, N0, M0, M1, M2, M3> expand(
      final Multiplex4WithValue<J1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3, M4> Multiplex6WithValue<J1, J1, N0, M0, M1, M2, M3, M4> expand(
      final Multiplex5WithValue<J1, K0, M0, M1, M2, M3, M4> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithValue<J1, J1, N0, M0, M1, M2, M3, M4, M5> expand(
      final Multiplex6WithValue<J1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
