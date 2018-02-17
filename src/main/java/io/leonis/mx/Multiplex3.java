package io.leonis.mx;

import io.leonis.Function3;
import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex3<Y, I, M0, M1, M2> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> firstMux;
  protected final Function<I, M1> secondMux;
  protected final Function<I, M2> thirdMux;

  public static class WithoutValue<WY, WI, WM0, WM1, WM2>
      extends Multiplex3<WY, WI, WM0, WM1, WM2> {
    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux) {
      super(preComp, firstMux, secondMux, thirdMux);
    }

    public <O> O demux(final WY value, final Function3<WM0, WM1, WM2, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<WY, O> demux(final Function3<WM0, WM1, WM2, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)));
    }

    public <M3> Multiplex4.WithoutValue<WY, WI, WM0, WM1, WM2, M3> expand(
        final Function<WI, M3> mux) {
      return new Multiplex4.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          mux);
    }

    public <M5, M6> Multiplex5.WithoutValue<WY, WI, WM0, WM1, WM2, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex6.WithoutValue<WY, WI, WM0, WM1, WM2, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex7.WithoutValue<WY, WI, WM0, WM1, WM2, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }
  }

  public static class WithValue<WY, WI, WM0, WM1, WM2> extends Multiplex3<WY, WI, WM0, WM1, WM2> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux,
        final Function<WI, WM2> thirdMux) {
      super(preComp, firstMux, secondMux, thirdMux);
      this.value = value;
    }

    public <O> O demux(final Function3<WM0, WM1, WM2, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(this.value)),
          this.secondMux.apply(this.preComp.apply(this.value)),
          this.thirdMux.apply(this.preComp.apply(this.value)));
    }

    public <M3> Multiplex4.WithValue<WY, WI, WM0, WM1, WM2, M3> expand(final Function<WI, M3> mux) {
      return new Multiplex4.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          mux);
    }

    public <M5, M6> Multiplex5.WithValue<WY, WI, WM0, WM1, WM2, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex5.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex6.WithValue<WY, WI, WM0, WM1, WM2, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex7.WithValue<WY, WI, WM0, WM1, WM2, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp,
          this.firstMux, this.secondMux, this.thirdMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }
  }
}
