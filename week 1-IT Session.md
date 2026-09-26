22/09/2026


command to run clojure code in terminal
-M means there is no main method ie interpret the whole file
``` 
clj -M <file path>

```

The basic Clojure REPL
REPL is an acronym taken from Read - Evaluate - Print - Loop. It’s a way of executing code that has been common for functional, and other interpreted languages for many decades. A REPL can be used to run a program from start to finish, or it can be used to execute fragments of code. 
```
codio@condoremerald-gorillanylon:~/workspace$ clojure
Clojure 1.12.3
user=> (println (+ 7 (* 8 9)))
79
nil
user=> 

```

The basic structure of all Clojure code is an operation. All operations take the form `left parenthesis operation operators right parenthesis.`

In Clojure, everything is immutable so we call variables "vars".

The most basic numeric type is the integer. 
These are implemented using fixed precision 64-bit longs, as in Java. 
Clojure integers are sufficiently large for most cases, but if you need more then there is also a `BigInt` type which is a Clojure implementation of Java’s `BigInteger.`

Clojure has all of the arithmetic operations that you would expect. It also has several useful functions. Working in the REPL, experiment with the following functions
```
+, -, mod, rem, quot, inc, dec, max, min, *, /
```


#### print vs println

java.lang.Long
Long - a Class object

java.lang.IFn
IFn - interface Function (an abstraction of a class) -it defines the public method and field that the class exposes, doesn't include any implementation
A function is defined as a code structure
A class defines a type (a data type, with functionality)

To read
- [ ] SOLID
- [ ] Liskov substitution principle
- [ ] Design patterns 1994
- [ ] 

`##Inf`, `##-Inf`, and `##NaN` represent positive infinity, negative infinity, and not a number.

Clojure supports both strings and characters, and is **Unicode compliant**. The language comes with a toolbox of functions for the manipulation of text data.

Strings are contiguous sets of characters. They are delimited using double quotes: `"like this"`, `"they can include \n special characters"`.  
Characters are prefixed with a backslash character _not_ surrounded by single quotes: `\a`, `\Z`. There are also a number of special forms that you can use as characters including `\backspace`, `\tab`, `\newline`, `\return`, and `\space`.

Strings are built using the `(str)` function. This takes a list of items and returns a string representation. For example `(str \a \b \c)` returns `abc`. In the REPL you’ll see that with quotes around it: `"abc"`.

The really useful string manipulation functions live in the `clojure.string` library. Libraries are added to your code using a call to `(require )`.
You include libraries in your code using `(require )`. For example, `(require 'clojure.string)`. 
Notice the leading single quote - that stops the code being run through the interpreter and treats it as a literal string rather than as Clojure code.  
If you want to use an alias for a library, you do so using `(require '[clojure.string :as str])`. Notice the whole form including the positioning of that leading quote. Now you can use forms such as `(str/upper-case "abc")`.

`*` and `+` can take in a list of args ie (+ 2 3 4 5) or (* 2 3 4 5)

predicate is boolean logic, done like this - `(string? "abc")`

regular expressions
