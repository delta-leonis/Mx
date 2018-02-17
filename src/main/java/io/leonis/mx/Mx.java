package io.leonis.mx;

import java.util.function.Function;
import lombok.Value;

public class Mx {
  public static <I0, I1> MultiplexWithValue<I0, I1> mux(
      final I0 value,
      final Function<I0, I1> mux
  ) {
    return new MultiplexWithValue<>(value, mux);
  }

  public static <I0, I1> MultiplexWithoutValue<I0, I1> mux(final Function<I0, I1> mux) {
    return new MultiplexWithoutValue<>(mux);
  }

  public static <I> MultiplexWithValue<I, I> mux(final I value) {
    return new MultiplexWithValue<>(value, Function.identity());
  }

  public static <I> MultiplexWithoutValue<I, I> mux() {
    return new MultiplexWithoutValue<>(Function.identity());
  }

  @Value
  public static final class MultiplexWithValue<I1, I0> {
    private final I1 value;
    private final Function<I1, I0> preComp;

    public <M1> Multiplex1.WithValue<I0, I0, M1> expand(final Function<I0, M1> mux) {
      return new Multiplex1.WithValue<>(this.preComp.apply(this.value), Function.identity(), mux);
    }

    public <I2, M1> Multiplex1.WithValue<I0, I0, M1> expand(final Multiplex1<I0, I2, M1> mux) {
      return new Multiplex1.WithValue<>(
          this.preComp.apply(this.value),
          Function.identity(),
          mux.getPreComp().andThen(mux.getMux()));
    }

    public <I2, M5, M6> Multiplex2.WithValue<I0, I0, M5, M6> expand(
        final Multiplex2<I0, I2, M5, M6> multiplex
    ) {
      return new Multiplex2.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()));
    }

    public <I2, M5, M6, M7> Multiplex3.WithValue<I0, I0, M5, M6, M7> expand(
        final Multiplex3<I0, I2, M5, M6, M7> multiplex
    ) {
      return new Multiplex3.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()),
          multiplex.getPreComp().andThen(multiplex.getThirdMux()));
    }

    public <I2, M5, M6, M7, M8> Multiplex4.WithValue<I0, I0, M5, M6, M7, M8> expand(
        final Multiplex4<I0, I2, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex4.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()),
          multiplex.getPreComp().andThen(multiplex.getThirdMux()),
          multiplex.getPreComp().andThen(multiplex.getFourthMux()));
    }

    public <I2, M5, M6, M7, M8, M9> Multiplex5.WithValue<I0, I0, M5, M6, M7, M8, M9> expand(
        final Multiplex5<I0, I2, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex5.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()),
          multiplex.getPreComp().andThen(multiplex.getThirdMux()),
          multiplex.getPreComp().andThen(multiplex.getFourthMux()),
          multiplex.getPreComp().andThen(multiplex.getFifthMux()));
    }

    public <I2, M5, M6, M7, M8, M9, M10> Multiplex6.WithValue<I0, I0, M5, M6, M7, M8, M9, M10> expand(
        final Multiplex6<I0, I2, M5, M6, M7, M8, M9, M10> multiplex
    ) {
      return new Multiplex6.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()),
          multiplex.getPreComp().andThen(multiplex.getThirdMux()),
          multiplex.getPreComp().andThen(multiplex.getFourthMux()),
          multiplex.getPreComp().andThen(multiplex.getFifthMux()),
          multiplex.getPreComp().andThen(multiplex.getSixthMux()));
    }

    public <I2, M5, M6, M7, M8, M9, M10, M11> Multiplex7.WithValue<I0, I0, M5, M6, M7, M8, M9, M10, M11> expand(
        final Multiplex7<I0, I2, M5, M6, M7, M8, M9, M10, M11> multiplex
    ) {
      return new Multiplex7.WithValue<>(this.preComp.apply(this.value), Function.identity(),
          multiplex.getPreComp().andThen(multiplex.getFirstMux()),
          multiplex.getPreComp().andThen(multiplex.getSecondMux()),
          multiplex.getPreComp().andThen(multiplex.getThirdMux()),
          multiplex.getPreComp().andThen(multiplex.getFourthMux()),
          multiplex.getPreComp().andThen(multiplex.getFifthMux()),
          multiplex.getPreComp().andThen(multiplex.getSixthMux()),
          multiplex.getPreComp().andThen(multiplex.getSeventhMux()));
    }
  }

  @Value
  public static final class MultiplexWithoutValue<I1, I0> {
    private final Function<I1, I0> preComp;

    public <M1> Multiplex1.WithoutValue<I1, I0, M1> expand(final Function<I0, M1> mux) {
      return new Multiplex1.WithoutValue<>(this.preComp, mux);
    }

    public <M1> Multiplex1.WithoutValue<I1, I0, M1> expand(final Multiplex1<I1, I0, M1> mux) {
      return new Multiplex1.WithoutValue<>(this.preComp, mux.getMux());
    }

    public <M5, M6> Multiplex2.WithoutValue<I1, I0, M5, M6> expand(
        final Multiplex2<I1, I0, M5, M6> multiplex
    ) {
      return new Multiplex2.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux());
    }

    public <M5, M6, M7> Multiplex3.WithoutValue<I1, I0, M5, M6, M7> expand(
        final Multiplex3<I1, I0, M5, M6, M7> multiplex
    ) {
      return new Multiplex3.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux());
    }

    public <M5, M6, M7, M8> Multiplex4.WithoutValue<I1, I0, M5, M6, M7, M8> expand(
        final Multiplex4<I1, I0, M5, M6, M7, M8> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux());
    }

    public <M5, M6, M7, M8, M9> Multiplex5.WithoutValue<I1, I0, M5, M6, M7, M8, M9> expand(
        final Multiplex5<I1, I0, M5, M6, M7, M8, M9> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux());
    }

    public <M5, M6, M7, M8, M9, M10> Multiplex6.WithoutValue<I1, I0, M5, M6, M7, M8, M9, M10> expand(
        final Multiplex6<I1, I0, M5, M6, M7, M8, M9, M10> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux(), multiplex.getSixthMux());
    }

    public <M5, M6, M7, M8, M9, M10, M11> Multiplex7.WithoutValue<I1, I0, M5, M6, M7, M8, M9, M10, M11> expand(
        final Multiplex7<I1, I0, M5, M6, M7, M8, M9, M10, M11> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(this.preComp,
          multiplex.getFirstMux(), multiplex.getSecondMux(), multiplex.getThirdMux(),
          multiplex.getFourthMux(), multiplex.getFifthMux(), multiplex.getSixthMux(),
          multiplex.getSeventhMux());
    }
  }
}
