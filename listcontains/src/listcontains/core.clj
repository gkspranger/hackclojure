(ns listcontains.core
  (:require [clojure.string :refer [capitalize]]
            [clojure.java.io :as io]))

(def myvec [1 2 3 4 5])
(def myset (set (range 1000)))
(def mymap {:a 1 :b 2 :c 3})

(println (capitalize "hello world"))

(def directory (io/file "./"))
(def directory-items (file-seq directory))
(def files (filter #(.isFile %) directory-items))

; (println files)

(loop [f files]
  (if (empty? f)
    true
    (do
      (println (.getName (first f)))
      (recur (rest f)))))

(comment
  
  (println "hello world")
  (print myvec)
  (count myset)
  
  ; lookup is the key
  (contains? myvec 0)
  (contains? myvec 5)
  
  (contains? myset 10)
  (contains? myset "10")
  
  (contains? mymap :a)
  (contains? mymap :d)
  (contains? mymap 1)
  
  )