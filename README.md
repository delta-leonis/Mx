# `Mx`
> declarative object manipulation

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/28a03eed5fe74b33a8d4487b432ea227)](https://www.codacy.com/app/delta-leonis/Mx?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=delta-leonis/Mx&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/delta-leonis/Mx.svg?style=shield)](https://circleci.com/gh/delta-leonis/Mx)
[![codecov](https://codecov.io/gh/delta-leonis/Mx/branch/master/graph/badge.svg)](https://codecov.io/gh/delta-leonis/Mx)

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

Suppose we had the following deeply nested object structure (using lombok for brevity):

```java
  @Value
  public class School {
    private final String name;
    private final Set<SchoolClass> classes;
    
    @Value
    class SchoolClass {
      private final String name;
      private final Set<Student> students;
    }
    
    @Value
    class Student {
      private final int number;
      private final String name;
      private final float gpa;
    }
  }
```

And the following functions:

```java
public class SchoolMetrics {
  public static SchoolClass findBestClass(final Set<SchoolClass> schoolClass) { /* ... */ }
  
  public static SchoolClass findWorstClass(final Set<SchoolClass> schoolClass) { /* ... */ }
  
  public static Student findBestStudent(final Set<Student> students) { /* ... */ }
  
  public static StudentfindWorstStudent(final Set<Student> students) { /* ... */ }
}
```

Now given a school, suppose we want to generate an overview of the best student in the best class
and worst student in the worst class of the school, 
including student name, GPA and name of the student's class:

```java
@Value
class SchoolReport {
  private final String schoolName;
  private final String bestClassName;
  private final String bestStudentName;
  private final float  bestStudentGPA;
  private final String worstClassName;
  private final String worstStudentName;
  private final float  worstStudentGPA;
}

``` 
This could be implemented using `Mx` as follows:

```java

Mx.mux(inputSchool)
  // the name of the school
  .expand(School::getName)
  .expand(
      Mx.first(School::getClasses)
        // the best student in the best class
        .expand(
            Mx.first(SchoolMetrics::findBestClass)
                // the name of the best class
                .expand(SchoolClass::getName)
                .expand(
                    Mx.first(SchoolMetrics::findBestStudent)
                        // the name of the best student in the best class
                        .expand(Student::getName)
                        // the GPA of the best student in the best class
                        .expand(Student::getGPA)))
        // the worst student in the worst class
        .expand(
            Mx.first(SchoolMetrics::findWorstClass)
                // the name of the worst class
                .expand(SchoolClass::getName)
                .expand(
                    Mx.first(SchoolMetrics::findWorstStudent)
                        // the name of the worst student in the worst class
                        .expand(Student::getName)
                        // the GPA of the worst student in the worst class
                        .expand(Student::getGPA)))
  .demux(SchoolReport::new);
``` 

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
