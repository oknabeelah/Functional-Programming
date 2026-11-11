10/11/2026
## Sequences
Clojure's main abstraction of data structures
`(cons item sequence)`  Adds an item to the start of the sequence
`(seq collection)`  Returns a sequence Given a collection such as a vector
`(conj sequence item)`  This adds a new item to the start of a sequence.


**The sequence library**
Clojure’s sequence library provides all of the functionality that you need to work on sequences. It works across all data structures that implement `first`/`rest`/`cons`. Functions within the library provide four core aspects of processing:

- Creation of sequences  
    `range, repeat, take, iterate, join`
- Filtering  
    `filter, take, take-while, drop-while`
- Predicates  
    `every?, some, not-every?, not-any?`
- Transformations  
    `map, reduce. sort, sort-by, for`

**Lazy sequences:** Sequences are lazy. Items are not generated until they are needed.
concrete implementation of the sequence is a `PersistentVector`.

## Maps
The map is probably the most useful collection in all of programming.
```clojure
(def my-map {:key1 "value1" :key2 "value2"})
```

## Sets
Sets are collections of unique items. In Clojure they work just as you would expect from maths or from other languages.
`(def my-set #{:item1 :item2 :item3})`

```clojure
(require '[clojure.set as set])

(def s1 #{"groucho" "harpo" "gummo" "zeppo"})
(println s1) ;; print
(println (sort s1)) ;; sort alphabetically

(def s2 #{"spike" "michael" "harry" "peter"})
(println (set/union s1 s2)) ;; return union
TO DO !;; print the list with names properly capitalised
```

---
placing `'` in front of `(` is how a sequence is defined in clojure
because `(` is interpreted as a function, `'` stops it being interpreted as code.

## Sets as Pseudo relational collections
The set can be used as a relation if it the values it contains are maps.
```clojure
(def relation #{ 
	{:name "Mary" :age 108} 
	{:name "Wasim" :age 54} 
	{:name "Jane" :age 21} 
})
```

`(join relation1 relation2)`  Performs a natural join across the two relations.

A relation about animal ownership is joined with a relation about animal personality. The join is used to produce a relation joining information about an animal’s personality to that animal.
```clojure
(def animals #{
	{:name "betsy" :owner "brian" :kind "cow"} 
	{:name "jake" :owner "brian" :kind "horse"} 
	{:name "josie" :owner "dawn" :kind "cow"} }) 

(def personalities #{
{:kind "cow" :personality "stoic"} 
{:kind "horse" :personality "skittish"} }) 

(join animals personalities)
```

produces
```clojure
#{
{:owner "dawn", :name "josie", :kind "cow", :personality "stoic"} 
{:owner "brian", :name "betsy", :kind "cow", :personality "stoic"} 
{:owner "brian", :name "jake", :kind "horse", :personality "skittish"} }
```

If cows had two personalities, instead of one, each cow would have two rows in the output. Suppose `personalities` used `:species` instead of `:kind`, then we would need to produce a join across two different keys

Let’s start by redefining `personalities`:
```clojure
(def personalities #{
{:species "cow" :personality "stoic"} 
{:species "horse" :personality "skittish"} })
```

if the two collections are now joined we get:
```clojure
(join animals personalities) 
#{
{:kind "horse", :owner "brian", :name "jake", :species "cow", :personality "stoic"} 
{:kind "cow", :owner "dawn", :name "josie", :species "cow", :personality "stoic"} 
{:kind "horse", :owner "brian", :name "jake", :species "horse", :personality "skittish"} 
{:kind "cow", :owner "brian", :name "betsy", :species "cow", :personality "stoic"} 
{:kind "cow", :owner "dawn", :name "josie", :species "horse", :personality "skittish"} 
{:kind "cow", :owner "brian", :name "betsy", :species "horse", :personality "skittish"} }
```

Which doesn’t work because _Jake_ is now a horse _and_ a cow. We can tell `join` to act like a “proper” relational join and produce output only where the `:kind` value is the same as the `:species` value.
```clojure
(join animals personalities {:kind :species}) 
#{ {:kind "cow", :owner "dawn", :name "josie", :species "cow", :personality "stoic"} 
{:kind "horse", :owner "brian", :name "jake", :species "horse", :personality "skittish"} 
{:kind "cow", :owner "brian", :name "betsy", :species "cow", :personality "stoic"} }
```

`(select predicate set)`  
Performs a selection across the set and returns a new set for which the predicate is true.

`(project set [keys])`  
Builds a projection across the set in which only those properties given in the `keys` list are returned.

`(index set key)`  
Searches the set of relations for items in which the key is found. Then builds a map of the values of the key to associated rows in the relation and returns this map.

## Date and Time exercises

```clojure
(require '[java-time.api :as jt])
 
(defn dates
  []
  (println (jt/local-date)) ;; write todays date and print
  (println (jt/plus (jt/local-date) (jt/days 7))) ;; write the date in 7 days
  (println)
)

(defn convert-date-format
      [from to date-str]
      (if (and (#{"us" "uk"} from) (#{"us" "uk"} to) )
      ; parse date
      (let [[a b c] (map #(Integer/parseInt %) (.split date-str " "))
            date (if (= from "uk")
                  (jt/local-date c b a) ; local date input: yyyy mm dd
                  (jt/local-date c a b))]
      ; convert
            (if (= to "us")
              (jt/format "MM/dd/yyyy" date) ; if to US
              (jt/format "dd/MM/yyyy" date) ; if to UK
              )
        )
        (println "Invalid format") )
  )

(defn collect-input-and-call
      []
      (println "Enter the date you wish to format space separated => ")
      (def date (read-line))
      (println "What format is it? us or uk => ")
      (def from (read-line))
      (println "What format do you want it in? us or uk => ")
      (def to (read-line))
      (println (str "Formatting date \"" date "\" from  \"" from "\" format to  \"" to "\" format..."))
      (println(convert-date-format from to date))
  )

;main
(dates)
(collect-input-and-call)
```

