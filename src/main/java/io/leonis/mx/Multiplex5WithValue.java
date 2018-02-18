package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

/**
 * This class represents a (primed) multiplexer with five lanes.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of the first object produced by the first lane of this multiplexer.
 * @param <N1> The type of the second object produced by the first lane of this multiplexer.
 * @param <N2> The type of the third object produced by the first lane of this multiplexer.
 * @param <N3> The type of the fourth object produced by the first lane of this multiplexer.
 * @param <N4> The type of the fifth object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex5WithValue<I0, I1, N0, N1, N2, N3, N4> {
  private final I0 value;
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> firstMux;
  private final Function<I1, N1> secondMux;
  private final Function<I1, N2> thirdMux;
  private final Function<I1, N3> fourthMux;
  private final Function<I1, N4> fifthMux;

  /**
   * @param demux The combinator function.
   * @return The result of passing the contained value to the {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <O> O demux(final Function5<N0, N1, N2, N3, N4, O> demux) throws Exception {
    return demux.apply(
        this.firstMux.apply(this.preComp.apply(value)),
        this.secondMux.apply(this.preComp.apply(value)),
        this.thirdMux.apply(this.preComp.apply(value)),
        this.fourthMux.apply(this.preComp.apply(value)),
        this.fifthMux.apply(this.preComp.apply(value)));
  }

  /**
   * @param multiplex A function, representing a lane, to expand the multiplexer with.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex6WithValue<I0, I1, N0, N1, N2, N3, N4, M0> expand(
      final Function<I1, M0> multiplex
  ) {
    return new Multiplex6WithValue<>(this.value, this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux, this.fifthMux,
        multiplex);
  }

  /**
   * @param multiplex The A multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex6WithValue<I1, I1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1> Multiplex7WithValue<I1, I1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A primed multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex6WithValue<I1, I1, N0, N1, N2, N3, N4, M0> expand(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1> Multiplex7WithValue<I1, I1, N0, N1, N2, N3, N4, M0, M1> expand(
      final Multiplex2WithValue<I1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        this.fifthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
