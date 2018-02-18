package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.Value;

public interface Multiplex1<I0, I1, M0> {
  Function<I0, I1> getPreComp();

  Function<I1, M0> getMux();

  @Value
  class WithoutValue<J0, J1, N0> implements Multiplex1<J0, J1, N0> {
    private final Function<J0, J1> preComp;
    private final Function<J1, N0> mux;

    public N0 demux(final J0 value) throws Exception {
      return this.mux.apply(this.preComp.apply(value));
    }

    public Function<J0, N0> demux() {
      return value -> this.mux.apply(this.preComp.apply(value));
    }

    public <M0> Multiplex2.WithoutValue<J0, J1, N0, M0> expand(final Function<J1, M0> mux) {
      return new Multiplex2.WithoutValue<>(this.preComp, this.mux, mux);
    }

    public <K0, M0> Multiplex2.WithoutValue<J1, J1, N0, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) {
      return new Multiplex2.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex3.WithoutValue<J1, J1, N0, M0, M1> expand(
        final Multiplex2<J1, K0, M0, M1> multiplex
    ) {
      return new Multiplex3.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex4.WithoutValue<J1, J1, N0, M0, M1, M2> expand(
        final Multiplex3<J1, K0, M0, M1, M2> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex5.WithoutValue<J1, J1, N0, M0, M1, M2, M3> expand(
        final Multiplex4<J1, K0, M0, M1, M2, M3> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex6.WithoutValue<J1, J1, N0, M0, M1, M2, M3, M4> expand(
        final Multiplex5<J1, K0, M0, M1, M2, M3, M4> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex7.WithoutValue<J1, J1, N0, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6<J1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }
  }

  @Value
  class WithValue<J0, J1, N0> implements Multiplex1<J0, J1, N0> {
    private final J0 value;
    private final Function<J0, J1> preComp;
    private final Function<J1, N0> mux;

    public N0 demux() throws Exception {
      return this.mux.apply(this.preComp.apply(this.value));
    }

    public <M1> Multiplex2.WithValue<J0, J1, N0, M1> expand(final Function<J1, M1> mux) {
      return new Multiplex2.WithValue<>(this.value, this.preComp, this.mux, mux);
    }

    public <K0, M0> Multiplex2.WithValue<J1, J1, N0, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) throws Exception {
      return new Multiplex2.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex3.WithValue<J1, J1, N0, M0, M1> expand(
        final Multiplex2<J1, K0, M0, M1> multiplex
    ) throws Exception {
      return new Multiplex3.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex4.WithValue<J1, J1, N0, M0, M1, M2> expand(
        final Multiplex3<J1, K0, M0, M1, M2> multiplex
    ) throws Exception {
      return new Multiplex4.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex5.WithValue<J1, J1, N0, M0, M1, M2, M3> expand(
        final Multiplex4<J1, K0, M0, M1, M2, M3> multiplex
    ) throws Exception {
      return new Multiplex5.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex6.WithValue<J1, J1, N0, M0, M1, M2, M3, M4> expand(
        final Multiplex5<J1, K0, M0, M1, M2, M3, M4> multiplex
    ) throws Exception {
      return new Multiplex6.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex7.WithValue<J1, J1, N0, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6<J1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) throws Exception {
      return new Multiplex7.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.mux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }
  }
}
