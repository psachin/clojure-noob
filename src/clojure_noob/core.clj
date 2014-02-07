(ns clojure-noob.core
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

(get {a: 0 :b 1} :b)

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


















