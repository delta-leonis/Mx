package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

/**
 * This class represents a (primed) multiplexer with six lanes.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of the first object produced by the first lane of this multiplexer.
 * @param <N1> The type of the second object produced by the first lane of this multiplexer.
 * @param <N2> The type of the third object produced by the first lane of this multiplexer.
 * @param <N3> The type of the fourth object produced by the first lane of this multiplexer.
 * @param <N4> The type of the fifth object produced by the first lane of this multiplexer.
 * @param <N5> The type of the sixth object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex6WithValue<I0, I1, N0, N1, N2, N3, N4, N5> {
  private final I0 value;
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> firstMux;
  private final Function<I1, N1> secondMux;
  private final Function<I1, N2> thirdMux;
  private final Function<I1, N3> fourthMux;
  private final Function<I1, N4> fifthMux;
  private final Function<I1, N5> sixthMux;

  /**
   * @param demux The combinator function.
   * @param <O> The type of output object.
   * @return The result of passing the contained value to the {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <O> O demux(final Function6<N0, N1, N2, N3, N4, N5, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(this.value)),
        this.secondMux.apply(this.preComp.apply(this.value)),
        this.thirdMux.apply(this.preComp.apply(this.value)),
        this.fourthMux.apply(this.preComp.apply(this.value)),
        this.fifthMux.apply(this.preComp.apply(this.value)),
        this.sixthMux.apply(this.preComp.apply(this.value)));
  }

  /**
   * @param fold A function, representing a lane, which combines the values produced by the other
   *             lanes in the multiplexer.
   * @param <M0> The type of object produced by the new lane.
   * @return A multiplexer to which a lane has been added which combines the values produced by the
   * other lanes in the multiplexer.
   */
  public <M0> Multiplex7WithValue<I0, I1, N0, N1, N2, N3, N4, N5, M0> foldAdd(
      final Function6<N0, N1, N2, N3, N4, N5, M0> fold
  ) {
    return new Multiplex7WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux, this.sixthMux,
        value -> fold.apply(
            this.firstMux.apply(value),
            this.secondMux.apply(value),
            this.thirdMux.apply(value),
            this.fourthMux.apply(value),
            this.fifthMux.apply(value),
            this.sixthMux.apply(value)));
  }

  /**
   * @param multiplex A function, representing a lane, to add to the multiplexer.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex7WithValue<I0, I1, N0, N1, N2, N3, N4, N5, M0> add(
      final Function<I1, M0> multiplex
  ) {
    return new Multiplex7WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        this.sixthMux,
        multiplex);
  }

  /**
   * @param multiplex The A multiplexer with one lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex7WithValue<I1, I1, N0, N1, N2, N3, N4, N5, M0> join(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A primed multiplexer with one lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex7WithValue<I1, I1, N0, N1, N2, N3, N4, N5, M0> join(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        this.sixthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
