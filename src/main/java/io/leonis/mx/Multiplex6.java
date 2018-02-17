package io.leonis.mx;

import io.leonis.Function6;
import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex6<Y, I, M0, M1, M2, M3, M4, M5> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> firstMux;
  protected final Function<I, M1> secondMux;
  protected final Function<I, M2> thirdMux;
  protected final Function<I, M3> fourthMux;
  protected final Function<I, M4> fifthMux;
  protected final Function<I, M5> sixthMux;

  public static class WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5>
      extends Multiplex6<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5> {

    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux,
        final Function<WI, WM4> fifthMux, final Function<WI, WM5> sixthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux, sixthMux);
    }

    public <O> O demux(final WY value, final Function6<WM0, WM1, WM2, WM3, WM4, WM5, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)),
          this.sixthMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<WY, O> demux(final Function6<WM0, WM1, WM2, WM3, WM4, WM5, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)),
          this.sixthMux.apply(this.preComp.apply(value)));
    }

    public <M6> Multiplex7.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5, M6> expand(
        final Function<WI, M6> mux) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          mux);
    }

    public <M6> Multiplex7.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5, M6> expand(
        final Multiplex1<WY, WI, M6> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          multiplex.getMux());
    }
  }

  public static class WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5>
      extends Multiplex6<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux,
        final Function<WI, WM4> fifthMux, final Function<WI, WM5> sixthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux, sixthMux);
      this.value = value;
    }

    public <O> O demux(final Function6<WM0, WM1, WM2, WM3, WM4, WM5, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(this.value)),
          this.secondMux.apply(this.preComp.apply(this.value)),
          this.thirdMux.apply(this.preComp.apply(this.value)),
          this.fourthMux.apply(this.preComp.apply(this.value)),
          this.fifthMux.apply(this.preComp.apply(this.value)),
          this.sixthMux.apply(this.preComp.apply(this.value)));
    }

    public <M6> Multiplex7.WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5, M6> expand(
        final Function<WI, M6> mux
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          mux);
    }

    public <M6> Multiplex7.WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, WM5, M6> expand(
        final Multiplex1<WY, WI, M6> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          this.sixthMux,
          multiplex.getMux());
    }
  }

}