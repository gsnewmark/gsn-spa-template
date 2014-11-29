(ns {{namespace}}.config
  (:require [environ.core :refer [env]]))

(defn get-config []
  {:port (Integer/parseInt (env :{{name}}-port))})
