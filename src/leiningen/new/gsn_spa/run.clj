(ns {{namespace}}.run
  (:gen-class)
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [{{namespace}}.config :as config]
            [{{namespace}}.system :refer [system]]))

(defn -main [& args]
  (let [config (config/get-config)]
    (component/start (system config))
    (log/info "{{name}} started")))
