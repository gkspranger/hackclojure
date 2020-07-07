(ns asyncfun.worker
  (:require [clojure.core.async :as a]
            [mount.core :refer [defstate]]))

(defstate chan
  :start (let [chan (a/chan)]
           (a/go-loop
            []
            (let [message (a/<! chan)
                  msg-chan (first message)
                  msg-str (last message)]
              (println "worker was called")
              (a/>! msg-chan (str msg-str " this is the gravy")))
            (recur))
           chan))
