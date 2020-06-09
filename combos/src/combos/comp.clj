(ns combos.comp
  (:gen-class))

; simply check and flip the predicate
(def non-pos? (complement pos?))

(def non-zero? (fn [x] (not (zero? x))))

(defn complementgg
  [f & args]
  (not (apply f args)))

(def nz? (complementgg zero?))

(comment

  (pos? 100)
  (non-pos? 100)
  (non-pos? -100)
  
  ; example of what the impl looks like
  (non-zero? 0)
  (non-zero? 1)
  
  (nz? 0)
  (nz? 1)
  
  ; return non-zero
  (filter (complement zero?) [1 2 3 0 5 6])
  
  
  
  
  )