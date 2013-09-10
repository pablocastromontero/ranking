(ns ranking.root
  (:use
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes ranking-routes
  (GET "/" [] (render-template "index"))
  (controller-router 'ranking.controller)
  (not-found (render-template "not_found" :template-root "ranking/view" :ns `ranking.view.view-helpers)))

(def app-handler
  (->
    ranking-routes
    (wrap-view-context :template-root "ranking/view" :ns `ranking.view.view-helpers)))

