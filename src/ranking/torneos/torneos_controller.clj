(ns ranking.torneos.torneos-controller
  (:require [compojure.core :refer :all ]
            [joodo.views :refer [render-template render-html]]
            [chee.datetime :refer [now]]
            [ring.util.response :refer [redirect]]
            [joodo.views :refer [render-template render-html]]
            [joodo.env :refer [env *env*]]
            [hyperion.api :refer :all]
            [ranking.torneos.torneos-presenter :as presenter :refer [index]]
            ))

(defn- do-torneos []
  (let  [torneos (find-by-kind :torneos)]
    (render-template "torneos/torneos" :torneos torneos))
  )

(defn- do-torneo [key]
  (let [torneo (find-by-key key)]
    (render-template "torneos/torneo" :torneo torneo :participantes (presenter/index key))
    )
  )

(defroutes torneos-controller
  (GET "/torneos" [] (do-torneos))
  (context "/torneos" []
    (GET "/:key" [key] (do-torneo key)
      )
    )
  )
