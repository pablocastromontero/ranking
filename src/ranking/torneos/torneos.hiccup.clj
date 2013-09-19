(list
  [:h1.SectionTitle "Torneos"]
  [:table {}
   [:thead {}
    [:tr {}
     [:th "Nombre"]
     [:th "Fecha"]
     [:th "Participantes"]]]
   (for [torneo (:torneos *view-context*)]
     [:tr {}
      [:td {}
       [:a {:href (format "/torneos/%s" (:key torneo))} (:nombre torneo)]
       ]
      [:td (:fecha torneo)]
      [:td (:participantes torneo)]])
   ]
  )