(ns eval.core
  (:gen-class))

(defn assemble [op arg1 arg2]
  (list op arg1 arg2))

(comment 
  
  (assemble '+ 1 2)
  (eval `(+ 1 2))
  (eval (assemble '+ 1 2))
  
  
  )