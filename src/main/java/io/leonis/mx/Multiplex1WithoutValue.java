package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.*;

/**
 * This class represents a(n unprimed) multiplexer with one lane.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex1WithoutValue<I0, I1, N0> {
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> mux;

  /**
   * @param value The value to operate on.
   * @return The result of passing the supplied value to the {@link Function} representing the
   * composition of multiplexers and demultiplexers.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public N0 demux(final I0 value) throws Exception {
    return this.mux.apply(this.preComp.apply(value));
  }

  /**
   * @return A {@link Function} representing the composition of multiplexers and demultiplexers.
   */
  public Function<I0, N0> demux() {
    return value -> this.mux.apply(this.preComp.apply(value));
  }

  /**
   * @param fold A function, representing a lane, which combines the values produced by the other
   *             lanes in the multiplexer.
   * @param <M0> The type of object produced by the new lane.
   * @return A multiplexer to which a lane has been added which combines the values produced by the
   * other lanes in the multiplexer.
   */
  public <M0> Multiplex2WithoutValue<I0, I1, N0, M0> foldAdd(
      final Function<N0, M0> fold
  ) {
    return new Multiplex2WithoutValue<>(this.preComp,
        this.mux,
        value -> fold.apply(this.mux.apply(value)));
  }

  /**
   * @param multiplex A function, representing a lane, to add to the multiplexer.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex2WithoutValue<I0, I1, N0, M0> add(final Function<I1, M0> multiplex) {
    return new Multiplex2WithoutValue<>(this.preComp, this.mux, multiplex);
  }

  /**
   * @param multiplex The A multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0> Multiplex2WithoutValue<I1, I1, N0, M0> join(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex2WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1> Multiplex3WithoutValue<I1, I1, N0, M0, M1> join(
      final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2> Multiplex4WithoutValue<I1, I1, N0, M0, M1, M2> join(
      final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3> Multiplex5WithoutValue<I1, I1, N0, M0, M1, M2, M3> join(
      final Multiplex4WithoutValue<I1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with five lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex6WithoutValue<I1, I1, N0, M0, M1, M2, M3, M4> join(
      final Multiplex5WithoutValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with six lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithoutValue<I1, I1, N0, M0, M1, M2, M3, M4, M5> join(
      final Multiplex6WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0> Multiplex2WithoutValue<I1, I1, N0, M0> join(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex2WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0, M1> Multiplex3WithoutValue<I1, I1, N0, M0, M1> join(
      final Multiplex2WithValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0, M1, M2> Multiplex4WithoutValue<I1, I1, N0, M0, M1, M2> join(
      final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0, M1, M2, M3> Multiplex5WithoutValue<I1, I1, N0, M0, M1, M2, M3> join(
      final Multiplex4WithValue<I1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A multiplexer with five lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex6WithoutValue<I1, I1, N0, M0, M1, M2, M3, M4> join(
      final Multiplex5WithValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A multiplexer with six lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithoutValue<I1, I1, N0, M0, M1, M2, M3, M4, M5> join(
      final Multiplex6WithValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
