package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

public interface Multiplex6<I0, I1, M0, M1, M2, M3, M4, M5> {
  Function<I0, I1> getPreComp();

  Function<I1, M0> getFirstMux();

  Function<I1, M1> getSecondMux();

  Function<I1, M2> getThirdMux();

  Function<I1, M3> getFourthMux();

  Function<I1, M4> getFifthMux();

  Function<I1, M5> getSixthMux();

  @Value
  class WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5>
      implements Multiplex6<J0, J1, N0, N1, N2, N3, N4, N5> {
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

    public <M0> Multiplex7.WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5, M0> expand(
        final Function<J1, M0> mux) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          mux);
    }

    public <K0, M0> Multiplex7.WithoutValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          this.fourthMux,
          this.fifthMux,
          this.sixthMux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }
  }

  @Value
  class WithValue<J0, J1, N0, N1, N2, N3, N4, N5>
      implements Multiplex6<J0, J1, N0, N1, N2, N3, N4, N5> {
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

    public <M0> Multiplex7.WithValue<J0, J1, N0, N1, N2, N3, N4, N5, M0> expand(
        final Function<J1, M0> mux
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          mux);
    }

    public <K0, M0> Multiplex7.WithValue<J1, J1, N0, N1, N2, N3, N4, N5, M0> expand(
        final Multiplex1<J1, K0, M0> multiplex
    ) throws Exception {
      return new Multiplex7.WithValue<>(this.preComp.apply(value), value -> value,
          this.firstMux,
          this.secondMux,
          this.thirdMux,
          this.fourthMux,
          this.fifthMux,
          this.sixthMux,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
    }
  }

}
