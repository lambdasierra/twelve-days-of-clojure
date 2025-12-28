(ns twelve-days-of-clojure.test-harness)

(defn cleanup []
  (when (find-ns 'twelve-days-of-clojure.song)
    (remove-ns 'twelve-days-of-clojure.song)))

(defn run []
  (cleanup)
  (require 'twelve-days-of-clojure.song :reload))

