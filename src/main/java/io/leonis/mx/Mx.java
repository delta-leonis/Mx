package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.Value;

public class Mx {
  public static  <I0, I1> MultiplexWithValue<I0, I1> muxFirst(
      final I0 value,
      final Function<I0, I1> mux
  ) {
    return new MultiplexWithValue<>(value, mux);
  }

  public static  <I0, I1> MultiplexWithoutValue<I0, I1> first(final Function<I0, I1> mux) {
    return new MultiplexWithoutValue<>(mux);
  }

  public static <I> MultiplexWithValue<I, I> mux(final I value) {
    return new MultiplexWithValue<>(value, identity -> identity);
  }

  public static <I> MultiplexWithoutValue<I, I> mux() {
    return new MultiplexWithoutValue<>(value -> value);
  }

  @Value
  static final class MultiplexWithValue<I0, I1> {
    private final I0 value;
    private final Function<I0, I1> preComp;

    public <M0> Multiplex1.WithValue<I1, I1, M0> expand(final Function<I1, M0> mux)
        throws Exception {
      return new Multiplex1.WithValue<>(this.preComp.apply(this.value), value -> value, mux);
    }

    public <K0, M0> Multiplex1.WithValue<I1, I1, M0> expand(final Multiplex1<I1, K0, M0> mux)
        throws Exception {
      return new Multiplex1.WithValue<>(
          this.preComp.apply(this.value),
          value -> value,
          value -> mux.getMux().apply(mux.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex2.WithValue<I1, I1, M0, M1> expand(
        final Multiplex2<I1, K0, M0, M1> multiplex
    ) throws Exception {
      return new Multiplex2.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex3.WithValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3<I1, K0, M0, M1, M2> multiplex
    ) throws Exception {
      return new Multiplex3.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex4.WithValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4<I1, K0, M0, M1, M2, M3> multiplex
    ) throws Exception {
      return new Multiplex4.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5.WithValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) throws Exception {
      return new Multiplex5.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6.WithValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) throws Exception {
      return new Multiplex6.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7.WithValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) throws Exception {
      return new Multiplex7.WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSeventhMux().apply(multiplex.getPreComp().apply(value)));
    }
  }

  @Value
  static final class MultiplexWithoutValue<I0, I1> {
    private final Function<I0, I1> preComp;

    public <M0> Multiplex1.WithoutValue<I0, I1, M0> expand(final Function<I1, M0> mux) {
      return new Multiplex1.WithoutValue<>(this.preComp, mux);
    }

    public <K0, M0> Multiplex1.WithoutValue<I1, I1, M0> expand(final Multiplex1<I1, K0, M0> mux) {
      return new Multiplex1.WithoutValue<>(
          value -> value,
          value -> mux.getMux().apply(mux.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex2.WithoutValue<I1, I1, M0, M1> expand(
        final Multiplex2<I1, K0, M0, M1> multiplex
    ) {
      return new Multiplex2.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex3.WithoutValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3<I1, K0, M0, M1, M2> multiplex
    ) {
      return new Multiplex3.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex4.WithoutValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4<I1, K0, M0, M1, M2, M3> multiplex
    ) {
      return new Multiplex4.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5.WithoutValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) {
      return new Multiplex5.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6.WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) {
      return new Multiplex6.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7.WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) {
      return new Multiplex7.WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSeventhMux().apply(multiplex.getPreComp().apply(value)));
    }
  }
}
