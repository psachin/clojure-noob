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

