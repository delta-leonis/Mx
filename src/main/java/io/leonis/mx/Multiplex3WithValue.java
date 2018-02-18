package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

@Value
public class Multiplex3WithValue<J0, J1, N0, N1, N2> {
  private final J0 value;
  private final Function<J0, J1> preComp;
  private final Function<J1, N0> firstMux;
  private final Function<J1, N1> secondMux;
  private final Function<J1, N2> thirdMux;

  public <O> O demux(final Function3<N0, N1, N2, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(this.value)),
        this.secondMux.apply(this.preComp.apply(this.value)),
        this.thirdMux.apply(this.preComp.apply(this.value)));
  }

  public <M3> Multiplex4WithValue<J0, J1, N0, N1, N2, M3> expand(final Function<J1, M3> mux) {
    return new Multiplex4WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux,
        mux);
  }

  public <K0, M0> Multiplex4WithValue<J1, J1, N0, N1, N2, M0> expand(
      final Multiplex1WithoutValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1> Multiplex5WithValue<J1, J1, N0, N1, N2, M0, M1> expand(
      final Multiplex2WithoutValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2> Multiplex6WithValue<J1, J1, N0, N1, N2, M0, M1, M2> expand(
      final Multiplex3WithoutValue<J1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0, M1, M2, M3> Multiplex7WithValue<J1, J1, N0, N1, N2, M0, M1, M2, M3> expand(
      final Multiplex4WithoutValue<J1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
  }

  public <K0, M0> Multiplex4WithValue<J1, J1, N0, N1, N2, M0> expand(
      final Multiplex1WithValue<J1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1> Multiplex5WithValue<J1, J1, N0, N1, N2, M0, M1> expand(
      final Multiplex2WithValue<J1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2> Multiplex6WithValue<J1, J1, N0, N1, N2, M0, M1, M2> expand(
      final Multiplex3WithValue<J1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  public <K0, M0, M1, M2, M3> Multiplex7WithValue<J1, J1, N0, N1, N2, M0, M1, M2, M3> expand(
      final Multiplex4WithValue<J1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
