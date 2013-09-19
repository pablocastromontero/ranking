(list
  [:h1.SectionTitle "Detalle"]
  [:table {}
   (let [jugador (:jugador *view-context*)]
     (list
       [:tr {}
        [:td "Nombre"] [:td (:nombre jugador)]
        ]
       [:tr {}
        [:td "Puntos"] [:td (:puntos jugador)]
        ]
       )
     )
   ]
  [:h1.SectionTitle "Participaciones en Torneo"]
  [:table {}
   [:thead {}
    [:tr
     [:th "Nombre Torneo"]
     [:th "Fecha"]
     [:th "Posicion"]
     [:th "Puntos"]
     ]
    ]
   (for [posicion (:posiciones *view-context*)]
     [:tr {}
      [:td {}
       [:a {:href (format "/torneos/%s" (:torneo-key posicion))} (:nombre-torneo posicion)]
       ]
      [:td (:fecha-torneo posicion)]
      [:td (:posicion posicion)]
      [:td (:puntos posicion)]])
   ]
  )