package io.leonis.mx;

import java.util.function.*;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex2<Y, I, M0, M1> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> firstMux;
  protected final Function<I, M1> secondMux;

  public <O> O demux(final Y value, final BiFunction<M0, M1, O> demux) {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)));
  }

  public static class WithoutValue<WY, WI, WM0, WM1> extends Multiplex2<WY, WI, WM0, WM1> {
    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux) {
      super(preComp, firstMux, secondMux);
    }

    public <O> Function<WY, O> demux(final BiFunction<WM0, WM1, O> demux) {
      return value -> demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)));
    }

    public <WM2> Multiplex3.WithoutValue<WY, WI, WM0, WM1, WM2> expand(
        final Function<WI, WM2> mux) {
      return new Multiplex3.WithoutValue<>(this.preComp, this.firstMux, this.secondMux, mux);
    }

    public <M5, M6> Multiplex4.WithoutValue<WY, WI, WM0, WM1, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex5.WithoutValue<WY, WI, WM0, WM1, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex6.WithoutValue<WY, WI, WM0, WM1, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }

    public <M5, M6, M7, M8, M9> Multiplex7.WithoutValue<WY, WI, WM0, WM1, M5, M6, M7, M8, M9> expand(
        final Multiplex5<WY, WI, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux());
    }
  }

  public static class WithValue<WY, WI, WM0, WM1> extends Multiplex2<WY, WI, WM0, WM1> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM0> firstMux,
        final Function<WI, WM1> secondMux) {
      super(preComp, firstMux, secondMux);
      this.value = value;
    }

    public <O> O demux(final BiFunction<WM0, WM1, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(this.value)),
          this.secondMux.apply(this.preComp.apply(this.value)));
    }

    public <WM2> Multiplex3.WithValue<WY, WI, WM0, WM1, WM2> expand(final Function<WI, WM2> mux) {
      return new Multiplex3.WithValue<>(this.value, this.preComp, this.firstMux, this.secondMux,
          mux);
    }

    public <M5, M6> Multiplex4.WithValue<WY, WI, WM0, WM1, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex4.WithValue<>(this.value, this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex5.WithValue<WY, WI, WM0, WM1, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex5.WithValue<>(this.value, this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex6.WithValue<WY, WI, WM0, WM1, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.value, this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }

    public <M5, M6, M7, M8, M9> Multiplex7.WithValue<WY, WI, WM0, WM1, M5, M6, M7, M8, M9> expand(
        final Multiplex5<WY, WI, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp, this.firstMux, this.secondMux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux());
    }
  }

}
