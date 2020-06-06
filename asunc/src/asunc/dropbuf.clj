(ns asunc.dropbuf
  (:gen-class)
  (:require [clojure.core.async :as a]))

(defn do1 []
  (let [mychan (a/chan (a/dropping-buffer 10))]
    (a/go-loop
     []
     (let [part (a/<! mychan)]
       (if part
         (do
           (println (str "got part " part))
           (Thread/sleep 333)
           (recur))
         (println "all done getting parts"))))
    
    (a/go-loop
     [cntr 0]
     (if (a/>! mychan (str "part-" cntr))
       (do
        ;  (println (str "added part " cntr))
         (Thread/sleep 111)
         (recur (inc cntr)))
       (println "all done adding parts")))
    
    (a/go
     (Thread/sleep 11111)
     (a/close! mychan)
     (println "closed channel"))))

(comment
  
  (do1)
  
  )