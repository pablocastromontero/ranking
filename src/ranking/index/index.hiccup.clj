;[:div {:style "text-align: center;"}
; [:h1 "Vale por una pagina de inicio..."]]
(list
  [:h1.SectionTitle [:a {:href "/jugadores"} "Jugadores"]]
  [:table {}
   [:thead {}
    [:tr {}
     [:th "Nombre"]
     [:th "Puntos"]]]
   (for [jugador (:jugadores *view-context*)]
     [:tr {}
      [:td {}
       [:a {:href (format "/jugador/%s" (:key jugador))} (:nombre jugador)]
      ]
      [:td (:puntos jugador)]])
   ]

  [:h1.SectionTitle [:a {:href "/torneos"} "Torneos"] ]
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