package io.leonis.mx;

import io.leonis.Function5;
import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex5<Y, I, M0, M1, M2, M3, M4> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> firstMux;
  protected final Function<I, M1> secondMux;
  protected final Function<I, M2> thirdMux;
  protected final Function<I, M3> fourthMux;
  protected final Function<I, M4> fifthMux;

  public static class WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4>
      extends Multiplex5<WY, WI, WM0, WM1, WM2, WM3, WM4> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux,
        final Function<WI, WM4> fifthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux);
      this.value = value;
    }

    public <O> Function<WI, O> demux(final Function5<WM0, WM1, WM2, WM3, WM4, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(value),
          this.secondMux.apply(value),
          this.thirdMux.apply(value),
          this.fourthMux.apply(value),
          this.fifthMux.apply(value));
    }

    public <M5> Multiplex6.WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5> expand(
        final Function<WI, M5> mux) {
      return new Multiplex6.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          mux);
    }

    public <M5> Multiplex6.WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5> expand(
        final Multiplex1<WY, WI, M5> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          multiplex.getMux());
    }

    public <M5, M6> Multiplex7.WithValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }
  }

  public static class WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4>
      extends Multiplex5<WY, WI, WM0, WM1, WM2, WM3, WM4> {
    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux,
        final Function<WI, WM4> fifthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux);
    }

    public <O> O demux(final WY value, final Function5<WM0, WM1, WM2, WM3, WM4, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<WY, O> demux(final Function5<WM0, WM1, WM2, WM3, WM4, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)));
    }

    public <M5> Multiplex6.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5> expand(
        final Function<WI, M5> mux) {
      return new Multiplex6.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          mux);
    }

    public <M5> Multiplex6.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5> expand(
        final Multiplex1<WY, WI, M5> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          multiplex.getMux());
    }

    public <M5, M6> Multiplex7.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, WM4, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }
  }
}