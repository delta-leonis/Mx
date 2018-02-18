package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

public interface Multiplex3<I0, I1, M0, M1, M2> {
  Function<I0, I1> getPreComp();

  Function<I1, M0> getFirstMux();

  Function<I1, M1> getSecondMux();

  Function<I1, M2> getThirdMux();

  @Value
  class WithoutValue<J0, J1, N0, N1, N2>
      implements Multiplex3<J0, J1, N0, N1, N2> {
    private final Function<J0, J1> preComp;
    private final Function<J1, N0> firstMux;
    private final Function<J1, N1> secondMux;
    private final Function<J1, N2> thirdMux;

    public <O> O demux(final J0 value, final Function3<N0, N1, N2, O> demux) throws Exception {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<J0, O> demux(final Function3<N0, N1, N2, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)));
    }

    public <M0> Multiplex4.WithoutValue<J0, J1, N0, N1, N2, M0> expand(
        final Function<J1, M0> mux) {
      return new Multiplex4.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          mux);
    }

    public <K0, M0> Multiplex4.WithoutValue<J1, J1, N0, N1, N2, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex5.WithoutValue<J1, J1, N0, N1, N2, M0, M1> expand(
        final Multiplex2<J1, K0, M0, M1> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex6.WithoutValue<J1, J1, N0, N1, N2, M0, M1, M2> expand(
        final Multiplex3<J1, K0, M0, M1, M2> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex7.WithoutValue<J1, J1, N0, N1, N2, M0, M1, M2, M3> expand(
        final Multiplex4<J1, K0, M0, M1, M2, M3> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }
  }

  @Value
  class WithValue<J0, J1, N0, N1, N2> implements Multiplex3<J0, J1, N0, N1, N2> {
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

    public <M3> Multiplex4.WithValue<J0, J1, N0, N1, N2, M3> expand(final Function<J1, M3> mux) {
      return new Multiplex4.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          mux);
    }

    public <K0, M0> Multiplex4.WithValue<J1, J1, N0, N1, N2, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) throws Exception {
      return new Multiplex4.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex5.WithValue<J1, J1, N0, N1, N2, M0, M1> expand(
        final Multiplex2<J1, K0, M0, M1> multiplex
    ) throws Exception {
      return new Multiplex5.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex6.WithValue<J1, J1, N0, N1, N2, M0, M1, M2> expand(
        final Multiplex3<J1, K0, M0, M1, M2> multiplex
    ) throws Exception {
      return new Multiplex6.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex7.WithValue<J1, J1, N0, N1, N2, M0, M1, M2, M3> expand(
        final Multiplex4<J1, K0, M0, M1, M2, M3> multiplex
    ) throws Exception {
      return new Multiplex7.WithValue<>(this.preComp.apply(this.value), value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }
  }
}
