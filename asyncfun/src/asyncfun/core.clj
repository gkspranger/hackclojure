(ns asyncfun.core
  (:require [clojure.core.async :as a]
            [mount.core :as mount]
            [asyncfun.worker :as worker])
  (:gen-class))


(defn -main [str]
  (mount/start)
  (Thread/sleep 3000)
  
  (let [chan (a/chan)]
    (a/go (println (a/<! chan)))
    (a/go (a/>! worker/chan [chan str]))
    :ok))

(comment
  
  (-main "123")
  (-main "hello world")
  
  (mount/stop)
  
  )