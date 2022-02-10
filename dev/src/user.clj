(ns user
  (:require
    [integrant.repl :as ig-repl]
    [integrant.core :as ig]
    [integrant.repl.state :as state]
    [cheffy.server]
    [next.jdbc :as jdbc]
    [next.jdbc.sql :as sql]))

(ig-repl/set-prep!
  (fn [] (-> "resources/config.edn" slurp ig/read-string)))

(def go ig-repl/go)
(def halt ig-repl/halt)
(def reset ig-repl/reset)
(def reset-all ig-repl/reset-all)

(def app (-> state/system :cheffy/app))
(def db (-> state/system :db/postgres))

(comment

  (sql/update!
    db
    :recipe
    {:name "new name"}
    {:recipe-id "a3dde84c-4a33-45aa-b0f3-4bf9ac99768"})

  (-> (app {:request-method :get
            :uri            "/v1/recipes"})
      :body
      (slurp))

  (-> (app {:request-method :post
            :uri            "/v1/recipes"
            :body-params    {:name      "first recipe"
                             :prep-time 40
                             :img       "image-url"}})
      :body
      (slurp))

  (set! *print-namespace-maps* false)

  (go)
  (halt)
  (reset))