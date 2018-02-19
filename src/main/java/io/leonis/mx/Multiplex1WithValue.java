package io.leonis.mx;

import io.reactivex.functions.Function;
import lombok.*;

/**
 * This class represents a (primed) multiplexer with one lane.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @param <N0> The type of object produced by the first lane of this multiplexer.
 *
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex1WithValue<I0, I1, N0> {
  private final I0 value;
  private final Function<I0, I1> preComp;
  private final Function<I1, N0> mux;

  /**
   * @return The result of passing the contained value to the {@link Function} representing the
   * composition of multiplexers and demultiplexers.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public N0 demux() throws Exception {
    return this.mux.apply(this.preComp.apply(this.value));
  }

  /**
   * @param multiplex A function, representing a lane, to add to the multiplexer.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex2WithValue<I0, I1, N0, M0> add(final Function<I1, M0> multiplex) {
    return new Multiplex2WithValue<>(this.value, this.preComp, this.mux, multiplex);
  }

  /**
   * @param multiplex The A multiplexer with one lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex2WithValue<I1, I1, N0, M0> join(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
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
  public <K0, M0, M1> Multiplex3WithValue<I1, I1, N0, M0, M1> join(
      final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
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
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2> Multiplex4WithValue<I1, I1, N0, M0, M1, M2> join(
      final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
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
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3> Multiplex5WithValue<I1, I1, N0, M0, M1, M2, M3> join(
      final Multiplex4WithoutValue<I1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
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
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex6WithValue<I1, I1, N0, M0, M1, M2, M3, M4> join(
      final Multiplex5WithoutValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
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
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithValue<I1, I1, N0, M0, M1, M2, M3, M4, M5> join(
      final Multiplex6WithoutValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex The A primed multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0> Multiplex2WithValue<I1, I1, N0, M0> join(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) throws Exception {
    return new Multiplex2WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
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
  public <K0, M0, M1> Multiplex3WithValue<I1, I1, N0, M0, M1> join(
      final Multiplex2WithValue<I1, K0, M0, M1> multiplex
  ) throws Exception {
    return new Multiplex3WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2> Multiplex4WithValue<I1, I1, N0, M0, M1, M2> join(
      final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
  ) throws Exception {
    return new Multiplex4WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3> Multiplex5WithValue<I1, I1, N0, M0, M1, M2, M3> join(
      final Multiplex4WithValue<I1, K0, M0, M1, M2, M3> multiplex
  ) throws Exception {
    return new Multiplex5WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux()
            .apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with five lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex6WithValue<I1, I1, N0, M0, M1, M2, M3, M4> join(
      final Multiplex5WithValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) throws Exception {
    return new Multiplex6WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex The A primed multiplexer with six lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @return A primed multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which that multiplexer was primed.
   * @throws Exception Thrown by the precomposition function when normalization fails.
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex7WithValue<I1, I1, N0, M0, M1, M2, M3, M4, M5> join(
      final Multiplex6WithValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) throws Exception {
    return new Multiplex7WithValue<>(this.preComp.apply(this.value), value -> value,
        this.mux,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value -> multiplex.getSixthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }
}
