20/10/2026

**Collections**
A collection gathers together different data items so that they can be referenced and acted upon as a single thing.
In Clojure all of the collections are variants on lists. These include the list, vector, map, set, and queue. And all of them are conceptually sequences of data items.
%%the vector and map are the most common%%
Clojure collections are immutable. They don’t change once you have created them. 
Functions such as `assoc` and `dissoc` create new collections that incorporate the existing and new structures. This means that the collections are said to be _persistent_ structures that guarantee to have preserved prior states.

**Some common operations of sequences include:**
- `count` which returns the length of the collection
- `conj` which interpolates a list into the last position of the collection
- `into` unrolls a list and appends its contents to the collection
- `seq` walks the collection and returns it as a sequence

Vectors are structures that hold zero or more elements. Those elements are stored sequentially and accessed by their _index_. 
You can think of a vector as being an array but with the additional properties of _immutability_ and _persistence_.
The easiest way to create a vector is to put a sequence of values inside square brackets and assign a name to it:
```clojure
(def data [1 2 3 4 \a])
```

The `range` function makes a _lazy sequence_ of values. 
A lazy sequence produces its next value only when asked to do so by calling code. 
They are used to make, or return, very long lists of data that you neither want nor need to hold in memory.

**Modifying a vector:**
- `conj` is used to add items to a list. it takes two or three arguments - the collection to modify, 1 item to add to it, and optionally a  list of more items to add to it
```clojure
(conj collection item)
(conj collection item & list)
```

`conj` works differently for vectors and sequences, and for each concrete type. It _appends_ to a vector and _prepends_ to a sequence.
```clojure
(conj [1 2 3] 4) ;;=> [1 2 3 4]
(conj '(1 2 3) 4) ;;=> (4 1 2 3)
(conj ["a" "b" "c"] "d") ;;=> ["a" "b" "c" "d"]
(conj [1 2] 3 4) ;;=> [1 2 3 4]
(conj '(1 2) 3 4) ;;=> (4 3 1 2)
(conj [[1 2] [3 4]] [5 6]) ;;=> [[1 2] [3 4] [5 6]]
```

- `cons` is used to add something to the _start_ of a list. it takes two arguments, the the item that you wish to add, and the list `(cons item sequence)`
```clojure
(cons 1 '(2 3 4 5 6)) ;;=> (1 2 3 4 5 6)
(cons [1 2] [4 5 6]) ;;=> ([1 2] 4 5 6)
```

Strictly speaking `cons` modifies a sequence not a vector. 
However, you can easily transform the result into a vector.

- `into` is used to extend a vector
```clojure
(let [my-vector [:a :b :c]] 
  (into my-vector (range 10)))
```


There are many functions that will transform your vector and return a new collection:
- `(first list)` returns the head of the list
- `(rest list)` returns the rest of the elements
- `(peek list)` returns the last element
- `(pop list)` returns elements up to the last one
- `(get list <idx>)` return the elements at position `idx`
- `(subvec list s e)` return elements from position `s` optionally stopping at position `e`
- `(every? pred list)` returns `true` if the predicate applies to _all_ elements
- `(some pred list)` returns `true` if the predicate applies to _some_ of the elements

As there is no iteration or recursion in clojure, here are ways to move across vectors:
- `(filter pred list)` applies the predicate to all elements and returns a sequence of those which evaluate to `true`.
- `(map f list)` applies function `f` to all elements of the list and returns a new list.
- `(reduce f list)` applies `f` to the first two elements, then to the result and element 3, and so on.
- `(sort list)` will sort the list using a _sensible_ ordering. The order depends upon the types that are found in the collection. You can optionally pass a comparator function as the second item: `(sort comparator list)`.
- `(sort-by f comparator list)` sorts the list using a comparator function which is provided as a lambda in the call.

### Quick exercises
 Use the `reduce` function to “total up” the sequence `[1 2 (/ 22 7) 13.5 -42]`.
```clojure
(println(reduce + [1 2 (/ 22 7) 13.5 -42]))
```

Sort the following collection in _reverse_ order using either of the `sort` or `sort-by` functions; `[198 2 (/ 22 7) 13.5 -42]`.
```clojure
(println(sort > [198 2 (/ 22 7) 13.5 -42]))
```

Clojure has a for-style loop, although it doesn’t modify state and so isn’t _really_ a for loop.
```clojure
(for [ next (range 5) ] 
  (println next))
```

**Destructuring** is a way to concisely bind names to the values inside a data structure.

```clojure
(def my-line [[5 10] [10 20]])

(let [[p1 p2] my-line
      [x1 y1] p1
      [x2 y2] p2]
 (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))
```

nth vs get
if an item is not found, nth returns an exception while get returns nil
