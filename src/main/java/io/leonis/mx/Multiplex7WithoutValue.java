package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

/**
 * This class represents a(n unprimed) multiplexer with seven lanes.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of the first object produced by the first lane of this multiplexer.
 * @param <N1> The type of the second object produced by the first lane of this multiplexer.
 * @param <N2> The type of the third object produced by the first lane of this multiplexer.
 * @param <N3> The type of the fourth object produced by the first lane of this multiplexer.
 * @param <N4> The type of the fifth object produced by the first lane of this multiplexer.
 * @param <N5> The type of the sixth object produced by the first lane of this multiplexer.
 * @param <N6> The type of the seventh object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex7WithoutValue<I0, I1, N0, N1, N2, N3, N4, N5, N6> {
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> firstMux;
  private final Function<I1, N1> secondMux;
  private final Function<I1, N2> thirdMux;
  private final Function<I1, N3> fourthMux;
  private final Function<I1, N4> fifthMux;
  private final Function<I1, N5> sixthMux;
  private final Function<I1, N6> seventhMux;

  /**
   * @param value The value to operate on.
   * @param demux The combinator function.
   * @return The result of passing the supplied value to the {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <O> O demux(final I0 value,
      final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)),
        this.sixthMux.apply(this.preComp.apply(value)),
        this.seventhMux.apply(this.preComp.apply(value)));
  }

  /**
   * @param demux The combinator function.
   * @return A {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <O> Function<I0, O> demux(final Function7<N0, N1, N2, N3, N4, N5, N6, O> demux) {
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
