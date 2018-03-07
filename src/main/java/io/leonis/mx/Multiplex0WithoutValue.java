package io.leonis.mx;

import java.util.function.Function;
import lombok.*;

/**
 * This class represents a(n unprimed) multiplexer without any lanes.
 *
 * @param <I0> The type of (external) input to the multiplexer.
 * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
 * @author Rimon Oz
 */
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public final class Multiplex0WithoutValue<I0, I1> {
  private final Function<I0, I1> preComp;

  /**
   * @param multiplex A function, representing a lane, to add to the multiplexer.
   * @param <M0>      The type of object produced by the new lane.
   * @return A multiplexer to which the supplied lane has been added.
   */
  public <M0> Multiplex1WithoutValue<I0, I1, M0> add(final Function<I1, M0> multiplex) {
    return new Multiplex1WithoutValue<>(this.preComp, multiplex);
  }

  /**
   * @param multiplex A primed multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0> Multiplex1WithoutValue<I1, I1, M0> join(
      final Multiplex1WithValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex1WithoutValue<>(
        value -> value,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1> Multiplex2WithoutValue<I1, I1, M0, M1> join(
      final Multiplex2WithValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex2WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1, M2> Multiplex3WithoutValue<I1, I1, M0, M1, M2> join(
      final Multiplex3WithValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1, M2, M3> Multiplex4WithoutValue<I1, I1, M0, M1, M2, M3> join(
      final Multiplex4WithValue<I1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with five lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex5WithoutValue<I1, I1, M0, M1, M2, M3, M4> join(
      final Multiplex5WithValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with six lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5> join(
      final Multiplex6WithValue<I1, K0, M0, M1, M2, M3, M4, M5> multiplex
  ) {
    return new Multiplex6WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSixthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A primed multiplexer with seven lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @param <M6>      The type of the seventh object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   * These lanes ignore outer input and operate on the value with which the supplied multiplexer
   * was primed.
   */
  public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> join(
      final Multiplex7WithValue<I1, K0, M0, M1, M2, M3, M4, M5, M6> multiplex
  ) {
    return new Multiplex7WithoutValue<>(value -> value,
        value ->
            multiplex.getFirstMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSecondMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getThirdMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFourthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getFifthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSixthMux().apply(multiplex.getPreComp().apply(multiplex.getValue())),
        value ->
            multiplex.getSeventhMux().apply(multiplex.getPreComp().apply(multiplex.getValue())));
  }

  /**
   * @param multiplex A multiplexer with one lane.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0> Multiplex1WithoutValue<I1, I1, M0> join(
      final Multiplex1WithoutValue<I1, K0, M0> multiplex
  ) {
    return new Multiplex1WithoutValue<>(
        value -> value,
        value -> multiplex.getMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex A multiplexer with two lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1> Multiplex2WithoutValue<I1, I1, M0, M1> join(
      final Multiplex2WithoutValue<I1, K0, M0, M1> multiplex
  ) {
    return new Multiplex2WithoutValue<>(value -> value,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex A multiplexer with three lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2> Multiplex3WithoutValue<I1, I1, M0, M1, M2> join(
      final Multiplex3WithoutValue<I1, K0, M0, M1, M2> multiplex
  ) {
    return new Multiplex3WithoutValue<>(value -> value,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex A multiplexer with four lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3> Multiplex4WithoutValue<I1, I1, M0, M1, M2, M3> join(
      final Multiplex4WithoutValue<I1, K0, M0, M1, M2, M3> multiplex
  ) {
    return new Multiplex4WithoutValue<>(value -> value,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex A multiplexer with five lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3, M4> Multiplex5WithoutValue<I1, I1, M0, M1, M2, M3, M4> join(
      final Multiplex5WithoutValue<I1, K0, M0, M1, M2, M3, M4> multiplex
  ) {
    return new Multiplex5WithoutValue<>(value -> value,
        value -> multiplex.getFirstMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getSecondMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getThirdMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFourthMux().apply(multiplex.getPreComp().apply(value)),
        value -> multiplex.getFifthMux().apply(multiplex.getPreComp().apply(value)));
  }

  /**
   * @param multiplex A multiplexer with six lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3, M4, M5> Multiplex6WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5> join(
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

  /**
   * @param multiplex A multiplexer with seven lanes.
   * @param <K0>      The type of internal input to the supplied multiplexer.
   * @param <M0>      The type of the first object produced by the supplied multiplexer.
   * @param <M1>      The type of the second object produced by the supplied multiplexer.
   * @param <M2>      The type of the third object produced by the supplied multiplexer.
   * @param <M3>      The type of the fourth object produced by the supplied multiplexer.
   * @param <M4>      The type of the fifth object produced by the supplied multiplexer.
   * @param <M5>      The type of the sixth object produced by the supplied multiplexer.
   * @param <M6>      The type of the seventh object produced by the supplied multiplexer.
   * @return A multiplexer to which the lanes of the supplied multiplexer have been added.
   */
  public <K0, M0, M1, M2, M3, M4, M5, M6> Multiplex7WithoutValue<I1, I1, M0, M1, M2, M3, M4, M5, M6> join(
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
