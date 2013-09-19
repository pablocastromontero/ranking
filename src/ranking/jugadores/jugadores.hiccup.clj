(list
  [:h1.SectionTitle "Jugadores"]
  [:table {}
   [:thead {}
    [:tr {}
     [:th "Nombre"]
     [:th "Puntos"]]]
   (for [jugador (:jugadores *view-context*)]
     [:tr {}
      [:td {}
       [:a {:href (format "/jugadores/%s" (:key jugador))} (:nombre jugador)]
       ]
      [:td (:puntos jugador)]])
   ]
  )