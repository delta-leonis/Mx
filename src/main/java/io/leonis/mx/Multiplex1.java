package io.leonis.mx;

import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex1<Y, I, M0> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M0> mux;

  public static class WithoutValue<WY, WI, WM0> extends Multiplex1<WY, WI, WM0> {
    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM0> mux) {
      super(preComp, mux);
    }

    public WM0 demux(final WY value) {
      return this.mux.apply(this.preComp.apply(value));
    }

    public Function<WY, WM0> demux() {
      return this.preComp.andThen(this.mux);
    }

    public <M1> Multiplex2.WithoutValue<WY, WI, WM0, M1> expand(final Function<WI, M1> mux) {
      return new Multiplex2.WithoutValue<>(this.preComp, this.mux, mux);
    }

    public <M5, M6> Multiplex3.WithoutValue<WY, WI, WM0, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex3.WithoutValue<>(this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex4.WithoutValue<WY, WI, WM0, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex5.WithoutValue<WY, WI, WM0, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }

    public <M5, M6, M7, M8, M9> Multiplex6.WithoutValue<WY, WI, WM0, M5, M6, M7, M8, M9> expand(
        final Multiplex5<WY, WI, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux());
    }

    public <M5, M6, M7, M8, M9, M10> Multiplex7.WithoutValue<WY, WI, WM0, M5, M6, M7, M8, M9, M10> expand(
        final Multiplex6<WY, WI, M5, M6, M7, M8, M9, M10> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux(), multiplex.getSixthMux());
    }
  }

  public static class WithValue<WY, WI, WM0> extends Multiplex1<WY, WI, WM0> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp, final Function<WI, WM0> mux) {
      super(preComp, mux);
      this.value = value;
    }

    public WM0 demux() {
      return this.mux.apply(this.preComp.apply(this.value));
    }

    public <M1> Multiplex2.WithValue<WY, WI, WM0, M1> expand(final Function<WI, M1> mux) {
      return new Multiplex2.WithValue<>(this.value, this.preComp, this.mux, mux);
    }

    public <M5, M6> Multiplex3.WithValue<WY, WI, WM0, M5, M6> expand(
        final Multiplex2<WY, WI, M5, M6> multiplex
    ) {
      return new Multiplex3.WithValue<>(this.value, this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex4.WithValue<WY, WI, WM0, M5, M6, M7> expand(
        final Multiplex3<WY, WI, M5, M6, M7> multiplex
    ) {
      return new Multiplex4.WithValue<>(this.value, this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex5.WithValue<WY, WI, WM0, M5, M6, M7, M8> expand(
        final Multiplex4<WY, WI, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex5.WithValue<>(this.value, this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }

    public <M5, M6, M7, M8, M9> Multiplex6.WithValue<WY, WI, WM0, M5, M6, M7, M8, M9> expand(
        final Multiplex5<WY, WI, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.value, this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux());
    }

    public <M5, M6, M7, M8, M9, M10> Multiplex7.WithValue<WY, WI, WM0, M5, M6, M7, M8, M9, M10> expand(
        final Multiplex6<WY, WI, M5, M6, M7, M8, M9, M10> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.value, this.preComp, this.mux,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux(), multiplex.getSixthMux());
    }
  }
}
