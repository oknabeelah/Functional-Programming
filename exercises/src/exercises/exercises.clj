;Exercises
;1.1 evalues to true if x is true, otherwise false
(let [is-x-true? (fn [x y] ; a function that returns a bool is a predicate ie name with ?
                    (= x true))]
  (is-x-true? true false))
; (true? x) ; built in predicate that returns true if x is true

;1.2 evaluates to true if either x or y is true otherwise false
(defn is-x-or-y-true? [x y]
  (or x y))
(is-x-or-y-true? true false)
; who's responsibility is it to pass in the right input -  

;1.3 evaluate to true if both x and y are true
(defn is-x-and-y-true? [x y]
  (and x y))
is-x-and-y-true? true false

; exclusive or: if both x and y are true return false
(let [xor (fn [x y]
            (if (and x y)
              false
              (if (and (true? x) (false? y))
                true
                (if (and (false? x) (true? y))
                  true))))]
  (xor false true))
; alternative soln 
(let [xor (fn [x y]
            (cond
              (= 3 x) "what?"
              (and x y) false
              (and (true? x) (false? y)) true
              :else true
              ))]
  (xor ))

;2 convert a temperature in C to F 
; F = (C * 9/5) + 32
(defn celsius-to-farenheit [x]
  (+ (* x (/ 9 5)) 32)
)
(celsius-to-farenheit 0)
; 32N is 32 as a big integer


;3 temperature conversion scale
; scale [Kelvin, Celsius, Farenheit, Rankine, Delisle, Newton, Rèaumur, Rømer]
; -> is used to signify transformation

(defn convert-to-kelvin [x y]
   (cond
     ; (predicate) (action)
     (= y "C") (+ x 273.15)
     (= y "F") (* (+ x 459.67) (/ 5 9))
     (= y "Ra") (* x (/ 5 9))
     (= y "D") (* (- 373.15 x) (/ 2 3))
     (= y "N") (+ (* x (/ 100 33)) 273.15)
     (= y "Rè") (+ (* x (/ 5 4)) 273.15)
     (= y "Rø") (+ (* (- x 7.5) (/ 24 7)) 273.15)
     :else "Invalid input"))

(defn convert-temperature [x y z] 
  (let [kelvin (if (not= y "K")
                 (convert-to-kelvin x y)
                 x)]
    (cond
      (= z "C") (- kelvin 273.15)
      (= z "F") (- (* kelvin (/ 9 5)) 459.67)
      (= z "Ra") (* kelvin (/ 9 5))
      (= z "D") (* (- 373.15 kelvin) (/ 3 2))
      (= z "N") (* (- kelvin 273.15) (/ 33 100))
      (= z "Rè") (* (- kelvin 273.15) (/ 4 5))
      (= z "Rø") (+ (* (- kelvin 273.15) (/ 7 24)) 7.5)
      :else "Invalid input")))

(convert-temperature 0 "C" "F")

; currently cases -> k, how to get k -> cases using the same func
