(ns ranking.root
  (:use
    [ring.util.response :only [redirect]]
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]
    [hyperion.api]
    [hyperion.sqlite]
    ))


(set-ds! (new-datastore :implementation :sqlite :connection-url "jdbc:sqlite:data/ranking.db" :database "ranking"))


(defroutes ranking-routes
  (GET "/" [] (redirect "/index"))
  (controller-router 'ranking)
  (not-found (render-template "not_found" :template-root "ranking/util" :ns `ranking.view.view-helpers)))

(def app-handler
  (->
    ranking-routes
    (wrap-view-context :layout "util/layout" :template-root "ranking" :ns `ranking.view.view-helpers)))

