package io.leonis.mx;

import io.leonis.Function7;
import java.util.function.Function;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Multiplex7<Y, I, M1, M2, M3, M4, M5, M6, M7> {
  protected final Function<Y, I> preComp;
  protected final Function<I, M1> firstMux;
  protected final Function<I, M2> secondMux;
  protected final Function<I, M3> thirdMux;
  protected final Function<I, M4> fourthMux;
  protected final Function<I, M5> fifthMux;
  protected final Function<I, M6> sixthMux;
  protected final Function<I, M7> seventhMux;

  public static class WithoutValue<WY, WI, WM1, WM2, WM3, WM4, WM5, WM6, WM7>
      extends Multiplex7<WY, WI, WM1, WM2, WM3, WM4, WM5, WM6, WM7> {

    public WithoutValue(final Function<WY, WI> preComp, final Function<WI, WM1> firstMux,
        final Function<WI, WM2> secondMux,
        final Function<WI, WM3> thirdMux, final Function<WI, WM4> fourthMux,
        final Function<WI, WM5> fifthMux, final Function<WI, WM6> sixthMux,
        final Function<WI, WM7> seventhMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux, sixthMux, seventhMux);
    }

    public <O> O demux(final WY value,
        final Function7<WM1, WM2, WM3, WM4, WM5, WM6, WM7, O> demux) {
      return demux.apply(
          this.firstMux.apply(this.preComp.apply(value)),
          this.secondMux.apply(this.preComp.apply(value)),
          this.thirdMux.apply(this.preComp.apply(value)),
          this.fourthMux.apply(this.preComp.apply(value)),
          this.fifthMux.apply(this.preComp.apply(value)),
          this.sixthMux.apply(this.preComp.apply(value)),
          this.seventhMux.apply(this.preComp.apply(value)));
    }

    public <O> Function<WY, O> demux(final Function7<WM1, WM2, WM3, WM4, WM5, WM6, WM7, O> demux) {
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

  public static class WithValue<WY, WI, WM1, WM2, WM3, WM4, WM5, WM6, WM7>
      extends Multiplex7<WY, WI, WM1, WM2, WM3, WM4, WM5, WM6, WM7> {
    private final WY value;

    public WithValue(final WY value, final Function<WY, WI> preComp,
        final Function<WI, WM1> firstMux,
        final Function<WI, WM2> secondMux,
        final Function<WI, WM3> thirdMux, final Function<WI, WM4> fourthMux,
        final Function<WI, WM5> fifthMux, final Function<WI, WM6> sixthMux,
        final Function<WI, WM7> seventhMux) {
      super(preComp, firstMux, secondMux, thirdMux, fourthMux, fifthMux, sixthMux, seventhMux);
      this.value = value;
    }

    public <O> O demux(final Function7<WM1, WM2, WM3, WM4, WM5, WM6, WM7, O> demux) {
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