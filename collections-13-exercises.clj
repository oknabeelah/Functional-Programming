(require '[clojure.pprint :as p])

;; 1. Write a program that given a phrase can count the occurrences of each word in that phrase.
;; For example for the input :olly :in :olly :free :come it should produce
;; :olly 2
;; :in 1
;; :come 1
;; :free 1

;; (defn count-words [phrase]
;;      (frequencies phrase)
;;   )
(defn count-words [phrase]
  (loop [remaining phrase
         counts {} ]
    (if (empty? remaining)
      counts
      (let [word (first remaining)
            current-count (get counts word 0) ]
        (recur (rest remaining)
               (assoc counts word (inc current-count)) ;; assoc updates counts with the word and its incremented count
            ) )
      )
    )
  )

(count-words [:olly :in :olly :free :come])

;; 2. Convert the simple database of modules from the vector exercises to using a map for each module 
;;    and a further map to hold the timetable for a tutorial group.
;;
;; (def data
;;   [["9310" "Fundamentals of Programming" "10:00" 1]
;;    ["521" "Programming for Beginners" "10:00" 1]
;;    ["9306" "Networking and Server Administration" "14:00" 2]
;;    ["310" "Fundamentals of Programming" "15:00" 1]])
;;
;; a class could look like - {:room "9310" :subject "Fundamentals of Programming" :starts "10:00" :duration 1}
;; a timetable -
;; (def timetable { 
;;       :group1 [{:room "9310"... } {:room "521"... }]
;;       :group2 [{:room "9353"...} {:room "9310"... }]})

(let [timetable {:group1 [{:room "9310" :subject "Fundamentals of Programming" :starts "10:00" :duration 1}
                          {:room "521" :subject "Programming for Beginners" :starts "10:00" :duration 1}
                          {:room "9306" :subject "Networking and Server Administration" :starts "14:00" :duration 2}]
                 :group2 [{:room "310" :subject "Fundamentals of Programming" :starts "15:00" :duration 1}]}]


  (println timetable) ;; The whole data structure
  (let [groups (keys timetable)]
    (println groups) ;; The keys of the map

  (println (get-in timetable [(first (first timetable)) 0])) ;; The first row of data

  (println (subvec ((first (first timetable)) timetable) 1)) ;; All except the first (in group1)  
    
    )
  ;; All rows in which the class is taught in room 310
  ;; All rows in which the class is not taught in room 310
  ;; Classes which are one hour long
  ;; Classes on the third floor of building nine
  ;; Classes which are not titled Fundamentals of something
  )                                              



