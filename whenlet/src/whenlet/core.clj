(ns whenlet.core
  (:gen-class))

(comment
  
  
  (when-let [a true]
    a)
  
  (when-let [b false]
    b)
  
  (if-let [a true]
    a
    false)
  
  ; this will error because B is never defined because of being false
  (if-let [b false]
    true
    b)

  (if-let [is-empty (empty? [1 2 3])]
    "this is empty"
    "list not empty")
  
  (if-some [a false] :true :false)   ; => :true
  (if-some [a nil]   :true :false)   ; => :false

)