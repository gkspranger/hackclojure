(ns checker.plugins.status)

(def ok {:status "OK"})
(def warning {:status "WARNING"})
(def critical {:status "CRITICAL"})
(def unknown {:status "UNKNOWN"})

(defn compose
  ([status description] (assoc status :description description))
  ([status description statistics] (assoc status
                                          :description description
                                          :statistics statistics)))
