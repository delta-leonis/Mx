# `Mx`
> declarative object manipulation

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/28a03eed5fe74b33a8d4487b432ea227)](https://www.codacy.com/app/delta-leonis/Mx?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=delta-leonis/Mx&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/delta-leonis/Mx.svg?style=shield)](https://circleci.com/gh/delta-leonis/Mx)

`Mx` is a framework for declarative object manipulation. `Mx` does this by exposing an
API with which to destructure functions into a composition of multiplexers and demultiplexers.
More technically, given a `Function<A, B>`, `Mx` provides two methods, `expand` and `demux`,
where `expand` has the following forms:

  * `<C> expand(Function<A, C>)` expands the multiplexer by another lane which multiplexes an object of type `C`,
  * `expand(Multiplexer<T0, T1, ..., Tn>)` expand the multiplexer by adding the lanes from the supplied multiplexer (which multiplex objects of type `T1, T2, ..., Tn`).

The return type of `expand` is another multiplexer so that methods can be chained.  


`demux` has the following forms:

  * `<O> demux(Function<T1, T2, ... Tn, O>)` demultiplexes all the functions in the multiplexer using the supplied combinator.
  * `<O> demux(I, Function<T1, T2, ... Tn, O>)` demultiplexes all the functions in the multiplexer and applies the result to the supplied input.
  
## Examples

TODO

## Dependency

`Mx` is not yet available through maven or gradle.

## Overview

## Documentation

The javadoc for the current code on `master` can be found on https://delta-leonis.github.io/Mx/

## Building

Make sure you have `gradle>=v2.10` installed. Run the following to build the application:

```
  gradle build
```

## Copyright

This project is licensed under the MIT license (see LICENSE).

```
MIT License

Copyright (c) 2018 delta-leonis; Rimon Oz, Jeroen de Jong

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
