(ns fifo.lifo
  (:gen-class))

;; can use seq or vector
(def todos (atom []))

(defn add-todo! [task]
  (swap! todos conj task))

(defn get-todo! []
  (let [[old _] (swap-vals! todos pop)]
    (peek old)))

(comment
  
  (do
    ;; add
    (add-todo! "step 1")
    (add-todo! "step 2")
    (add-todo! "step 3")
    
    ;; then get
    (println (get-todo!)))

  )