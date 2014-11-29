(ns leiningen.new.gsn-spa
  (:require [clojure.string :as s]
            [leiningen.new.templates
             :refer [->files name-to-path project-name renderer sanitize-ns year]]
            [leiningen.core.main :as main]))

(defn gsn-spa
  [name]
  (let [render (renderer "gsn-spa")
        ns (sanitize-ns name)
        data {:raw-name name
              :name (project-name name)
              :namespace ns
              :path (name-to-path ns)
              :year (year)}]
    (main/info "Generating a project called" name "based on the 'gsn-spa' template.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE")]
             [".gitignore" (render "gitignore")]
             ["resources/logback.xml" (render "logback.xml")]

             ["src/{{path}}/config.clj" (render "config.clj" data)]
             ["src/{{path}}/ws.clj" (render "ws.clj" data)]
             ["src/{{path}}/server.clj" (render "server.clj" data)]
             ["src/{{path}}/app.clj" (render "app.clj" data)]
             ["src/{{path}}/run.clj" (render "run.clj" data)]
             ["src/{{path}}/ws.clj" (render "ws.clj" data)]
             ["src/{{path}}/system.clj" (render "system.clj" data)]
             ["dev/user.clj" (render "user.clj" data)]

             ["src/{{path}}/client/ws.cljs" (render "ws.cljs" data)]
             ["src/{{path}}/client/app.cljs" (render "app.cljs" data)]
             ["src/{{path}}/client/views.cljs" (render "views.cljs" data)]
             ["dev/start.cljs" (render "start.cljs" data)]

             ["resources/public/css/style.css" (render "style.css")]
             ["resources-index/dev/index.html" (render "index_dev.html" data)]
             ["resources-index/prod/index.html" (render "index.html" data)])))
