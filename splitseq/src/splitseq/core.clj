(ns splitseq.core
  (:gen-class))

(def myvec [1 2 3])
(def mylgvec (range 1 30))
(def mymegavec (vec (range 1 1000)))

(def mysubvec (subvec (vec (range 1 1000)) 500))

(comment
  
  ; this is considered slow
  (take 15 mylgvec)
  (drop 15 mylgvec)
  
  (println (.start mysubvec))
  
  (count mymegavec)
  (subvec mymegavec 0 200)
  (subvec mymegavec 200 400)
  
  (remove #(<= % 20) mylgvec)
  
  
  )
