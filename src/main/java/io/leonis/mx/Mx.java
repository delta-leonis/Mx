package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.Value;

public class Mx {
  public static <I0, I1> MultiplexWithValue<I0, I1> muxFirst(
      final I0 value,
      final Function<I0, I1> mux
  ) {
    return new MultiplexWithValue<>(value, mux);
  }

  public static <I0, I1> MultiplexWithoutValue<I0, I1> first(final Function<I0, I1> mux) {
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

    public <M0> Multiplex1WithValue<I1, I1, M0> expand(final Function<I1, M0> mux)
        throws Exception {
      return new Multiplex1WithValue<>(this.preComp.apply(this.value), value -> value, mux);
    }

    public <K0, M0> Multiplex1WithValue<I1, I1, M0> expand(
        final Multiplex1WithoutValue<I1, K0, M0> mux)
        throws Exception {
      return new Multiplex1WithValue<>(
          this.preComp.apply(this.value),
          value -> value,
          value -> mux.getMux().apply(mux.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex2WithValue<I1, I1, M0, M1> expand(
        final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
    ) throws Exception {
      return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex3WithValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
    ) throws Exception {
      return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex4WithValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4WithoutValue<I1, K0, M0, M1, M2, M3> multiplex
    ) throws Exception {
      return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5WithValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5WithoutValue<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) throws Exception {
      return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) throws Exception {
      return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) throws Exception {
      return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSeventhMux().apply(multiplex.getPreComp().apply(value)));
    }


    public <K0, M0> Multiplex1WithValue<I1, I1, M0> expand(
        final Multiplex1WithValue<I1, K0, M0> multiplex)
        throws Exception {
      return new Multiplex1WithValue<>(
          this.preComp.apply(this.value),
          value -> value,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1> Multiplex2WithValue<I1, I1, M0, M1> expand(
        final Multiplex2WithValue<I1, K0, M0, M1> multiplex
    ) throws Exception {
      return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2> Multiplex3WithValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
    ) throws Exception {
      return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3> Multiplex4WithValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4WithValue<I1, K0, M0, M1, M2, M3> multiplex
    ) throws Exception {
      return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5WithValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5WithValue<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) throws Exception {
      return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6WithValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) throws Exception {
      return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSixthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7WithValue<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) throws Exception {
      return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSixthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSeventhMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }
  }

  @Value
  static final class MultiplexWithoutValue<I0, I1> {
    private final Function<I0, I1> preComp;

    public <M0> Multiplex1WithoutValue<I0, I1, M0> expand(final Function<I1, M0> multiplex) {
      return new Multiplex1WithoutValue<>(this.preComp, multiplex);
    }

    public <K0, M0> Multiplex1WithoutValue<I1, I1, M0> expand(
        final Multiplex1WithValue<I1, K0, M0> multiplex) {
      return new Multiplex1WithoutValue<>(
          value -> value,
          value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1> Multiplex2WithoutValue<I1, I1, M0, M1> expand(
        final Multiplex2WithValue<I1, K0, M0, M1> multiplex
    ) {
      return new Multiplex2WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2> Multiplex3WithoutValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
    ) {
      return new Multiplex3WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3> Multiplex4WithoutValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4WithValue<I1, K0, M0, M1, M2, M3> multiplex
    ) {
      return new Multiplex4WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5WithoutValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5WithValue<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) {
      return new Multiplex5WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6WithValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) {
      return new Multiplex6WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSixthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7WithValue<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) {
      return new Multiplex7WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSecondMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getThirdMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFourthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getFifthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSixthMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())),
          value -> multiplex.getSeventhMux()
              .apply(multiplex.getPreComp().apply(multiplex.getValue())));
    }


    public <K0, M0> Multiplex1WithoutValue<I1, I1, M0> expand(
        final Multiplex1WithoutValue<I1, K0, M0> mux) {
      return new Multiplex1WithoutValue<>(
          value -> value,
          value -> mux.getMux().apply(mux.getPreComp().apply(value)));
    }

    public <K0, M0, M1> Multiplex2WithoutValue<I1, I1, M0, M1> expand(
        final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
    ) {
      return new Multiplex2WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2> Multiplex3WithoutValue<I1, I1, M0, M1, M2> expand(
        final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
    ) {
      return new Multiplex3WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3> Multiplex4WithoutValue<I1, I1, M0, M1, M2, M3> expand(
        final Multiplex4WithoutValue<I1, K0, M0, M1, M2, M3> multiplex
    ) {
      return new Multiplex4WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4> Multiplex5WithoutValue<I1, I1, M0, M1, M2, M3, M4> expand(
        final Multiplex5WithoutValue<I1, K0, M0, M1, M2, M3, M4> multiplex
    ) {
      return new Multiplex5WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5> expand(
        final Multiplex6WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
    ) {
      return new Multiplex6WithoutValue<>(value -> value,
          value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
          value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
    }

    public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> expand(
        final Multiplex7WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
    ) {
      return new Multiplex7WithoutValue<>(value -> value,
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
