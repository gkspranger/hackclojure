(ns multimeth.core
  (:gen-class))

(defmulti process-data
  (fn [data] (data :command)))

(defmethod process-data "do-addition" [data]
  (reduce + (data :data)))

(defmethod process-data "do-subtraction" [data]
  (reduce - (data :data)))

(defmethod process-data :default [data]
  data)

(comment
  
  (process-data {:command "do-addition"
                 :data [1 2 3]})

  (process-data {:command "do-subtraction"
                 :data [20 10 5]})
  
  (process-data {:command "do-whatever"
                 :data [20 10 5]})

  )