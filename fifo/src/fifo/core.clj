(ns fifo.core
  (:gen-class))

(def myq (clojure.lang.PersistentQueue/EMPTY))

(comment
  
  (println "hello world")
  
  (rest [1 2 3 4])
  (rest '(1 2 3 4))
  
  (prn myq)
  
  (peek (conj myq 1 2 3))
  
  (vec (pop (conj myq 1 2 3)))

  )