(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "ranking"]
  (include-css "/stylesheets/ranking.css")
  (include-js "/javascript/ranking.js")]
 [:body
  (eval (:template-body joodo.views/*view-context*))
]]