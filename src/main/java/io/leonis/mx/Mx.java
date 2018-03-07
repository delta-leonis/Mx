package io.leonis.mx;

import java.util.function.Function;
import lombok.experimental.UtilityClass;

/**
 * The Class Mx.
 * <p>
 * This class represents a builder of an object which can destructure functions into a composition
 * of multiplexers and demultiplexers. More technically, given a
 * {@link Function Function&lt;A, B&gt;}, this class produces objects which provide three methods,
 * <code>add</code>, <code>join</code>, and <code>demux</code>, where <code>add</code> has the following forms:
 * </p>
 * <ul>
 * <li><code>&lt;C&gt; add(Function&lt;A, C&gt;)</code>adds another lane to the multiplexer which produces an object of type <code>C</code>,</li>
 * </ul>
 * <p>
 * <code>join</code> has the following form:
 * </p>
 * <ul>
 * <li><code>join(Multiplexer&lt;T0, T1, ..., Tn&gt;)</code> adds all the lanes from the supplied multiplexer (which multiplex objects of type  <code>T1, T2, ..., Tn</code>) to the multiplexer.</li>
 * </ul>
 * <p>
 * The return type of <code>add</code> and <code>expand</code>is another multiplexer so that methods can be chained.
 * <code>demux</code> has the following forms:
 * </p>
 * <ul>
 * <li><code>&lt;O&gt; demux(Function&lt;T1, T2, ... Tn, O&gt;)</code> demultiplexes all the functions in the multiplexer using the supplied combinator.</li>
 * <li><code>&lt;O&gt; demux(I, Function&lt;T1, T2, ... Tn, O&gt;)</code> demultiplexes all the functions in the multiplexer and applies the result to the supplied input.</li>
 * </ul>
 *
 * @author Rimon Oz
 */
@UtilityClass
public final class Mx {

  /**
   * @param value The value to prime the multiplexer with.
   * @param preComp The precomposition function to apply to any expansions to the multiplexer.
   * @param <I0> The type of (external) input to the multiplexer.
   * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
   * @return A multiplexer primed with the supplied argument and precomposition function.
   */
  public static <I0, I1> Multiplex0WithValue<I0, I1> muxFirst(
      final I0 value,
      final Function<I0, I1> preComp
  ) {
    return new Multiplex0WithValue<>(value, preComp);
  }

  /**
   * @param preComp The precomposition function to apply to any expansions to the multiplexer.
   * @param <I0> The type of (external) input to the multiplexer.
   * @param <I1> The type of internal input, or the type used as input to any expansions to the multiplexer.
   * @return A multiplexer primed with the supplied precomposition function.
   */
  public static <I0, I1> Multiplex0WithoutValue<I0, I1> first(final Function<I0, I1> preComp) {
    return new Multiplex0WithoutValue<>(preComp);
  }

  /**
   * @param value The value to prime the multiplexer with.
   * @param <I> The type of (external and internal) input to the multiplexer.
   * @return A multiplexer primed with the supplied value.
   */
  public static <I> Multiplex0WithValue<I, I> mux(final I value) {
    return new Multiplex0WithValue<>(value, identity -> identity);
  }

  /**
   * @param <I> The type of (external and internal) input to the multiplexer.
   * @return A(n unprimed) multiplexer.
   */
  public static <I> Multiplex0WithoutValue<I, I> mux() {
    return new Multiplex0WithoutValue<>(value -> value);
  }

}
