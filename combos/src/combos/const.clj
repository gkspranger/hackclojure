(ns combos.const
  (:gen-class))

(def always5 (constantly 5))

(defn constantlygg
  [x]
  (fn [& _] x))

(def always100 (constantlygg 100))

(comment
  
  (always5 5)
  (always5 10)
  (always5 5 10 15 nil [1 2 3])
  
  (always100 123 123 123)
  
  ; good for when you have to return a function that always returns an expexted value
  (update [1 2 3] 2 inc)
  (update [1 2 3] 2 always100)
  ; or when you need to return a consistent value in a map
  (map (constantly "hello") (range 10))
  
  
  
  
  )