(ns asunc.core
  (:gen-class)
  (:require [clojure.core.async :as a]))

(defn do1 []
  (let [mychan1 (a/chan)
        mychan2 (a/chan)]
    (a/go
     (let [op1 (a/<! mychan1)
           op2 (a/<! mychan2)]
       (println (str op1 " hello " op2))))
    
    (a/go
     (Thread/sleep 1000)
     (a/>! mychan1 "oper 1"))
    
    (a/go
     (Thread/sleep 3000)
     (a/>! mychan2 "oper 2"))))

(comment
  
  (println "hello world")
  (do1)
  
  )