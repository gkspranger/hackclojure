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

(defn do2 []
  (let [mychan1 (a/chan)]
    (a/go-loop
     [cntr 0]
     (let [op1 (a/<! mychan1)]
       (if op1
         (do
           (println (str op1 " hello "))
           (Thread/sleep 333)
           (recur (inc cntr)))
         (println "all done"))))
    
    (a/go-loop
     [cntr 0]
     (a/>! mychan1 (str "op1-" cntr))
     (Thread/sleep 333)
     (recur (inc cntr)))
    
    (a/go
     (Thread/sleep 11111)
     (a/close! mychan1)
     (println "closed channel"))))

(defn do3 []
  (let [mychan1 (a/chan 10)]
    (a/go-loop
     []
      (let [op1 (a/<! mychan1)]
        (if op1
          (do
            (println (str "got part " op1))
            (Thread/sleep 333)
            (recur))
          (println "all done getting parts"))))

    (a/go-loop
     [cntr 0]
     (if (a/>! mychan1 (str "part-" cntr))
       (do
         (println (str "added part " cntr))
         (Thread/sleep 222)
         (recur (inc cntr)))
       (println "all done adding parts")))
    
    (a/go
     (Thread/sleep 11111)
     (a/close! mychan1)
     (println "closed channel"))))

(comment
  
  (println "hello world")
  (do1)
  (do2)
  (do3)
  
  )