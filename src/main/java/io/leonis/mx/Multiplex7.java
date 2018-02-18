package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.Value;

public interface Multiplex7<I0, I1, M1, M2, M3, M4, M5, M6, M7> {
  Function<I0, I1> getPreComp();

  Function<I1, M1> getFirstMux();

  Function<I1, M2> getSecondMux();

  Function<I1, M3> getThirdMux();

  Function<I1, M4> getFourthMux();

  Function<I1, M5> getFifthMux();

  Function<I1, M6> getSixthMux();

  Function<I1, M7> getSeventhMux();

  @Value
  class WithoutValue<J0, J1, N0, N1, N2, N3, N4, N5, N6>
      implements Multiplex7<J0, J1, N0, N1, N2, N3, N4, N5, N6> {
    private final Function<J0, J1> preComp;
    private final Function<J1, N0> firstMux;
    private final Function<J1, N1> secondMux;
    private final Function<J1, N2> thirdMux;
    private final Function<J1, N3> fourthMux;
    private final Function<J1, N4> fifthMux;
    private final Function<J1, N5> sixthMux;
    private final Function<J1, N6> seventhMux;

    public <O> O demux(final J0 value,
        final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) throws Exception {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)),
          this.sixthMux.apply(this.preComp.apply(value)),
          this.seventhMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<J0, O> demux(final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)),
          this.sixthMux.apply(this.preComp.apply(value)),
          this.seventhMux.apply(this.preComp.apply(value)));
    }
  }

  @Value
  class WithValue<J0, J1, N0, N1, N2, N3, N4, N5, N6>
      implements Multiplex7<J0, J1, N0, N1, N2, N3, N4, N5, N6> {
    private final J0 value;
    private final Function<J0, J1> preComp;
    private final Function<J1, N0> firstMux;
    private final Function<J1, N1> secondMux;
    private final Function<J1, N2> thirdMux;
    private final Function<J1, N3> fourthMux;
    private final Function<J1, N4> fifthMux;
    private final Function<J1, N5> sixthMux;
    private final Function<J1, N6> seventhMux;

    public <O> O demux(final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux)
        throws Exception {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(this.value)),
          this.secondMux.apply(this.preComp.apply(this.value)),
          this.thirdMux.apply(this.preComp.apply(this.value)),
          this.fourthMux.apply(this.preComp.apply(this.value)),
          this.fifthMux.apply(this.preComp.apply(this.value)),
          this.sixthMux.apply(this.preComp.apply(this.value)),
          this.seventhMux.apply(this.preComp.apply(this.value)));
    }
  }
}
