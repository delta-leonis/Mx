package io.leonis.mx;

import io.reactivex.functions.*;
import lombok.*;

/**
 * This class represents a(n unprimed) multiplexer with four lanes.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of the first object produced by the first lane of this multiplexer.
 * @param <N1> The type of the second object produced by the first lane of this multiplexer.
 * @param <N2> The type of the third object produced by the first lane of this multiplexer.
 * @param <N3> The type of the fourth object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex4WithoutValue<I0, I1, N0, N1, N2, N3> {
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> firstMux;
  private final Function<I1, N1> secondMux;
  private final Function<I1, N2> thirdMux;
  private final Function<I1, N3> fourthMux;

  /**
   * @param value The value to operate on.
   * @param demux The combinator function.
   * @param <O> The type of output object.
   * @return The result of passing the supplied value to the {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <O> O demux(final I1 value, final Function4<N0, N1, N2, N3, O> demux)
      throws Exception {
    return demux.apply(
        this.firstMux.apply(value),
        this.secondMux.apply(value),
        this.thirdMux.apply(value),
        this.fourthMux.apply(value));
  }

  /**
   * @param demux The combinator function.
   * @param <O> The type of output object.
   * @return A {@link Function} representing the
   * composition of multiplexers, demuxed by the supplied combinator function.
   */
  public <O> Function<I1, O> demux(final Function4<N0, N1, N2, N3, O> demux) {
    return value -> demux.apply(
        this.firstMux.apply(value),
        this.secondMux.apply(value),
        this.thirdMux.apply(value),
        this.fourthMux.apply(value));
  }

  /**
   * @param fold A function, representing a lane, which combines the values produced by the other
   *             lanes in the multiplexer.
   * @param <M0> The type of object produced by the new lane.
   * @return A multiplexer to which a lane has been added which combines the values produced by the
   * other lanes in the multiplexer.
   */
  public <M0> Multiplex5WithoutValue<I0, I1, N0, N1, N2, N3, M0> foldAdd(
      final Function4<N0, N1, N2, N3, M0> fold
  ) {
    return new Multiplex5WithoutValue<>(this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
        value -> fold.apply(
            this.firstMux.apply(value),
            this.secondMux.apply(value),
            this.thirdMux.apply(value),
            this.fourthMux.apply(value)));
  }

  /**
   * @param multiplex A function, representing a lane, to add to the multiplexer.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex5WithoutValue<I0, I1, N0, N1, N2, N3, M0> add(
      final Function<I1, M0> multiplex
  ) {
    return new Multiplex5WithoutValue<>(this.preComp,
        this.firstMux, this.secondMux, this.thirdMux, this.fourthMux,
        multiplex);
  }

  /**
   * @param multiplex The A primed multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   */
  public <K0, M0> Multiplex5WithoutValue<I1, I1, N0, N1, N2, N3, M0> join(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   */
  public <K0, M0, M1> Multiplex6WithoutValue<I1, I1, N0, N1, N2, N3, M0, M1> join(
      final Multiplex2WithValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   */
  public <K0, M0, M1, M2> Multiplex7WithoutValue<I1, I1, N0, N1, N2, N3, M0, M1, M2> join(
      final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0> Multiplex5WithoutValue<I1, I1, N0, N1, N2, N3, M0> join(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A primed multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1> Multiplex6WithoutValue<I1, I1, N0, N1, N2, N3, M0, M1> join(
      final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A primed multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2> Multiplex7WithoutValue<I1, I1, N0, N1, N2, N3, M0, M1, M2> join(
      final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.firstMux,
        this.secondMux,
        this.thirdMux,
        this.fourthMux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }
}
