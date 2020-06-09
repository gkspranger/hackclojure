(ns combos.iden
  (:gen-class))

(defn identitygg [x]
  x)

(comment


  (identity 100)
  (identity :somekeyword)
  (identitygg 100)
  
  ; can be used to filter things
  (filter identity [1 2 3 nil 5 6 7])
  
  )