(ns clojure-noob.core
  (:use [clojure.math.numeric-tower :only (gcd, sqrt)])
  (:import (java.text NumberFormat) (javax.swing JFrame JLabel))
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot.")
  (println "Cleanliness is next to godliness"))

(defn train
  []
  (println "Choo chooa!"))

(+ 1 (* 2 3) 4)

(if true?
  "sachin"
  "Sachin")

(if true?
  (do (println "Success!")
      "abra cabadra")
  (do (println "Failure")
      "hocus pocus"))

;;; 'when' is a combination of 'if' and 'do' with no 'else' form.
(when true?
  (println "Success-!")
  "abra ka dabra")

(def failed-protagonist-names
  ["Larry Potter"
   "Doren the Explorer"
   "The Incredible Bulk"])

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))

(x-chop "sachin" "Hooya")
(x-chop "sachin")

;;; maps: are like dictionaries or hashes in other languages
{}

{:a 1
 :b "boring example"
 :c []}

;;; --------------------
;;; using 'get'

;  (get {a: 0 :b 1} :b)

;;; using 'vectors'
(vector "creepy" "full" "moon")

;;; element get added at the end of the vector
(conj [1 2 3] 4)

;;; ---- Lists ----
;;; using 'nth'
(nth '(100 200 300 400) 2)

(list 1 2 3 4)

;;; add element at the begining of list
(conj '(1 2 3) 4)

;;;  ---- sets ----
#{"hannan montana" "miley cyrus" 20 45}

(set [3 3 3 4 4])

;;; 3 exists in vector
(get (set [3 3 3 4 4]) 3)

;;; 5 exists in vector
(get (set [3 3 3 4 4]) 5)

;;; create a hash map and sorted map
(hash-set 1 1 3 1 2)

(sorted-set :b :a :c)



;;; --- Symbols and Naming ---
(def failed-movie-names
  ["Gone with the moving air", "swellfellas"])

;;; identity returns its argument
(identity 'test)

;;; --------------------
;;; Calling functions
(- 1 2 34)
(first [1 2 3 4 5])

(or + -)                                ;returns addition function
((or + -) 1 2 3)                        ;lets add the list

(and (= 1 1) 2)                         ;returns 2 if (= 1 1), else false
((and (= 1 1) +) 1 2 3)                 ;if true, add the list

((first [+ 0]) 1 2 3)

(inc 1.1)                               ;increment function


;;; --- Function parameters ----
(defn no-param
  []
  "I take no parameters")

(defn one-param
  [x]
  (str "I take one param: " x " It'd better ba a string."))

(defn two-param
  [x y]
  (str "two param " x " " y))

;;; --- multi arity function ---
(defn multi-arity
  ;; 3 arity argument and body
  ([x y z]
     (str x y z))
  ([x y]
     (str x y))
  ([x]
     (str x)))

;;; rest-param function
(defn codger-communication
  [whippersnapper]
  (str "Get of my lawn, " whippersnapper "!!!"))

;;; now using rest-param(&)
(defn codger
  [& whippersnapper]
  (map codger-communication whippersnapper))

;;; mixing rest-param and normal-param
(defn dodger
  [name & habits]
  (str "Hello " name ", You like " habits))

(defn weird-arity
  ([]
     "some text")
  ([number]
     (inc number)))

;;; returns the first element of a collection
(defn my-first
  [[first-thing]]; NOtice that first-thing is within a vector
  first-thing)

;; (my-first ["oven" "bike" "axe"])

(defn my-other-first
  [collection]
  (first collection))

(my-other-first ["nickel" "hair"])

(defn announc-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announc-treasure-location {:lat 28.22 :lng 81.33})

;; Anonymous functions

;; Anonymous function body
;; (fn [param-list]
;;   (function-body))

(map (fn [name] (str "Hi, " name))
     ["Dartg Vader" "He-man"])

;; Another function
((fn [x] (* x 3)) 8)

;; Associate anonymous function with the name
(def my-special-multiplier (fn [x] (* x 3)))
;; (my-special-multiplier 5)

;; More compact way to create anonymous functions
#(* % 3)                                ;where '%' act as a variable.

; (#(* % 3) 8)
; (map #(* % 3) [1 2 3])

;; Anonymous functions can get multiple arguments
(#(str %1 " and " %2) "corn bread" "butter beans")

;; If your anonymous function takes multiple arguments, you can
;; distinguish them like this: %1, %2, %3, etc. % is equivalent to %1

;; Pass a rest-param to anonymous function
(#(identity %&) 1 "blarg" :yip)

;;; --------------------
;; Returning function
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

; (inc3 9)

;;; do-things - Section 4 starts from here
(let [x 3] x)
;; => 3

(def dalmatian-list
    ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
    dalmatians)

(def x 0)
(let [x (inc x)] x)
;; => 1

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 5)
    (println "Goodbye!")
    (recur (inc iteration))))


(defn recursive-printer
  ([]
     (recursive-printer 0))
  ([iteration]
     (println (str "Iteration - " iteration))
     (if (> iteration 3)
       (println "Goodbye!")
       (recursive-printer (inc iteration)))))
(recursive-printer)

;; 4.4 Regular expressions
(defn has-matching-part?
  [part]
  (re-find #"^left-" (:name part)))

(has-matching-part? {:name "left-eye"})
(has-matching-part? {:name "some-text"})

;; --------------------
;; string replacement.
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-eye" :size 1})

;;; 4.6 - Short symmetrizer with reduce
;; The pattern of 'process each element and process in a sequence and
;; build a result' is so common that there is a function for it: reduce

;; sum with reduce
(reduce + [1 2 3 7])

;; also `reduce` can take initial value
(reduce + 5 [2 6 7])

;;; ==================================================
;;; ----- http://clojure-notes.rubylearning.org/ -----
;;; ==================================================

;;; Comments
(comment
  (load-file "src/clojure-noob/satish-talim.clj")
  (refer  'inspector)
  (inspect-tree  {:a  1  :b  2  :c  [1  2  3  {:d  4  :e  5  :f  [6  7  8]}]})
  (inspect-table  [[1  2  3] [4  5  6] [7  8  9] [10  11  12]])
  )


(println "You are" (/ 979000000 60.0 60 24 365) "years old")


;;; empty list
()

(class ())

;;; Sets
#{}
(class #{})
#{:a :b :c}

(sorted-set "Mandy" "Anita" "Rich")
(hash-set "Mandy" "Anita" "Rich")       ;are faster than sorted set

(hash-set "Mandy" "Anita" "Mandy" "Rich")       ; duplicates are removed

;;; Maps(dictionaries)
{}                                      ;empty
(class {})                              ;same thing

{:ruby "Matz" :clojure "Hickey"}

(def inventors  {:ruby "Matz" :clojure "Hickey"})

(:clojure inventors)                    ;=> Hickey

;;; Usage: (keys map)
(keys inventors)

;;; Values: (vals map)
(vals inventors)

;;; Count function
(count [22 "green" false])

;;; Reverse
(reverse "sachin")
(reverse [2 3 4 5 67])

;;; 'apply' function: The apply function returns the result of a given
;;; function when all the items in a given collection are used as
;;; arguments.

(apply - [12 9 1])                      ;=> 1


;;; map function
;;; Usage: (map f coll)
;;; map takes a source collection coll and a function f, and it
;;; returns a new sequence by invoking f on each element in the coll.

(map * [1 2 8 2] [2 3 0 9])             ; => (2 6 0 18)



;;; ====================

(first [5 6 7 99]) ;=> 5

(rest [5 6 7 99])  ;=> 6 7 99

(cons 1 [2 3 4])                        ;construct a new sequence


(range  10  20  2)


;;; cond, condp
;;; is like 'case'
(def x 10)
(cond
 (< x 0) (println "Negative")
 (= x 0) (println "Zero!"))

(cond
 (< x 0) (println "Negative")
 (= x 0) (println "Zero!")
 :default (println "Positive"))

;;; ---

(condp = 1
  1 "Clojure"
  2 "Ruby"
  3 "Java"
  "Sorry, no match")

(condp = 5
  1 "Clojure"
  2 "Ruby"
  3 "Java"
  "Sorry, no match")


;;; when, when-not
(when true
  "do-this-first"
  "then-that"
  "finally-this"
  )

(when-not false
  "do-this-first"
  "then-that"
  "finally-this"
  )


;;; functions
(defn my-function
  "My custom function"
  [name]
  (str "Hello, " name))

(my-function "clojure-noob")

;;; --------------------

(.toUpperCase "hello")
(.length "tintin")

;;; Example
(defn parse
  "Parse helper function."
  [s]
  (try (Double/parseDouble (.trim s))
       (catch NumberFormatException e (prn "Numbers not supported."))))

(parse "3")

;;; --------------------

(use 'clojure.inspector)

;; (inspect (System/getProperties))

(println (gcd 27 81))
(println (sqrt 7))
(println (.format (NumberFormat/getInstance) Math/PI))

;; ====================

; the code below requires you to have knowledge of the Java programming language
; also see the generated image below
(doto (JFrame. "Hello")
  (.add (JLabel. "Hello, World!"))
  (.pack)
  (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
  (.setVisible true))




