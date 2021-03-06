(ns ranking.index.index-controller
  (:require [compojure.core :refer :all ]
            [joodo.views :refer [render-template render-html]]
            [chee.datetime :refer [now]]
            [ring.util.response :refer [redirect]]
            [joodo.views :refer [render-template render-html]]
            [joodo.env :refer [env *env*]]
            [hyperion.api :refer :all]
            ))

(defn- do-index []
  (let [jugadores (find-by-kind :jugadores :limit 10 :sorts [:puntos :desc])
        torneos (find-by-kind :torneos :limit 10)
        ]
    (render-template "index/index" :jugadores jugadores :torneos torneos))
  )

(defroutes index-controller
  (GET "/index" [] (do-index)))
    ;(context "/index" []
      ;(GET "/index" [] (do-index))
      ;(POST "/sign-now" {params :params} (do-sign-now (params :project-key ) (params :iteration-number )))))
