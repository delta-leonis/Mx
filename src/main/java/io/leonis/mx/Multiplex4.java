package io.leonis.mx;

import io.leonis.Function4;
import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex4<Y, I, M0, M1, M2, M3> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> firstMux;
  protected final Function<I, M1> secondMux;
  protected final Function<I, M2> thirdMux;
  protected final Function<I, M3> fourthMux;

  public static class WithoutValue<WY, WI, WM0, WM1, WM2, WM3>
      extends Multiplex4<WY, WI, WM0, WM1, WM2, WM3> {

    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux);
    }

    public <O> O demux(final WI value, final Function4<WM0, WM1, WM2, WM3, O> demux) {
      return demux.apply(
          this.firstMux.apply(value),
          this.secondMux.apply(value),
          this.thirdMux.apply(value),
          this.fourthMux.apply(value));
    }

    public <O> Function<WI, O> demux(final Function4<WM0, WM1, WM2, WM3, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(value),
          this.secondMux.apply(value),
          this.thirdMux.apply(value),
          this.fourthMux.apply(value));
    }

    public <M4> Multiplex5.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, M4> expand(
        final Function<WI, M4> mux) {
      return new Multiplex5.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
          mux);
    }

    public <M5, M6> Multiplex6.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex7.WithoutValue<WY, WI, WM0, WM1, WM2, WM3, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }
  }

  public static class WithValue<WY, WI, WM0, WM1, WM2, WM3>
      extends Multiplex4<WY, WI, WM0, WM1, WM2, WM3> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux, final Function<WI, WM3> fourthMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux);
      this.value = value;
    }

    public <O> O demux(final Function4<WM0, WM1, WM2, WM3, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(this.value)),
          this.secondMux.apply(this.preComp.apply(this.value)),
          this.thirdMux.apply(this.preComp.apply(this.value)),
          this.fourthMux.apply(this.preComp.apply(this.value)));
    }

    public <M4> Multiplex5.WithValue<WY, WI, WM0, WM1, WM2, WM3, M4> expand(
        final Function<WI, M4> mux) {
      return new Multiplex5.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, mux);
    }

    public <M5, M6> Multiplex6.WithValue<WY, WI, WM0, WM1, WM2, WM3, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex7.WithValue<WY, WI, WM0, WM1, WM2, WM3, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }
  }
}

