;[:div {:style "text-align: center;"}
; [:h1 "Vale por una pagina de inicio..."]]
(list
  [:h1.SectionTitle "Jugadores"]
  [:table {}
   [:thead {}
    [:tr {}
     [:th "Name"]
     [:th "Puntos"]]]
   (for [jugador (:jugadores *view-context*)]
     [:tr {}
      [:td {}
       [:a {:href (format "/jugador/%s" (:id jugador))} (:nombre jugador)]
      ]
      [:td (:puntos jugador)]])
   ])